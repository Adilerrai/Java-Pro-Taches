package org.example.service.DaoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.database.DatabaseConnection;
import org.example.model.Livre;
import org.example.service.DAO.LivreDAO;

public class LivreDAOImpl implements LivreDAO {

    static Connection con =  DatabaseConnection.getConnection();

    @Override
    public int addLivre(Livre liv) throws SQLException {

        String query = "INSERT  INTO livre (id, titre, Auteur, typeLivre, ISBN) VALUES(?,?,? ,? ,?) ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, liv.getId());
        ps.setString(2, liv.getTitre());
        ps.setString(3, liv.getAuteur());
        ps.setString(4, liv.getTypeDuLivre());
        ps.setLong(5, liv.getISBN());
        int n = ps.executeUpdate();
        return n;

    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM livre where id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
    }

    @Override
    public Livre getLivre(int id) throws SQLException {

            String query = "SELECT * FROM livre where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet n = ps.executeQuery();
            Livre liv = new Livre();
            boolean check = false;
        while  (n.next()) {
                check = true;
                liv.setAuteur(n.getString("auteur"));
                liv.setId(n.getInt("id"));
                liv.setTypeDuLivre(n.getString("typelivre"));
                liv.setTitre(n.getString("titre"));
            }if (check == true) {
            return liv;
        }
        else
            return null;
    }

    public List<Livre> getLivres()
            throws SQLException
    {
        String query = "select * from livre";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Livre> ls = new ArrayList();

        while (rs.next()) {
            Livre liv = new Livre();
            liv.setId(rs.getInt("id"));
            liv.setAuteur(rs.getString("auteur"));
            liv.setTitre(rs.getString("auteur"));
            liv.setISBN(rs.getLong("ISBN"));
            ls.add(liv);
        }
        return ls;
    }

    @Override
    public void update(Livre emp) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

     
}
