/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cliente.bo;

import br.edu.ifms.loja.cidade.datamodel.Cidade;
import br.edu.ifms.loja.cliente.datamodel.Cliente;
import br.edu.ifms.loja.cliente.view.FormCliente;
import javax.swing.JPanel;
import maruyama.components.mvc.GenericCRUDController;
import maruyama.components.mvc.GenericCRUDModel;
import maruyama.components.mvc.GenericCRUDView;

/**
 *
 * @author Caio
 */
public class ClienteController extends GenericCRUDController<Cliente> {

    public ClienteController(GenericCRUDModel model, GenericCRUDView view) {
        super(model, view);
        carregarComboBoxCidade(view,(ClienteBO) model);
    }

    public void carregarComboBoxCidade(GenericCRUDView view, ClienteBO model) {
        FormCliente form = (FormCliente) view.getFormulario();
        form.getComboCidade().removeAllItems();
        
        for(Cidade cidade : model.listarCidades()){
            form.getComboCidade().addItem(cidade);
        }
    }

    @Override
    public void dadosViewParaModel(Cliente t, JPanel pnl) {
        FormCliente form = (FormCliente) pnl;
        t.setNome(form.getCampoNome().getText());
        t.setCidade((Cidade) form.getComboCidade().getSelectedItem());
    }

    @Override
    public void dadosModelParaView(Cliente t, JPanel pnl) {
        FormCliente form = (FormCliente) pnl;
        form.getCampoNome().setText(t.getNome());
        form.getComboCidade().setSelectedItem(t.getCidade());
    }
    
}
