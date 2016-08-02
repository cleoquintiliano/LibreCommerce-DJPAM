/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.modelo.comboBoxModel;

import br.com.librecommerce.modelo.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Clovis
 */
public class CategoriaComboModel extends AbstractListModel<Object>
        implements ComboBoxModel<Object> {
    
    private List<Categoria> categorias = new ArrayList<>();
    private Categoria categoriaSelecionada;

    @Override
    public int getSize() {
        return this.categorias.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.categorias.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.categoriaSelecionada = (Categoria) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return categoriaSelecionada;
    }
    
    public void addAll(List<Categoria> categorias) {
        this.categorias.addAll(categorias);
        fireIntervalAdded(this, getSize(), getSize());
        setSelectedItem(this.categorias.get(getSize()-1));
    }

}
