package MyApp.service;

import MyApp.dao.UserDao;
import MyApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDaoImpl;

    @Autowired
    public UserServiceImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }


    @Override
    public void addUser(String name, String lastname, int age) {
        userDaoImpl.addUser(name, lastname, age);
    }

    @Override
    public void removeUserById(int id) {
        userDaoImpl.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoImpl.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDaoImpl.getUserById(id);
    }

    @Override
    public void updateUser(int id, String name, String lastname, int age) {
        userDaoImpl.updateUser(id, name, lastname, age);
    }
}
