/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.modelo.abstractTableModel;

import br.com.librecommerce.modelo.ContaReceber;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Clovis
 */
public class ContaReceberTableModel extends AbstractTableModel {

    private List<ContaReceber> contasReceber = new ArrayList<>();
    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public int getRowCount() {
        return this.contasReceber.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        ContaReceber contaReceber = this.contasReceber.get(linha);
        switch (coluna) {
            case 0:
                return contaReceber.getVenda().getCliente().getNome();
            case 1:
                return df.format(contaReceber.getDataVencimento());
            case 2:
                return contaReceber.getVenda().getTotalVenda();
            case 3:
                return contaReceber.getStatusConta();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Cliente";
            case 1:
                return "Data de Vencimento";
            case 2:
                return "Total R$";
            case 3:
                return "Status";
            default:
                return "";
        }
    }
    
    public ContaReceber getContaReceber(int linha) {
        return this.contasReceber.get(linha);
    }
    
    public List<ContaReceber> getAll() {
        return this.contasReceber;
    }
    
    public void addAll(List<ContaReceber> contasReceber) {
        this.contasReceber.clear();
        this.contasReceber.addAll(contasReceber);
        fireTableRowsInserted(this.contasReceber.size()-1, this.contasReceber.size()-1);
    }

}
