package org.example.service.DaoImplementation;

import org.example.database.DatabaseConnection;
import org.example.model.User;
import org.example.service.DAO.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDAOimpl implements UserDAO {
    static Connection con =  DatabaseConnection.getConnection();
    //    public User( )

    @Override
    public void addUser(User user) throws SQLException {
            String query = "INSERT INTO  Utilisateur (  nom,  prenom,  phone,  adresse,  email, sexe) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, user.getId());
        ps.setString(2, user.getNom());
        ps.setString(3, user.getPrenom());
        ps.setString(4, user.getPhone());
        ps.setString(5, user.getAdresse());
        ps.setString(6, user.getEmail());
        ps.setString(7, user.getSexe());
        int n = ps.executeUpdate();
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        String query = "DELETE FROM Utilisateur where id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

    }

    @Override
    public User getUser(int id) throws SQLException {
        String query = "SELECT * FROM Utilisateur where id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        boolean check = false;

        while (ps.executeQuery().next()) {
            check = true;

            User user = new User(id,
                    ps.executeQuery().getString("nom"),
                    ps.executeQuery().getString("prenom"),
                    ps.executeQuery().getString("phone"),
                    ps.executeQuery().getString("adresse"),
                    ps.executeQuery().getString("email"),
                    ps.executeQuery().getString("sexe"));
        }if (check == true) {
            return new User(id,
                    ps.executeQuery().getString("nom"),
                    ps.executeQuery().getString("prenom"),
                    ps.executeQuery().getString("phone"),
                    ps.executeQuery().getString("adresse"),
                    ps.executeQuery().getString("email"),
                    ps.executeQuery().getString("sexe"));
        } else {
            return null;

        }}

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }
}
