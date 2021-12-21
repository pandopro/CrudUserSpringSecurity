package web.service;

import web.dao.IUserDAO;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserDAO userDAO;

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void delete(long id) {
        userDAO.delete(id);
    }

    @Override
    public User get(long id) {
        return userDAO.get(id);
    }

    @Override
    public User update(User user) {
        return userDAO.update(user);
    }

    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Override
    public List<User> findUser(String model, String series) {
        return userDAO.findUser(model, series);
    }
}
