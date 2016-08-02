/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.controller;

import br.com.librecommerce.dao.ProdutoDao;
import br.com.librecommerce.modelo.Produto;
import java.util.List;

/**
 *
 * @author Clovis
 */
public class ProdutoController {
    
    public boolean salvar(Produto produto) {
        return new ProdutoDao().salvar(produto);
    }
    
    public boolean atualizar(Produto produto) {
        return new ProdutoDao().atualizar(produto);
    }
    
    public List<Produto> buscarProdutoPorNome(String nome) {
        return new ProdutoDao().buscaProdutoPorNome(nome);
    }
    
    public Produto buscarProdutoPorCodigoBarra(int codigoBarra) {
        return new ProdutoDao().buscarProdutoPorCodigoBarra(codigoBarra);
    }
    
}
