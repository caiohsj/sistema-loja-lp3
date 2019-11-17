/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cliente.bo;

import br.edu.ifms.loja.cidade.datamodel.Cidade;
import br.edu.ifms.loja.cliente.datamodel.Cliente;
import br.edu.ifms.loja.cliente.view.ClienteView;
import br.edu.ifms.loja.cliente.view.FormCliente;
import br.edu.ifms.loja.uf.datamodel.Uf;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import maruyama.components.mvc.GenericCRUDController;
import maruyama.components.mvc.GenericCRUDModel;
import maruyama.components.mvc.GenericCRUDView;

/**
 *
 * @author Caio
 */
public class ClienteController extends GenericCRUDController<Cliente> {
    private ClienteView view;
    private ClienteBO model;

    public ClienteController(GenericCRUDModel model, GenericCRUDView view) {
        super(model, view);
        this.view = (ClienteView) view;
        this.model = (ClienteBO) model;
        carregarComboBoxUf();
        inicializarAcoesComboBox();
    }

    public void inicializarAcoesComboBox() {
        FormCliente form = (FormCliente) view.getFormulario();
        form.getComboUf().addActionListener((evt) -> {
            carregarCidades();
        });
    }

    public void carregarComboBoxUf() {
        FormCliente form = (FormCliente) view.getFormulario();
        form.getComboUf().removeAllItems();
        for (Uf uf : model.listarUfs()) {
            form.getComboUf().addItem(uf);
        }
    }

    public void carregarCidades() {
        FormCliente form = (FormCliente) view.getFormulario();
        Uf uf = (Uf) form.getComboUf().getSelectedItem();
        form.getComboCidade().removeAllItems();
        if (uf == null) {
            return;
        }
        for (Cidade cidade : model.listarCidadesPorUf(uf)) {
            form.getComboCidade().addItem(cidade);
        }
    }

    @Override
    public void dadosViewParaModel(Cliente t, JPanel pnl) {
        FormCliente form = (FormCliente) pnl;
        t.setNome(form.getCampoNome().getText());
        t.setEmail(form.getCampoEmail().getText());
        t.setTelefone(form.getCampoTelefone().getText());
        t.setEndereco(form.getCampoEndereco().getText());
        t.setNumero(Integer.parseInt(form.getCampoNumero().getText()));
        t.setCpf(form.getCampoCpf().getText());
        t.setCep(form.getCampoCep().getText());
        t.setCidade((Cidade) form.getComboCidade().getSelectedItem());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dt = (Date) dateFormat.parse(form.getCampoDataDeNascimento().getText());
            t.setDataNascimento(dt);
        } catch (ParseException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void dadosModelParaView(Cliente t, JPanel pnl) {
        FormCliente form = (FormCliente) pnl;
        form.getCampoNome().setText(t.getNome());
        form.getCampoEmail().setText(t.getEmail());
        form.getCampoTelefone().setText(t.getTelefone());
        form.getCampoEndereco().setText(t.getEndereco());
        form.getCampoNumero().setText(String.valueOf(t.getNumero()));
        form.getCampoCpf().setText(t.getCpf());
        form.getCampoCep().setText(t.getCep());
        form.getCampoNome().setText(t.getDataNascimento().toString());
        form.getComboUf().setSelectedItem(t.getCidade().getUf());
        form.getComboCidade().setSelectedItem(t.getCidade());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        form.getCampoDataDeNascimento().setText(dateFormat.format(t.getDataNascimento()));
    }
    
}
