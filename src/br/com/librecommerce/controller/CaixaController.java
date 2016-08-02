/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.controller;

import br.com.librecommerce.dao.CaixaDao;
import br.com.librecommerce.modelo.Caixa;

/**
 *
 * @author Clovis
 */
public class CaixaController {
    
    public Caixa getCaixaAberto() {
        return new CaixaDao().getCaixaAberto();
    }
    
    public Caixa abrirCaixa(Caixa caixa) {
        return new CaixaDao().abrirCaixa(caixa);
    }
    
    public boolean fecharCaixa(Caixa caixa) {
        return new CaixaDao().fecharCaixa(caixa);
    }
    
    public boolean realizarSangria(Caixa caixa) {
        return new CaixaDao().atualizarCaixa(caixa);
    }
}
