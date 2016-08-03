/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.view;

import br.com.librecommerce.controller.CidadeController;
import br.com.librecommerce.controller.ClienteController;
import br.com.librecommerce.controller.EstadoController;
import br.com.librecommerce.modelo.Cidade;
import br.com.librecommerce.modelo.Cliente;
import br.com.librecommerce.modelo.Estado;
import br.com.librecommerce.modelo.comboBoxModel.CidadeCellRenderer;
import br.com.librecommerce.modelo.comboBoxModel.CidadeComboModel;
import br.com.librecommerce.modelo.comboBoxModel.EstadoCellRenderer;
import br.com.librecommerce.modelo.comboBoxModel.EstadoComboModel;
import br.com.librecommerce.util.Messages;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Clovis
 */
public class ClienteView extends javax.swing.JFrame {

    private EstadoComboModel estadoComboModel = new EstadoComboModel();
    private EstadoCellRenderer estadoCellRenderer = new EstadoCellRenderer();
    
    private CidadeComboModel cidadeComboModel = new CidadeComboModel();
    private CidadeCellRenderer cidadeCellRenderer = new CidadeCellRenderer();
    
    private PesquisaClienteView pesquisaClienteView;
    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    /**
     * Creates new form ClienteView
     */
    public ClienteView() {
        initComponents();
        carregaComboEstados();
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
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEndereço = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbEstados = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbCidades = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtCpfCnpj = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        btnCancelar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnNovaCidade = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LibreCommerce - Cadastro de Clientes");
        setResizable(false);

        jLabel1.setText("ID:");

        txtID.setEditable(false);

        jLabel2.setText("Nome:");

        jLabel3.setText("Endereço:");

        jLabel4.setText("Estado:");

        cbEstados.setRenderer(estadoCellRenderer);
        cbEstados.setModel(estadoComboModel);
        cbEstados.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbEstadosPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel5.setText("Cidade:");

        cbCidades.setRenderer(cidadeCellRenderer);
        cbCidades.setModel(cidadeComboModel);

        jLabel6.setText("CPF/CNPJ:");

        try {
            txtCpfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("Data Nascimento:");

        try {
            txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/atualizar.png"))); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setEnabled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/OK.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnNovaCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); // NOI18N
        btnNovaCidade.setText("Nova Cidade");
        btnNovaCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaCidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtNome))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndereço)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(cbCidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNovaCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEndereço, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbCidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAtualizar)
                    .addComponent(btnSalvar)
                    .addComponent(btnPesquisar)
                    .addComponent(btnNovo)
                    .addComponent(btnNovaCidade))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        clearFields();
        habilitaNovo();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void carregaComboEstados() {
        this.estadoComboModel.addAll(new EstadoController().buscarTodos());
    }
    
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        if (pesquisaClienteView == null) pesquisaClienteView = new PesquisaClienteView(this, true);
        pesquisaClienteView.setLocationRelativeTo(this);
        pesquisaClienteView.setVisible(true);
        if (pesquisaClienteView.isClienteSelecionado()) {
            Cliente cliente = pesquisaClienteView.getCliente();
            txtID.setText(String.valueOf(cliente.getId()));
            txtNome.setText(cliente.getNome());
            txtEndereço.setText(cliente.getEndereco());
            txtCpfCnpj.setText(cliente.getCpfCnpj());
            txtDataNascimento.setText(df.format(cliente.getDataNascimento()));
            habilitaAtualizar();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtNome.getText().trim().equals("") || cbCidades.getSelectedItem() == null) {
            Messages.alertMessage(this, "Informe o Nome e a Cidade!");
        } else {
            Cliente cliente = new Cliente();
            cliente.setNome(txtNome.getText());
            cliente.setEndereco(txtEndereço.getText());
            cliente.setCidade((Cidade) cbCidades.getSelectedItem());
            cliente.setCpfCnpj(txtCpfCnpj.getText());
            try {
                cliente.setDataNascimento(df.parse(txtDataNascimento.getText()));
            } catch (ParseException ex) {
                System.out.println("Erro..." + ex.getMessage());
            }
            if (new ClienteController().salvar(cliente)) {
                clearFields();
                Messages.infoMessage(this, "Cliente salvo!");
            } else {
                Messages.errorMessage(this, "Não foi possível realizar a operação!");
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if (txtNome.getText().trim().equals("") || cbCidades.getSelectedItem() == null) {
            Messages.alertMessage(this, "Informe o Nome e a Cidade!");
        } else {
            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(txtID.getText()));
            cliente.setNome(txtNome.getText());
            cliente.setEndereco(txtEndereço.getText());
            cliente.setCidade((Cidade) cbCidades.getSelectedItem());
            cliente.setCpfCnpj(txtCpfCnpj.getText());
            try {
                cliente.setDataNascimento(df.parse(txtDataNascimento.getText()));
            } catch (ParseException ex) {
                System.out.println("Erro..." + ex.getMessage());
            }
            if (new ClienteController().atualizar(cliente)) {
                clearFields();
                habilitaNovo();
                Messages.infoMessage(this, "Cliente atualizado!");
            } else {
                Messages.errorMessage(this, "Não foi possível realizar a operação!");
            }
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbEstadosPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbEstadosPopupMenuWillBecomeInvisible
        Estado estado = (Estado) cbEstados.getSelectedItem();
        this.cidadeComboModel.addAll(new CidadeController().buscarTodasDoEstado(estado));
    }//GEN-LAST:event_cbEstadosPopupMenuWillBecomeInvisible

    private void btnNovaCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaCidadeActionPerformed
        CidadeView cidadeView = new CidadeView(this, true);
        cidadeView.setLocationRelativeTo(this);
        cidadeView.setVisible(true);
    }//GEN-LAST:event_btnNovaCidadeActionPerformed
    
    private void habilitaAtualizar() {
        this.btnAtualizar.setEnabled(true);
        this.btnSalvar.setEnabled(false);
    }
    
    private void habilitaNovo() {
        this.btnAtualizar.setEnabled(false);
        this.btnSalvar.setEnabled(true);
    }
    
    private void clearFields() {
        txtID.setText("");
        txtNome.setText("");
        txtEndereço.setText("");
        txtCpfCnpj.setText("");
        txtDataNascimento.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovaCidade;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbCidades;
    private javax.swing.JComboBox cbEstados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JFormattedTextField txtCpfCnpj;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private javax.swing.JTextField txtEndereço;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
