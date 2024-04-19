package org.example.service.DAO;

import org.example.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public void addUser(User user) throws SQLException;
    public void deleteUser(int id) throws SQLException;
    public User getUser(int id) throws SQLException;
    public List<User> getUsers();
    public void updateUser(User user);
}
