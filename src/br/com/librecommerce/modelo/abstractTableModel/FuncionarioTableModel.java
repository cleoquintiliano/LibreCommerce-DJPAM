/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.modelo.abstractTableModel;

import br.com.librecommerce.modelo.Funcionario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Clovis
 */
public class FuncionarioTableModel extends AbstractTableModel {

    private List<Funcionario> funcionarios = new ArrayList<>();
    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public int getRowCount() {
        return this.funcionarios.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    public Funcionario getFuncionario(int linha) {
        return this.funcionarios.get(linha);
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Funcionario funcionario = this.funcionarios.get(linha);
        switch (coluna) {
            case 0:
                return funcionario.getNome();
            case 1:
                return funcionario.getEndereco();
            case 2:
                return funcionario.getCidade();
            case 3:
                return df.format(funcionario.getDataNascimento());
            case 4:
                return funcionario.isAdmin();
            case 5:
                return funcionario.getLogin();
            case 6:
                return funcionario.getSenha();
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
                return "Data de Nascimento";
            case 4:
                return "É Administrador?";
            case 5:
                return "Login";
            case 6:
                return "Senha";
            default:
                return "";
        }
    }
    
    public void addAll(List<Funcionario> funcionarios) {
        this.funcionarios.clear();
        this.funcionarios.addAll(funcionarios);
        fireTableRowsInserted(this.funcionarios.size()-1, this.funcionarios.size()-1);
    }

}
