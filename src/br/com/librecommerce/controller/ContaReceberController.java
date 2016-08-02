/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.controller;

import br.com.librecommerce.dao.CaixaDao;
import br.com.librecommerce.dao.ContaReceberDao;
import br.com.librecommerce.modelo.Caixa;
import br.com.librecommerce.modelo.ContaReceber;
import br.com.librecommerce.modelo.StatusConta;
import java.util.List;

/**
 *
 * @author Clovis
 */
public class ContaReceberController {
    
    public List<ContaReceber> consultarPorCliente(String nome) {
        return new ContaReceberDao().consultarPorCliente(nome);
    }
    
    public List<ContaReceber> consultarTodas() {
        return new ContaReceberDao().consultarTodas();
    }
    
    public boolean receber(ContaReceber contaReceber) {
        contaReceber.setStatusConta(StatusConta.FECHADA);
         if (new ContaReceberDao().receber(contaReceber)) {
             atualizarCaixa(contaReceber.getVenda().getTotalVenda());
             return true;
         }
         return false;
    }
    
    public boolean receberTodas(List<ContaReceber> contasReceber) {
        Double totalRecebido = 0.0;
        for (int i = 0; i < contasReceber.size(); i++) {
            contasReceber.get(i).setStatusConta(StatusConta.FECHADA);
            totalRecebido += contasReceber.get(i).getVenda().getTotalVenda();
        }
        if (new ContaReceberDao().receberTodas(contasReceber)) {
            atualizarCaixa(totalRecebido);
            return true;
        }
        return false;
    }

    private void atualizarCaixa(Double totalVenda) {
        CaixaDao caixaDao = new CaixaDao();
        Caixa caixa = caixaDao.getCaixaAberto();
        if (caixa != null) {
            caixa.setContasRecebidas(caixa.getContasRecebidas() + totalVenda);
            caixaDao.atualizarCaixa(caixa);
        }
    }
    
}
