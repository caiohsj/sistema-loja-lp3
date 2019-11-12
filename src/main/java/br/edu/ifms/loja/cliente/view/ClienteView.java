/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cliente.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import maruyama.components.mvc.GenericCRUDView;

/**
 *
 * @author Caio
 */
public class ClienteView extends GenericCRUDView {
    private JFrame janela;

    public ClienteView(JPanel formulario) {
        super(formulario);
        janela = new JFrame();
        janela.setSize(600, 500);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setTitle("Cliente");
        janela.add(this);
    }

    @Override
    public String[] configurarCamposDeBusca() {
        return new String[0];
    }
    
    public void setVisible(boolean b){
        janela.setVisible(b);
    }
    
}
