/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.controller;

import br.com.librecommerce.dao.EstadoDao;
import br.com.librecommerce.modelo.Estado;
import java.util.List;

/**
 *
 * @author Clovis
 */
public class EstadoController {
    
    public List<Estado> buscarTodos() {
        return new EstadoDao().buscarTodos();
    }
    
}
