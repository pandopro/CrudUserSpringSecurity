package web.dao;

import web.model.User;

import java.util.List;

public interface IUserDAO {
    void add(User user);

    void delete(long id);

    User get(long id);

    User update(User user);

    List<User> listUsers();

    List<User> findUser(String model, String series);
}
