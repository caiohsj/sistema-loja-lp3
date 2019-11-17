/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cidade.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;
import br.edu.ifms.loja.cidade.datamodel.Cidade;
import br.edu.ifms.loja.uf.datamodel.Uf;
import java.util.List;

/**
 *
 * @author gusta
 */
public class CidadeDAO extends GenericDAO<Cidade>{
    
    public CidadeDAO() {
        super(Cidade.class);
    }
    
    public List<Cidade> listarCidadesPorUf(Uf uf) {
        return getEm().createQuery("SELECT c FROM Cidade c WHERE c.uf.id =:ufId")
                .setParameter("ufId", uf.getId())
                .getResultList();
    }
    
}
