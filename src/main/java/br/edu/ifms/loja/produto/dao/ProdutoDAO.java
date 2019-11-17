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
}