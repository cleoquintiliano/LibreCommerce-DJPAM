/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.modelo.comboBoxModel;

import br.com.librecommerce.modelo.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Clovis
 */
public class EstadoComboModel extends AbstractListModel<Object>
        implements ComboBoxModel<Object> {
    
    private List<Estado> estados = new ArrayList<>();
    private Estado estadoSelecionado;

    @Override
    public int getSize() {
        return this.estados.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.estados.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.estadoSelecionado = (Estado) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return estadoSelecionado;
    }
    
    public void addAll(List<Estado> estados) {
        this.estados.addAll(estados);
        fireIntervalAdded(this, getSize(), getSize());
        setSelectedItem(this.estados.get(getSize()-1));
    }

}
