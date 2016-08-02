/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.controller;

import br.com.librecommerce.dao.CidadeDao;
import br.com.librecommerce.modelo.Cidade;
import br.com.librecommerce.modelo.Estado;
import java.util.List;

/**
 *
 * @author Clovis
 */
public class CidadeController {
    
    public List<Cidade> buscarTodasDoEstado(Estado estado) {
        return new CidadeDao().buscarTodasDoEstado(estado);
    }

    public boolean salvar(Cidade cidade) {
        return new CidadeDao().salvar(cidade);
    }
    
}
