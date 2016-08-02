/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.modelo.abstractTableModel;

import br.com.librecommerce.modelo.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Clovis
 */
public class ProdutoTableModel extends AbstractTableModel {

    private List<Produto> produtos = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.produtos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public Produto getProduto(int linha) {
        return this.produtos.get(linha);
    }
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        Produto produto = this.produtos.get(linha);
        switch (coluna) {
            case 0:
                return produto.getCodigoBarra();
            case 1:
                return produto.getNome();
            case 2:
                return produto.getValorUnitario();
            case 3:
                return produto.getEstoque();
            case 4:
                return produto.getCategoria();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Cod. Barra";
            case 1:
                return "Nome";
            case 2:
                return "Valor Unitário";
            case 3:
                return "Qtdd em Estoque";
            case 4:
                return "Categoria";
            default:
                return "";
        }
    }
    
    public void addAll(List<Produto> produtos) {
        this.produtos.addAll(produtos);
        fireTableRowsInserted(this.produtos.size()-1, this.produtos.size()-1);
    }

}
