/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.controller;

import br.com.librecommerce.dao.FuncionarioDao;
import br.com.librecommerce.modelo.Funcionario;

/**
 *
 * @author Clovis
 */
public class LoginController {
    
    public Funcionario login(String usuario, String senha) {
        return new FuncionarioDao().login(usuario, senha);
    }
    
}
