package web.dao;

import org.springframework.security.core.userdetails.UserDetails;
import web.model.Role;
import web.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            entityManager.persist(role);
        }
        entityManager.persist(user);
    }


    @Override
    public void delete(long id) {

        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);

        }

    }

    @Override
    public User get(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public User update(User user) {
        Set<Role> roles = entityManager.find(User.class, user.getId()).getRoles();
        user.setRoles(roles);
        entityManager.merge(user);
        return user;
    }

    @Override
    //  @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        Query query = entityManager.createQuery("from User u JOIN FETCH u.roles where u.email = (?1)");
        query.setParameter(1, username);
        return (UserDetails) query.getSingleResult();
    }

}
