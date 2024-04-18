package org.example.service.DAO;

import java.sql.SQLException;
import java.util.List;

import org.example.model.Livre;

public interface LivreDAO { 
    public int addLivre(Livre liv) throws SQLException; 

    public void delete(int id) throws SQLException;
    
    public Livre getLivre(int id) throws SQLException;
    
    public List<Livre> getLivres() throws SQLException;
    
    public void update(Livre emp) throws SQLException;
}
