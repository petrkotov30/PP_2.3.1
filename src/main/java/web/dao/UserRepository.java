package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private User user;

    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    public void update(User updateUser, Long id) {
        user = getUser(id);
        user.setName(updateUser.getName());
        user.setLastName(updateUser.getLastName());
        user.setAge(updateUser.getAge());
        entityManager.merge(user);
    }

    public void deleteUser(Long id) {
        user = getUser(id);
        entityManager.remove(user);
    }
}
