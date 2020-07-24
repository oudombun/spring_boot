package mybatis.configuration.customHandler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        System.out.println("checking role");
        System.out.println(httpServletRequest.getRequestURL());
        httpServletRequest.getSession().setAttribute("REDIRECT_URL",httpServletRequest);
        try {
            httpServletResponse.sendRedirect("/login");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
