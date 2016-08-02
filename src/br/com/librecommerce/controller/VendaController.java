/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.controller;

import br.com.librecommerce.dao.CaixaDao;
import br.com.librecommerce.dao.ContaReceberDao;
import br.com.librecommerce.dao.VendaDao;
import br.com.librecommerce.modelo.Caixa;
import br.com.librecommerce.modelo.ContaReceber;
import br.com.librecommerce.modelo.FormaPagamento;
import br.com.librecommerce.modelo.StatusConta;
import br.com.librecommerce.modelo.Venda;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Clovis
 */
public class VendaController {

    public boolean salvar(Venda venda) {
        if (venda.getCliente() == null) {
            if (new VendaDao().salvar(venda)) {
                atualizarCaixa(venda.getFormaPagamento(), venda.getTotalVenda());
                return true;
            } else {
                return false;
            }
        } else {
            venda.setValorPago(0.0);
            if (new VendaDao().salvar(venda)) {
                atualizarCaixa(venda.getFormaPagamento(), venda.getTotalVenda());
                gerarContaReceber(venda);
                return true;
            } else {
                return false;
            }
        }
    }

    private void gerarContaReceber(Venda venda) {
        ContaReceber contaReceber = new ContaReceber();
        contaReceber.setDataVencimento(gerarDataVencimento(new Date()));
        contaReceber.setStatusConta(StatusConta.ABERTA);
        contaReceber.setVenda(venda);
        new ContaReceberDao().gerarContaReceber(contaReceber);

    }

    private Date gerarDataVencimento(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
        return c.getTime();
    }

    private void atualizarCaixa(FormaPagamento formaPagamento, Double totalVenda) {
        Caixa caixa = getCaixaAberto();
        if (caixa != null) {
            switch (formaPagamento) {
                case DINHEIRO:
                    caixa.setTotalDinheiro(caixa.getTotalDinheiro() + totalVenda);
                    caixa.setTotalVendas(caixa.getTotalVendas() + totalVenda);
                    break;
                case CARTAO_DEBITO:
                    caixa.setTotalCartaoDebito(caixa.getTotalCartaoDebito() + totalVenda);
                    caixa.setTotalVendas(caixa.getTotalVendas() + totalVenda);
                    break;
                case CARTAO_CREDITO:
                    caixa.setTotalCartaoCredito(caixa.getTotalCartaoCredito() + totalVenda);
                    caixa.setTotalVendas(caixa.getTotalVendas() + totalVenda);
                    break;
                case PRAZO_30_DIAS:
                    caixa.setTotalPrazo30Dias(caixa.getTotalPrazo30Dias() + totalVenda);
                    break;
            }

            new CaixaDao().atualizarCaixa(caixa);

        }
    }

    private Caixa getCaixaAberto() {
        return new CaixaDao().getCaixaAberto();
    }

}
