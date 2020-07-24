package mybatis.configuration.customHandler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        /*way 1*/
        String REDIRECT="";
        for (GrantedAuthority grantedAuthority:authentication.getAuthorities()){
            if (grantedAuthority.toString().equals("ROLE_ADMIN")){
                REDIRECT="/admin";
            }else if(grantedAuthority.toString().equals("ROLE_API")){
                REDIRECT="/";
            }else {
                REDIRECT="/user";
            }
        }
//        try {
//            httpServletResponse.sendRedirect(REDIRECT);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String url = httpServletRequest.getSession().getAttribute("REDIRECT_URL").toString();
        try {
            httpServletResponse.sendRedirect(REDIRECT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*way 2*/
//        authentication.getAuthorities().forEach(role->{
//            try {
//                if(role.toString().equals("ROLE_ADMIN")){
//                    httpServletResponse.sendRedirect("/admin");
//
//                }else{
//                    httpServletResponse.sendRedirect("/user");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
    }
}
