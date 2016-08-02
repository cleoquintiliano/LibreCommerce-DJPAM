/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.modelo.abstractTableModel;

import br.com.librecommerce.modelo.Cliente;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Clovis
 */
public class ClienteTableModel extends AbstractTableModel {

    private List<Cliente> clientes = new ArrayList<>();
    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public int getRowCount() {
        return this.clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    public Cliente getCliente(int linha) {
        return this.clientes.get(linha);
    }
    
    public void clear() {
        this.clientes.clear();
        fireTableRowsDeleted(0, 0);
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Cliente cliente = clientes.get(linha);
        switch (coluna) {
            case 0:
                return cliente.getNome();
            case 1:
                return cliente.getEndereco();
            case 2:
                return cliente.getCidade().getNome();
            case 3:
                return cliente.getCpfCnpj();
            case 4:
                return df.format(cliente.getDataNascimento());
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
                return "CPF/CNPJ";
            case 4:
                return "Data de Nascimento";
            default:
                return "";
        }
    }
    
    public void addAll(List<Cliente> clientes) {
        this.clientes.clear();
        this.clientes.addAll(clientes);
        fireTableRowsInserted(this.clientes.size()-1, this.clientes.size()-1);
    }

}
