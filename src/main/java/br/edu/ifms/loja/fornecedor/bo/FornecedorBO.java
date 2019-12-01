/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.fornecedor.bo;

import br.edu.ifms.loja.cidade.dao.CidadeDAO;
import br.edu.ifms.loja.cidade.datamodel.Cidade;
import br.edu.ifms.loja.fonecedor.dao.FornecedorDAO;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import br.edu.ifms.loja.uf.dao.UfDAO;
import br.edu.ifms.loja.uf.datamodel.Uf;
import java.util.ArrayList;
import java.util.List;
import maruyama.components.mvc.GenericCRUDModel;

/**
 *
 * @author Caio
 */
public class FornecedorBO extends GenericCRUDModel<Fornecedor> {
    private FornecedorDAO dao;
    private CidadeDAO cidadeDao;
    private UfDAO ufDao;

    public FornecedorBO() {
        dao = new FornecedorDAO();
        cidadeDao = new CidadeDAO();
        ufDao = new UfDAO();
        preencherLista(dao.listarTodos());
    }

    @Override
    public void salvarEmBaseDeDados(Fornecedor t) {
        dao.persistir(t);
    }

    @Override
    public void removerEmBaseDeDados(Fornecedor t) {
        dao.remover(t);
    }

    @Override
    public List<Fornecedor> carregarLista() {
        return dao.listarTodos();
    }

    @Override
    public List<Fornecedor> buscar(String campo, String valor) {
        if (campo.equals("Nome Fantasia")) {
            return dao.buscarFornecedorPorNomeFantasia(valor);
        }
        if (campo.equals("Cidade")) {
            return dao.buscarFornecedorPorNomeCidade(valor);
        }
        if (campo.equals("UF")) {
            return dao.buscarFornecedoresPorNomeUf(valor);
        }
        if (campo.equals("ID")) {
            return dao.buscarFornecedorPorId(valor);
        }
        return new ArrayList<Fornecedor>();
    }
    
    public List<Cidade> listarCidades() {
        return cidadeDao.listarTodos();
    }
    
    public List<Uf> listarUfs() {
        return ufDao.listarTodos();
    }
    
    public List<Cidade> listarCidadesPorUf(Uf uf){
        return cidadeDao.listarCidadesPorUf(uf);
    }
    
}
