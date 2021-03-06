/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.produto.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;
import br.edu.ifms.loja.cidade.datamodel.Cidade;
import br.edu.ifms.loja.produto.datamodel.Produto;
import br.edu.ifms.loja.uf.datamodel.Uf;
import java.util.List;

/**
 *
 * @author Caio
 */
public class ProdutoDAO extends GenericDAO<Produto> {

    public ProdutoDAO() {
        super(Produto.class);
    }
    
     public List<Produto> buscarProdutoPorDescricao(String valor) {
        return getEm().createQuery("SELECT p FROM Produto p WHERE UPPER(p.descricao) LIKE :descricao")
                .setParameter("descricao", "%" + valor.toUpperCase() + "%")
                .getResultList();
    }

    public List<Produto> buscarProdutoPorMarca(String valor) {
        return getEm().createQuery("SELECT p FROM Produto p WHERE UPPER (p.marca) LIKE :marca")
                .setParameter("marca", "%" + valor.toUpperCase() + "%")
                .getResultList();
    }
    
    public List<Produto> buscarProdutoPorModelo(String valor) {
        return getEm().createQuery("SELECT p FROM Produto p WHERE UPPER (p.modelo) LIKE :modelo")
                .setParameter("modelo", "%" + valor.toUpperCase() + "%")
                .getResultList();
    }
    
    public List<Produto> buscarProdutoPorNomeFantasiaFornecedor(String valor) {
        return getEm().createQuery("SELECT p FROM Produto p WHERE UPPER (p.fornecedor.nomeFantasia) LIKE :nomeFantasia")
                .setParameter("nomeFantasia", "%" + valor.toUpperCase() + "%")
                .getResultList();
    }

    public List<Produto> buscarProdutoPorId(String valor) {
        Long id;
        try {
            id = new Long(valor);
            return getEm().createQuery("SELECT p FROM Produto p WHERE p.id =:id")
                    .setParameter("id", id)
                    .getResultList();
        } catch (NumberFormatException ex) {
            return listarTodos();
        }
    }
}