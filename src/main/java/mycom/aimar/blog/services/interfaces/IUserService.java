package mycom.aimar.blog.services.interfaces;

import mycom.aimar.blog.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface IUserService {

    User getUserByEmail(String email);

    List<User> getUsers();

    void addUser (User user);
}
