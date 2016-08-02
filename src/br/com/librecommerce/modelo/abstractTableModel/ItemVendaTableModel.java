/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.modelo.abstractTableModel;

import br.com.librecommerce.modelo.ItemVenda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Clovis
 */
public class ItemVendaTableModel extends AbstractTableModel {

    private List<ItemVenda> itensVenda = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.itensVenda.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    public ItemVenda getItemVenda(int linha) {
        return this.itensVenda.get(linha);
    }
    
    public void clear() {
        this.itensVenda.clear();
        fireTableRowsDeleted(0, 0);
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        ItemVenda itemVenda = itensVenda.get(linha);
        switch (coluna) {
            case 0:
                return itemVenda.getNumeroItem();
            case 1:
                return itemVenda.getProduto().getNome();
            case 2:
                return itemVenda.getQuantidadeProduto();
            case 3:
                return itemVenda.getValorTotal();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Item";
            case 1:
                return "Produto";
            case 2:
                return "Quantidade";
            case 3:
                return "Total";
            default:
                return "";
        }
    }
    
    /*
    public ItemVenda getItemVenda(int linha) {
        return this.itensVenda.get(linha);
    }
    */
    
    public void adicionarItem(ItemVenda itemVenda) {
        this.itensVenda.add(itemVenda);
        fireTableRowsInserted(this.itensVenda.size()-1, this.itensVenda.size()-1);
    }
    
    public void removerItem(ItemVenda itemVenda) {
        this.itensVenda.remove(itemVenda);
        fireTableRowsInserted(this.itensVenda.size()-1, this.itensVenda.size()-1);
    }

}
