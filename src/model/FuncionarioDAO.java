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
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5433/funcionario", "postgres", "root");
            JOptionPane.showMessageDialog(null, "conectado");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showConfirmDialog(null, "error " + ex.getMessage());
            return false;
        }
    }
 
    public int salvarFuncionarioDB(FuncionarioEncapsulamento funcionario) {
        try {
            st = conexao.prepareStatement("INSERT INTO tabela values (?,?,?,?)");
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

    public FuncionarioEncapsulamento pesquisarFuncionarioMatricula(int matricula) {
        FuncionarioEncapsulamento funcionario;

        String nome, cargo;
        int salario;

        try {
            st = conexao.prepareStatement("SELECT * from tabela where matricula=$1");
            st.setInt(1, matricula);
            resultado = st.executeQuery();

            if (resultado.next()) {
                funcionario = new FuncionarioEncapsulamento();

                matricula = resultado.getInt("matricula");
                nome = resultado.getString("nome");
                cargo = resultado.getString("cargo");
                salario = resultado.getInt("salario");

                funcionario.FuncionarioEncapsulamento(matricula, nome, cargo, salario);

                return funcionario;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
