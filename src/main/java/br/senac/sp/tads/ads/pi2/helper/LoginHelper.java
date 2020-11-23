/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.helper;

import br.senac.sp.tads.ads.pi2.modal.Usuario;
import br.senac.tads.ads.pi2.view.telaLogin;

/**
 *
 * @author baldarena
 */
public class LoginHelper {
    
   private final telaLogin view;

    public LoginHelper(telaLogin view) {
        this.view = view;
    }
    
    public Usuario obterModelo(){
                
        String user = view.getTxtUsuario().getText();
        String senha = String.valueOf(view.getTxtSenha().getPassword());
        
        Usuario modelo = new Usuario();
        modelo.setUsuario(user);
        modelo.setSenha(senha);
        return modelo;
    }
    
    public void setarModelo(Usuario modelo){
        String usuario = modelo.getUsuario();
        String senha = modelo.getSenha();
        
        view.getTxtUsuario().setText(usuario);
        view.getTxtSenha().setText(senha);
        
        
    }
    
    public void limparTela(){
        view.getTxtUsuario().setText("");
        view.getTxtSenha().setText("");
    }
   
   
    
}
