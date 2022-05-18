package view;

import business.funcionarioService;
import javax.swing.JOptionPane;
import model.FuncionarioDAO;
import model.FuncionarioEncapsulamento;

public class TelaFuncionarios extends javax.swing.JFrame {

    public TelaFuncionarios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMatricula = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        lblSalario = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle funcionários");
        getContentPane().setLayout(null);

        lblMatricula.setText("Matricula");
        getContentPane().add(lblMatricula);
        lblMatricula.setBounds(42, 29, 69, 32);

        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });
        getContentPane().add(txtMatricula);
        txtMatricula.setBounds(123, 29, 134, 32);

        lblNome.setText("Nome");
        getContentPane().add(lblNome);
        lblNome.setBounds(42, 86, 69, 32);

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome);
        txtNome.setBounds(123, 86, 134, 32);

        lblCargo.setText("Cargo");
        getContentPane().add(lblCargo);
        lblCargo.setBounds(42, 136, 69, 32);

        txtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCargo);
        txtCargo.setBounds(123, 136, 134, 32);

        lblSalario.setText("Salario");
        getContentPane().add(lblSalario);
        lblSalario.setBounds(42, 186, 69, 32);

        txtSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtSalario);
        txtSalario.setBounds(123, 186, 134, 32);

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 250, 100, 30);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar);
        btnPesquisar.setBounds(250, 250, 100, 30);

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoActionPerformed

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        boolean resposta;
        FuncionarioDAO DAO;
        DAO = new FuncionarioDAO();
        /* */
        boolean salarioCheck;
        /* / */
        String nome, cargo;
        int matricula;
        double salario;

        nome = txtNome.getText();
        cargo = txtCargo.getText();
        matricula = Integer.parseInt(txtMatricula.getText());
        salario = Double.parseDouble(txtSalario.getText());

        salarioCheck = funcionarioService.verificarSalario(Double.parseDouble(txtSalario.getText()));
        if (salarioCheck) {
            JOptionPane.showMessageDialog(null, "salário deve ser meno que 20 mil");
            return;
        }
        resposta = DAO.conectar();

        /* instânciando um objeto da classe funcionarioEncapsulamento :) */
        FuncionarioEncapsulamento funcionario;
        funcionario = new FuncionarioEncapsulamento();

        if (resposta) {
            DAO.salvarFuncionarioDB(funcionario);
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Erro conexão !");
        }

        funcionario.FuncionarioEncapsulamento(matricula, nome, cargo, salario);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        int matricula;
        boolean conectou;
        FuncionarioDAO DAO;

        DAO = new FuncionarioDAO();
        conectou = DAO.conectar();

        if (conectou) {
            matricula = Integer.parseInt(txtMatricula.getText().trim());
            DAO.pesquisarFuncionarioMatricula(matricula);
        }


    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void limparCampos() {
        txtNome.setText("");
        txtCargo.setText("");
        txtMatricula.setText("");
        txtSalario.setText("");
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}
