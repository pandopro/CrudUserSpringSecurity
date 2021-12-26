package web.service;

import web.model.User;

import java.util.List;

public interface IUserService {
    void add(User user);

    void delete(long id);

    User get(long id);

    User update(User user);

    List<User> listUsers();

}
