/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.uf.bo;

import br.edu.ifms.loja.uf.dao.UfDAO;
import br.edu.ifms.loja.uf.datamodel.Uf;
import java.util.ArrayList;
import java.util.List;
import maruyama.components.mvc.GenericCRUDModel;

/**
 *
 * @author gusta
 */
public class UfBO extends GenericCRUDModel<Uf>{

    private UfDAO dao;

    public UfBO() {
        dao = new UfDAO();
        preencherLista(dao.listarTodos());
    }
    
    @Override
    public void salvarEmBaseDeDados(Uf t) {
        dao.persistir(t);
    }

    @Override
    public void removerEmBaseDeDados(Uf t) {
        dao.remover(t);
    }

    @Override
    public List<Uf> carregarLista() {
        return dao.listarTodos();
    }

    @Override
    public List<Uf> buscar(String campo, String valor) {
       if (campo.equals("Nome")) {
            return dao.buscarUfPorNome(valor);
        }
        if (campo.equals("Sigla")) {
            return dao.buscarUfPorSigla(valor);
        }
        if (campo.equals("ID")) {
            return dao.buscarUfPorId(valor);
        }
        return new ArrayList<Uf>();
    }  
}
