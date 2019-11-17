/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.produto.bo;

import br.edu.ifms.loja.fonecedor.dao.FornecedorDAO;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import br.edu.ifms.loja.produto.dao.ProdutoDAO;
import br.edu.ifms.loja.produto.datamodel.Produto;
import java.util.ArrayList;
import java.util.List;
import maruyama.components.mvc.GenericCRUDModel;

/**
 *
 * @author Caio
 */
public class ProdutoBO extends GenericCRUDModel<Produto> {
    private ProdutoDAO dao;
    private FornecedorDAO fornecedorDao;

    public ProdutoBO() {
        dao = new ProdutoDAO();
        fornecedorDao = new FornecedorDAO();
        preencherLista(dao.listarTodos());
    }

    @Override
    public void salvarEmBaseDeDados(Produto arg0) {
        dao.persistir(arg0);
    }

    @Override
    public void removerEmBaseDeDados(Produto arg0) {
        dao.remover(arg0);
    }

    @Override
    public List<Produto> carregarLista() {
        return dao.listarTodos();
    }

    @Override
    public List<Produto> buscar(String arg0, String arg1) {
        return new ArrayList<Produto>();
    }
    
    public List<Fornecedor> listarFornecedores() {
        return fornecedorDao.listarTodos();
    }
    
}
