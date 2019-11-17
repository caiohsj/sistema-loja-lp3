/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.fonecedor.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;

/**
 *
 * @author Caio
 */
public class FornecedorDAO extends GenericDAO<Fornecedor> {
    
    public FornecedorDAO() {
        super(Fornecedor.class);
    }
    
}
