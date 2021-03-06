/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.view;

import br.com.librecommerce.controller.FuncionarioController;
import br.com.librecommerce.modelo.Funcionario;
import br.com.librecommerce.modelo.abstractTableModel.FuncionarioTableModel;
import br.com.librecommerce.util.Messages;
import java.util.List;

/**
 *
 * @author Clovis
 */
public class PesquisaFuncionarioView extends javax.swing.JDialog {

    private FuncionarioTableModel funcionarioTableModel = new FuncionarioTableModel();
    private Funcionario funcionario;
    private boolean funcionarioSelecionado;

    /**
     * Creates new form PesquisaFuncionarioView
     */
    public PesquisaFuncionarioView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNomeFuncionario = new javax.swing.JTextField();
        btnSelecionar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LibreCommerce - Pesquisa Funcionário");
        setResizable(false);

        jLabel1.setText("Nome do Funcionário:");

        btnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/selecionar.png"))); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.setEnabled(false);
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tblFuncionarios.setModel(funcionarioTableModel);
        tblFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFuncionarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNomeFuncionario)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSelecionar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionar)
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        if (txtNomeFuncionario.getText().trim().equals("")) {
            Messages.alertMessage(this, "Informe o nome do Funcionário!");
        } else {
            List<Funcionario> funcionarios
                    = new FuncionarioController().buscaFuncionariosPorNome(txtNomeFuncionario.getText());
            if (funcionarios == null || funcionarios.isEmpty()) {
                Messages.alertMessage(this, "Nenhum funcionario encontrado!");
            } else {
                this.funcionarioTableModel.addAll(funcionarios);
            }
        }
        txtNomeFuncionario.setText("");
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        this.funcionarioSelecionado = true;
        this.funcionario = this.funcionarioTableModel.getFuncionario(tblFuncionarios.getSelectedRow());
        this.dispose();
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void tblFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionariosMouseClicked
        this.btnSelecionar.setEnabled(true);
    }//GEN-LAST:event_tblFuncionariosMouseClicked

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public boolean isFuncionarioSelecionado() {
        return funcionarioSelecionado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTextField txtNomeFuncionario;
    // End of variables declaration//GEN-END:variables
}
