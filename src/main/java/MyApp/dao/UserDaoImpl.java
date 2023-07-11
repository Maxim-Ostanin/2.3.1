package MyApp.dao;

import MyApp.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void addUser(String name, String lastname, int age) {

        User user = new User(name, lastname, age);
        em.persist(user);

    }

    @Override
    @Transactional
    public void removeUserById(int id) {

        User user = em.find(User.class, id);
        em.remove(user);

    }

    @Override
    @Transactional
    public List<User> getAllUsers() {

        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public User getUserById(int id) {

        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public void updateUser(int id, String name, String lastname, int age) {

        User user = em.find(User.class, id);
        user.setName(name);
        user.setLastName(lastname);
        user.setAge(age);

    }
}
