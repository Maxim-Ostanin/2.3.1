package MyApp.dao;

import MyApp.models.User;

import java.util.List;

public interface UserDao {
    void addUser(String name, String lastname, int age);

    void removeUserById(int id);

    List<User> getAllUsers();

    User getUserById(int id);

    void updateUser(int id, String name, String lastname, int age);

}
