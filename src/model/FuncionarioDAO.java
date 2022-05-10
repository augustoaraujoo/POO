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

    public int salvar(FuncionarioEncapsulamento funcionario) {
        try {
            st = conexao.prepareStatement("INSERT INTO funcionarios values (?,?,?,?)");
            st.setInt(1, funcionario.getMatricula());
            st.setString(2, funcionario.getNome());
            st.setString(3, funcionario.getCargo());
            st.setDouble(4, funcionario.getSalario());
            st.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            
            if (ex.getErrorCode() == 1062) {
                // erro 1062 : chave pk já existente!
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return 1062;
            }
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;

        }
    }

}
