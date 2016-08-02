/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.controller;

import br.com.librecommerce.dao.FuncionarioDao;
import br.com.librecommerce.modelo.Funcionario;
import java.util.List;

/**
 *
 * @author Clovis
 */
public class FuncionarioController {
    
    public boolean salvar(Funcionario funcionario) {
        return new FuncionarioDao().salvar(funcionario);
    }
    
    public boolean atualizar(Funcionario funcionario) {
        return new FuncionarioDao().atualizar(funcionario);
    }
    
    public List<Funcionario> buscaFuncionariosPorNome(String nome) {
        return new FuncionarioDao().buscarFuncionariosPorNome(nome);
    }
    
}
