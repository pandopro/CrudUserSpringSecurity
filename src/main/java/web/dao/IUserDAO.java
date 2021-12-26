package web.dao;

import org.springframework.security.core.userdetails.UserDetails;
import web.model.User;

import java.util.List;

public interface IUserDAO {
    void add(User user);

    void delete(long id);

    User get(long id);

    User update(User user);

    List<User> listUsers();

    UserDetails loadUserByUsername(String s);
}
