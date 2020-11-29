/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.controller;

import br.senac.sp.tads.ads.pi2.dao.LoginDAO;
import br.senac.sp.tads.ads.pi2.helper.LoginHelper;
import br.senac.sp.tads.ads.pi2.modal.Usuario;
import br.senac.sp.tads.ads.pi2.utils.Sessao;
import br.senac.tads.ads.pi2.view.telaInicial;
import br.senac.tads.ads.pi2.view.telaLogin;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baldarena
 */
public class LoginController {

    private final telaLogin view;
    private LoginHelper helper;

    public LoginController(telaLogin view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrarNoSistema() throws SQLException, ClassNotFoundException{
        //Pegar um Usuario da View
         Usuario usuario = helper.obterModelo();
         
         LoginDAO dao = new LoginDAO();
         
         Usuario usuarioAutenticacao = dao.checkLogin(usuario); 
         
         if(usuarioAutenticacao != null){
             Sessao sessao = Sessao.getInstance();
             sessao.setUsuario(usuario); // //Usuario é um POJO qualquer;
             telaInicial viewInicial = new telaInicial(usuarioAutenticacao);
             viewInicial.setVisible(true);
         }else{
             view.exibeMensagemAtencao("Usuário ou senha inválidos"); 
             
         }
         
        
        
        //criptografar senha
        //String senha = Criptografar.criptografar(usuario.getSenha());
        
        
        
        
        
        
        //Pesquisa Usuario no banco
        //Validar usuario e direcionar para tela
        //Se não mensagem usuario e senha invalidos
        

        
    }
    
    
}
