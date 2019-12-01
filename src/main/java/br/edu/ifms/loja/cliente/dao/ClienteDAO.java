/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cliente.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;
import br.edu.ifms.loja.cliente.datamodel.Cliente;
import java.util.List;

/**
 *
 * @author Caio
 */
public class ClienteDAO extends GenericDAO<Cliente> {
    
    public ClienteDAO() {
        super(Cliente.class);
    }
    
    public List<Cliente> buscarClientePorNome(String valor) {
        return getEm().createQuery("SELECT c FROM Cliente c WHERE UPPER(c.nome) LIKE :nome")
                .setParameter("nome", "%" + valor.toUpperCase() + "%")
                .getResultList();
    }

    public List<Cliente> buscarClientePorCpf(String valor) {
        return getEm().createQuery("SELECT c FROM Cliente c WHERE UPPER (c.cpf) LIKE :cpf")
                .setParameter("cpf", "%" + valor.toUpperCase() + "%")
                .getResultList();
    }
    
    public List<Cliente> buscarClientePorCidade(String valor) {
        return getEm().createQuery("SELECT c FROM Cliente c WHERE UPPER (c.cidade.nome) LIKE :cidade")
                .setParameter("cidade", "%" + valor.toUpperCase() + "%")
                .getResultList();
    }

    public List<Cliente> buscarClientePorId(String valor) {
        Long id;
        try {
            id = new Long(valor);
            return getEm().createQuery("SELECT c FROM Cliente c WHERE c.id =:id")
                    .setParameter("id", id)
                    .getResultList();
        } catch (NumberFormatException ex) {
            return listarTodos();
        }
    }
}
