package web.dao;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDAOImpl implements IUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void add(User user) {
        System.out.println(user.toString());
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void delete(long id) {
        Query query = entityManager.createQuery("delete from User u where u.id = ?1");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    @Override
    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public User update(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<User> findUser(String model, String series) {

        Query query = entityManager
                .createQuery("from User where car.model = (?1) and car.series = (?2)");
        query.setParameter(1, model);
        query.setParameter(2, series);
        return query.getResultList();
    }

}
