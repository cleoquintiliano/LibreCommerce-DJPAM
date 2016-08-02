/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.modelo.abstractTableModel;

import br.com.librecommerce.modelo.Cidade;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Clovis
 */
public class CidadeTableModel extends AbstractTableModel {

    private List<Cidade> cidades = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.cidades.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Cidade cidade = this.cidades.get(linha);
        switch (coluna) {
            case 0:
                return cidade.getNome();
            case 1:
                return cidade.getEstado().getSigla();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Cidade";
            case 1:
                return "UF";
            default:
                return "";
        }
    }
    
    public void addAll(List<Cidade> cidades) {
        this.cidades.addAll(cidades);
        fireTableRowsInserted(this.cidades.size()-1, this.cidades.size()-1);
    }

}
