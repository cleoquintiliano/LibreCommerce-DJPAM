/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.modelo.abstractTableModel;

import br.com.librecommerce.modelo.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Clovis
 */
public class FornecedorTableModel extends AbstractTableModel {

    private List<Fornecedor> fornecedores = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.fornecedores.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    public Fornecedor getFornecedor(int linha) {
        return this.fornecedores.get(linha);
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Fornecedor fornecedor = this.fornecedores.get(linha);
        switch (coluna) {
            case 0:
                return fornecedor.getNome();
            case 1:
                return fornecedor.getEndereco();
            case 2:
                return fornecedor.getCidade();
            case 3:
                return fornecedor.getCnpj();
            case 4:
                return fornecedor.getInscEstadual();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Nome";
            case 1:
                return "Endereço";
            case 2:
                return "Cidade";
            case 3:
                return "CNPJ";
            case 4:
                return "Insc. Estadual";
            default:
                return "";
        }
    }
    
    public void addAll(List<Fornecedor> fornecedores) {
        this.fornecedores.clear();
        this.fornecedores.addAll(fornecedores);
        fireTableRowsInserted(this.fornecedores.size()-1, this.fornecedores.size()-1);
    }

}
