/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.controller;

import br.com.librecommerce.dao.CaixaDao;
import br.com.librecommerce.dao.ContaPagarDao;
import br.com.librecommerce.modelo.Caixa;
import br.com.librecommerce.modelo.ContaPagar;
import br.com.librecommerce.modelo.StatusConta;
import java.util.List;

/**
 *
 * @author Clovis
 */
public class ContaPagarController {
    
    public boolean salvar(ContaPagar contaPagar) {
        return new ContaPagarDao().salvarConta(contaPagar);
    }
    
    public boolean pagarConta(ContaPagar contaPagar) {
        contaPagar.setStatusConta(StatusConta.FECHADA);
        if (new ContaPagarDao().pagarConta(contaPagar)) {
            atualizarCaixa(contaPagar.getValor());
            return true;
        }
        return false;
    }
    
    public boolean pagarTodas(List<ContaPagar> contasPagar) {
        Double total = 0.0;
        for (int i = 0; i < contasPagar.size(); i++) {
            total += contasPagar.get(i).getValor();
            contasPagar.get(i).setStatusConta(StatusConta.FECHADA);
        }
        if (new ContaPagarDao().pagarTodasContas(contasPagar)) {
            atualizarCaixa(total);
            return true;
        }
        return false;
    }
    
    public List<ContaPagar> consultarTodas() {
        return new ContaPagarDao().consultarTodas();
    }
    
    public List<ContaPagar> consultarPorDescricao(String descricao) {
        return new ContaPagarDao().consultarPorDescricao(descricao);
    }

    private void atualizarCaixa(Double valor) {
        CaixaDao caixaDao = new CaixaDao();
        Caixa caixa = caixaDao.getCaixaAberto();
        if (caixa != null) {
            caixa.setContasPagas(caixa.getContasPagas()+ valor);
            caixaDao.atualizarCaixa(caixa);
        }
    }
    
}
