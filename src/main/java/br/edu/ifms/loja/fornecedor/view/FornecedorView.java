/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.fornecedor.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import maruyama.components.mvc.GenericCRUDView;

/**
 *
 * @author Caio
 */
public class FornecedorView extends GenericCRUDView {
    private JFrame janela;

    public FornecedorView(JPanel formulario) {
        super(formulario);
        janela = new JFrame();
        janela.setSize(700, 700);
        janela.setTitle("Fornecedor");
        janela.add(this);
    }

    @Override
    public String[] configurarCamposDeBusca() {
        return new String[]{"Nome Fantasia", "Cidade", "UF", "ID"};
    }
    
    public void setVisible(boolean b){
        janela.setVisible(b);
    }
}
