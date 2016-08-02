/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.modelo.comboBoxModel;

import br.com.librecommerce.modelo.Cidade;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Clovis
 */
public class CidadeComboModel extends AbstractListModel<Object>
        implements ComboBoxModel<Object> {
    
    private List<Cidade> cidades = new ArrayList<>();
    private Cidade cidadeSelecionada;

    @Override
    public int getSize() {
        return this.cidades.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.cidades.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.cidadeSelecionada = (Cidade) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return cidadeSelecionada;
    }
    
    public void addAll(List<Cidade> cidades)  {
        this.cidades.clear();
        this.cidades.addAll(cidades);
        fireIntervalAdded(this, getSize(), getSize());
        setSelectedItem(this.cidades.get(getSize()-1));
    }

}
