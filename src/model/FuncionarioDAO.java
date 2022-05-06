package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FuncionarioDAO {

    private Connection conexao;
    private PreparedStatement st;
    private ResultSet resultado;

    public boolean conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5433/padaria", "postgres", "root");
            JOptionPane.showMessageDialog(null, "conectado");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showConfirmDialog(null, "error " + ex.getMessage());
            return false;
        }
    }
}
