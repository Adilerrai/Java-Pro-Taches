package org.example;

import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;

import org.example.model.Livre;
import org.example.model.Enum.TypeLivre;
import org.example.service.DAO.LivreDAO;
import org.example.service.DaoImplementation.*;

public class Main {
    public static void main(String[] args) throws SQLException{
        DAOImplementation daoimpl = new DAOImplementation();

        Livre livre = new Livre(1, "jean", "jean", "POLICIER", 1444) ;


        System.out.println(daoimpl.getLivres().get(0).getTypeDuLivre(). );
    }
}
