/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.controller;

import br.com.librecommerce.dao.CategoriaDao;
import br.com.librecommerce.modelo.Categoria;
import java.util.List;

/**
 *
 * @author Clovis
 */
public class CategoriaController {
    
    public List<Categoria> listarTodas() {
        return new CategoriaDao().listarTodos();
    }
    
}
