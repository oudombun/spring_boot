package mybatis.service;

import mybatis.repository.model.User;
import mybatis.repository.model.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {
    /*user detail*/
    @Autowired
    private UserDetailRepo userDetailRepo;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDetailRepo.loadUserByUsername(s);
        return null;
    }
}
