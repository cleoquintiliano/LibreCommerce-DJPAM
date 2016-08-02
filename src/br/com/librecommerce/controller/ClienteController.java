/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.controller;

import br.com.librecommerce.dao.ClienteDao;
import br.com.librecommerce.modelo.Cliente;
import java.util.List;

/**
 *
 * @author Clovis
 */
public class ClienteController {
    
    public boolean salvar(Cliente cliente) {
        return new ClienteDao().salvar(cliente);
    }
    
    public List<Cliente> buscarClientesPorNome(String nome) {
        return new ClienteDao().buscarClientesPorNome(nome);
    }
    
    public boolean atualizar(Cliente cliente) {
        return new ClienteDao().atualizar(cliente);
    }
    
}
