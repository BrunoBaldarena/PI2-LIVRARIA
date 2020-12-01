/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.helper;

import br.senac.sp.tads.ads.pi2.modal.Usuario;
import br.senac.tads.ads.pi2.view.telaUsuario;

/**
 *
 * @author baldarena
 */
public class UsuarioHelper {
    
   private final telaUsuario view;

    public UsuarioHelper(telaUsuario view) {
        this.view = view;
    }
    
        
     /** @author baldarena
     * Metodo que é utilizado para capturar os dados da view para um objeto
     */   
    public Usuario obterModelo(){
                
        int codigo = 0;
        String user = view.getTxtUsuario().getText();
        String senha = String.valueOf(view.getTxtSenha().getPassword());
        String tipo = (String) view.getCbxTipo().getSelectedItem();
        String nome = view.getTxtNome().getText();
        String codigoP = view.getTxtCodigo().getText();
        
        if(codigoP.length() >0){
            codigo = Integer.parseInt(codigoP);
        }
        
        Usuario modelo = new Usuario();
        modelo.setUsuario(user);
        modelo.setSenha(senha);
        modelo.setNome(nome);
        modelo.setTipo(tipo);
        modelo.setId(codigo);
        return modelo;
    }
    
      /** @author baldarena
     * Metodo que é utilizado para definir os dados da de um objeti na view
     */   
    public void setarModelo(Usuario modelo){
        String usuario = modelo.getUsuario();
        String senha = modelo.getSenha();
        String nome = modelo.getNome();
        String tipo = modelo.getTipo();
        String codigo = String.valueOf(modelo.getId());
        
        view.getTxtUsuario().setText(usuario);
        view.getTxtSenha().setText(senha);
        view.getCbxTipo().setSelectedItem(tipo);
        view.getTxtNome().setName(nome);
        view.getTxtCodigo().setText(codigo);
         
    }
    
     /** @author baldarena
     * Metodo que é utilizado para limpar os campos da view
     */  
    public void limparTela(){
        view.getTxtUsuario().setText("");
        view.getTxtSenha().setText("");
        view.getTxtNome().setText("");
        view.getCbxTipo().setSelectedIndex(0);
        view.getTxtCodigo().setText("");
        view.getTxtBusca().setText("");
        
    }
    
    
   
}
