/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.controller;

import br.com.librecommerce.dao.FornecedorDao;
import br.com.librecommerce.modelo.Fornecedor;
import java.util.List;

/**
 *
 * @author Clovis
 */
public class FornecedorController {
    
    public boolean salvar(Fornecedor fornecedor) {
        return new FornecedorDao().salvar(fornecedor);
    }
    
    public boolean atualizar(Fornecedor fornecedor) {
        return new FornecedorDao().atualizar(fornecedor);
    }
    
    public List<Fornecedor> buscarFornecedoresPorNome(String nome) {
        return new FornecedorDao().buscarFornecedoresPorNome(nome);
    }
    
}
