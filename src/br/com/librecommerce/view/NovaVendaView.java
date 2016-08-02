/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.view;

import br.com.librecommerce.controller.ProdutoController;
import br.com.librecommerce.controller.VendaController;
import br.com.librecommerce.dao.CaixaDao;
import br.com.librecommerce.modelo.Caixa;
import br.com.librecommerce.modelo.ItemVenda;
import br.com.librecommerce.modelo.Produto;
import br.com.librecommerce.modelo.Venda;
import br.com.librecommerce.modelo.abstractTableModel.ItemVendaTableModel;
import br.com.librecommerce.util.Messages;
import java.awt.event.KeyEvent;
import java.util.Date;

/**
 *
 * @author Clovis
 */
public class NovaVendaView extends javax.swing.JFrame {

    private ItemVendaTableModel itemVendaTableModel = new ItemVendaTableModel();
    private Venda venda;
    private ItemVenda itemVenda;
    private Produto produto;
    private Caixa caixa;
    private int numeroItem;

    /**
     * Creates new form NovaVendaView
     */
    public NovaVendaView() {
        initComponents();
        initVenda();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItemVenda = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnCancelarVenda = new javax.swing.JButton();
        btnSalvarVenda = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodBarra = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnRemoverItem = new javax.swing.JButton();

        jTextField4.setText("jTextField4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LibreCommerce - Nova Venda");
        setResizable(false);

        tblItemVenda.setModel(itemVendaTableModel);
        tblItemVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemVendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblItemVenda);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCancelarVenda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelarVenda.setText("Cancelar Venda");
        btnCancelarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVendaActionPerformed(evt);
            }
        });

        btnSalvarVenda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalvarVenda.setText("Salvar Venda");
        btnSalvarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarVendaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Total R$: ");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTotal.setText("0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvarVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelarVenda)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarVenda)
                    .addComponent(btnSalvarVenda)
                    .addComponent(jLabel2)
                    .addComponent(lblTotal))
                .addContainerGap())
        );

        jLabel4.setText("Código de Barra:");

        txtCodBarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodBarraKeyPressed(evt);
            }
        });

        jLabel5.setText("Quantidade:");

        txtQuantidade.setText("1");
        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyPressed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemoverItem.setText("Remover Item");
        btnRemoverItem.setEnabled(false);
        btnRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemoverItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverItem))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initVenda() {
        this.itemVendaTableModel.clear();
        this.lblTotal.setText("0.00");
        venda = new Venda();
        venda.setCaixa(getCaixaAberto());
        venda.setDataVenda(new Date());
        itemVenda = new ItemVenda();
        numeroItem = 1;
    }

    private Caixa getCaixaAberto() {
        return new CaixaDao().getCaixaAberto();
    }
    
    private void btnSalvarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarVendaActionPerformed
        if (venda.getItensVenda().isEmpty()) {
            Messages.alertMessage(this, "Nenhum item vendido!");
        } else {
            ConfirmarVendaView confirmarVendaView = new ConfirmarVendaView(this, true);
            confirmarVendaView.setLocationRelativeTo(this);
            confirmarVendaView.setTotal(venda.getTotalVenda());
            confirmarVendaView.setVisible(true);
            if (confirmarVendaView.isConfirmar()) {
                venda.setFormaPagamento(confirmarVendaView.getFormaPagamento());
                venda.setAcrescimo(confirmarVendaView.getAcrescimo());
                venda.setDesconto(confirmarVendaView.getDesconto());
                venda.setValorPago(confirmarVendaView.getValorPago());
                venda.setTotalVenda(confirmarVendaView.getTotal());
                venda.setTroco(confirmarVendaView.getTroco());
                if (confirmarVendaView.isClienteSelecionado()) {
                    venda.setCliente(confirmarVendaView.getCliente());
                }
                if (new VendaController().salvar(venda)) {
                    initVenda();
                    Messages.infoMessage(this, "Venda salva com sucesso!");
                } else {
                    Messages.errorMessage(this, "Não foi possível realizar esta operação!");
                }
            }
        }

    }//GEN-LAST:event_btnSalvarVendaActionPerformed

    private void btnCancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVendaActionPerformed
        this.venda.getItensVenda().clear();
        this.venda.setTotalVenda(0.0);
        this.itemVendaTableModel.clear();
        this.lblTotal.setText("0.00");
        this.dispose();
    }//GEN-LAST:event_btnCancelarVendaActionPerformed

    private void tblItemVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemVendaMouseClicked
        this.btnRemoverItem.setEnabled(true);
    }//GEN-LAST:event_tblItemVendaMouseClicked

    private void txtCodBarraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodBarraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtCodBarra.getText().trim().equals("")) {
                adicionarProduto(Integer.parseInt(txtCodBarra.getText()));
            }
        }
    }//GEN-LAST:event_txtCodBarraKeyPressed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if (!txtCodBarra.getText().trim().equals("")) {
            adicionarProduto(Integer.parseInt(txtCodBarra.getText()));
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverItemActionPerformed
        ItemVenda itemSelecionado = this.itemVendaTableModel.getItemVenda(tblItemVenda.getSelectedRow());
        this.itemVendaTableModel.removerItem(itemSelecionado);
        this.venda.getItensVenda().remove(itemSelecionado);
        this.venda.setTotalVenda(venda.getTotalVenda() - itemSelecionado.getValorTotal());
        atualizaTotal(venda.getTotalVenda());
    }//GEN-LAST:event_btnRemoverItemActionPerformed

    private void txtQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyPressed
        if (!txtCodBarra.getText().trim().equals("")) {
            adicionarProduto(Integer.parseInt(txtCodBarra.getText()));
        }
    }//GEN-LAST:event_txtQuantidadeKeyPressed

    private void adicionarProduto(int codigoBarra) {
        produto = new ProdutoController().buscarProdutoPorCodigoBarra(codigoBarra);
        if (produto == null) {
            Messages.alertMessage(this, "Produto não encontrado");
        } else {
            produto.setEstoque(produto.getEstoque() - Integer.parseInt(txtQuantidade.getText()));
            itemVenda.setProduto(produto);
            itemVenda.setNumeroItem(numeroItem);
            numeroItem++;
            itemVenda.setQuantidadeProduto(Integer.parseInt(txtQuantidade.getText()));
            itemVenda.setValorTotal(itemVenda.getQuantidadeProduto() * produto.getValorUnitario());
            itemVenda.setVenda(venda);
            this.itemVendaTableModel.adicionarItem(itemVenda);
            venda.getItensVenda().add(itemVenda);
            venda.setTotalVenda(venda.getTotalVenda() + itemVenda.getValorTotal());
            itemVenda = new ItemVenda();
            produto = new Produto();
            atualizaTotal(venda.getTotalVenda());
            clearFields();
        }
    }

    private void atualizaTotal(Double totalVenda) {
        lblTotal.setText(String.valueOf(totalVenda));
    }

    private void clearFields() {
        this.txtCodBarra.setText("");
        this.txtQuantidade.setText("1");
        this.txtCodBarra.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelarVenda;
    private javax.swing.JButton btnRemoverItem;
    private javax.swing.JButton btnSalvarVenda;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblItemVenda;
    private javax.swing.JTextField txtCodBarra;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables

}
