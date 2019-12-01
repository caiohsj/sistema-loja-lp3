/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.fonecedor.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;
import br.edu.ifms.loja.cidade.datamodel.Cidade;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import java.util.List;

/**
 *
 * @author Caio
 */
public class FornecedorDAO extends GenericDAO<Fornecedor> {
    
    public FornecedorDAO() {
        super(Fornecedor.class);
    }
    
    public List<Fornecedor> buscarFornecedorPorNomeCidade(String valor) {
        return getEm().createQuery("SELECT f FROM Fornecedor f WHERE UPPER(f.cidade.nome) LIKE :nomeCidade")
                .setParameter("nomeCidade", "%" + valor.toUpperCase() + "%")
                .getResultList();
    }

    public List<Fornecedor> buscarFornecedorPorNomeFantasia(String valor) {
        return getEm().createQuery("SELECT f FROM Fornecedor f WHERE UPPER(f.nomeFantasia) LIKE :nomeFantasia")
                .setParameter("nomeFantasia", "%" + valor.toUpperCase() + "%")
                .getResultList();
    }

    public List<Fornecedor> buscarFornecedoresPorNomeUf(String valor) {
        return getEm().createQuery("SELECT f FROM Fornecedor f WHERE UPPER (f.cidade.uf.nome) LIKE :nomeUf")
                .setParameter("nomeUf", "%" + valor.toUpperCase() + "%")
                .getResultList();
    }

    public List<Fornecedor> buscarFornecedorPorId(String valor) {
        Long id;
        try {
            id = new Long(valor);
            return getEm().createQuery("SELECT f FROM Fornecedor f WHERE f.id =:id")
                    .setParameter("id", id)
                    .getResultList();
        } catch (NumberFormatException ex) {
            return listarTodos();
        }
    }
    
}
