/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.produto.bo;

import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import br.edu.ifms.loja.produto.datamodel.Produto;
import br.edu.ifms.loja.produto.view.FormProduto;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JPanel;
import maruyama.components.mvc.GenericCRUDController;
import maruyama.components.mvc.GenericCRUDModel;
import maruyama.components.mvc.GenericCRUDView;
import maruyama.components.swing.ObjectTableModel;

/**
 *
 * @author Caio
 */
public class ProdutoController extends GenericCRUDController<Produto>{

    public ProdutoController(GenericCRUDModel model, GenericCRUDView view) {
        super(model, view);
        carregarComboBoxFornecedor(view, (ProdutoBO) model);
        inicializarAcoesDeBusca(view, (ProdutoBO) model);
    }
    
    public void inicializarAcoesDeBusca(GenericCRUDView view, ProdutoBO model) {
        view.getCampoBusca().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String campo = (String) view.getComboBoxAtributoDeBusca().getSelectedItem();
                String valor = view.getCampoBusca().getText();
                List<Produto> lista = model.buscar(campo, valor);
                ObjectTableModel tableModel = new ObjectTableModel(Produto.class, lista);
                view.getTabela().setModel(tableModel);
            }
        });
    }
    

    @Override
    public void dadosViewParaModel(Produto p, JPanel arg1) {
        FormProduto form = (FormProduto) arg1;
        p.setDescricao(form.getCampoDescricao().getText());
        p.setMarca(form.getCampoMarca().getText());
        p.setModelo(form.getCampoModelo().getText());
        p.setQtde(Integer.parseInt(form.getCampoQtde().getValue().toString()));
        p.setValor(Double.parseDouble(form.getCampoValor().getText()));
        p.setFornecedor((Fornecedor) form.getComboFornecedor().getSelectedItem());
    }

    @Override
    public void dadosModelParaView(Produto p, JPanel arg1) {
        FormProduto form = (FormProduto) arg1;
        form.getCampoDescricao().setText(p.getDescricao());
        form.getCampoMarca().setText(p.getMarca());
        form.getCampoModelo().setText(p.getModelo());
        form.getCampoQtde().setValue(p.getQtde());
        form.getCampoValor().setText(String.valueOf(p.getValor()));
        form.getComboFornecedor().setSelectedItem(p.getFornecedor());
    }
    
    public void carregarComboBoxFornecedor(GenericCRUDView view, ProdutoBO model){
        FormProduto form = (FormProduto) view.getFormulario();
        
        for(Fornecedor fornecedor : model.listarFornecedores()) {
            form.getComboFornecedor().addItem(fornecedor);
        }
    }
    
}
