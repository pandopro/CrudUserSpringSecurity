package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    void add(User user);

    void delete(long id);

    User get(long id);

    User update(User user);

    List<User> listUsers();

}
