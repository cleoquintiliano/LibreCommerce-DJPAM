/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.modelo.abstractTableModel;

import br.com.librecommerce.modelo.ContaPagar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Clovis
 */
public class ContaPagarTableModel extends AbstractTableModel {

    private List<ContaPagar> contasPagar = new ArrayList<>();
    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public int getRowCount() {
        return this.contasPagar.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    public ContaPagar getContaPagar(int linha) {
        return this.contasPagar.get(linha);
    }
    
    public List<ContaPagar> getAll() {
        return this.contasPagar;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        ContaPagar contaPagar = contasPagar.get(linha);
        switch (coluna) {
            case 0:
                return contaPagar.getDescricao();
            case 1:
                return df.format(contaPagar.getDataVencimento());
            case 2:
                return contaPagar.getValor();
            case 3:
                return contaPagar.getStatusConta();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Descrição";
            case 1:
                return "Data de Vencimento";
            case 2:
                return "Valor";
            case 3:
                return "Status";
            default:
                return "";
        }
    }
    
    public void AddAll(List<ContaPagar> contasPagar) {
        this.contasPagar.clear();
        this.contasPagar.addAll(contasPagar);
        fireTableRowsInserted(this.contasPagar.size()-1, this.contasPagar.size()-1);
    }

}
