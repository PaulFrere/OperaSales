package security;

import dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import repository.UserRepo;

@Component
public class MyUserService implements UserDetailsService {
    private UserRepo repo;

    @Autowired
    public MyUserService(UserRepo repo){
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User byLogin = repo.findByLogin(username);
        if (byLogin == null){
            throw new UsernameNotFoundException("User not found");
        }
        return byLogin;
    }
}
