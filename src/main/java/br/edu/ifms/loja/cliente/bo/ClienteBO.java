/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cliente.bo;

import br.edu.ifms.loja.cidade.dao.CidadeDAO;
import br.edu.ifms.loja.cidade.datamodel.Cidade;
import br.edu.ifms.loja.cliente.dao.ClienteDAO;
import br.edu.ifms.loja.cliente.datamodel.Cliente;
import br.edu.ifms.loja.uf.dao.UfDAO;
import br.edu.ifms.loja.uf.datamodel.Uf;
import java.util.ArrayList;
import java.util.List;
import maruyama.components.mvc.GenericCRUDModel;

/**
 *
 * @author Caio
 */
public class ClienteBO extends GenericCRUDModel<Cliente> {
    private ClienteDAO dao;
    private CidadeDAO cidadeDao;
    private UfDAO ufDao;

    public ClienteBO() {
        dao = new ClienteDAO();
        cidadeDao = new CidadeDAO();
        ufDao = new UfDAO();
        preencherLista(dao.listarTodos());
    }

    @Override
    public void salvarEmBaseDeDados(Cliente t) {
        dao.persistir(t);
    }

    @Override
    public void removerEmBaseDeDados(Cliente t) {
        dao.remover(t);
    }

    @Override
    public List<Cliente> carregarLista() {
        return dao.listarTodos();
    }

    @Override
    public List<Cliente> buscar(String campo, String valor) {
        if (campo.equals("Nome")) {
            return dao.buscarClientePorNome(valor);
        }
        if (campo.equals("CPF")) {
            return dao.buscarClientePorCpf(valor);
        }
        if (campo.equals("Cidade")) {
            return dao.buscarClientePorCidade(valor);
        }
        if (campo.equals("ID")) {
            return dao.buscarClientePorId(valor);
        }
        return new ArrayList<Cliente>();
    }
    
    public List<Uf> listarUfs() {
        return ufDao.listarTodos();
    }
    
    public List<Cidade> listarCidadesPorUf(Uf uf){
        return cidadeDao.listarCidadesPorUf(uf);
    }
    
}
