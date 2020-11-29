/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.controller;

import br.senac.sp.tads.ads.pi2.dao.ClienteDAO;
import br.senac.sp.tads.ads.pi2.dao.UsuarioDAO;
import br.senac.sp.tads.ads.pi2.helper.UsuarioHelper;
import br.senac.sp.tads.ads.pi2.modal.Cliente;
import br.senac.sp.tads.ads.pi2.modal.Usuario;
import br.senac.tads.ads.pi2.view.telaUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baldarena
 */
public class UsuarioController {

    private final telaUsuario view;
    private final UsuarioHelper helper;

    public UsuarioController(telaUsuario view) {
        this.view = view;
        this.helper = new UsuarioHelper(view);
    }
    
    public void createUsuario(){
        
        Usuario usuario = helper.obterModelo();
        UsuarioDAO dao = new UsuarioDAO();
       
        try {
            dao.salvar(usuario);
            helper.limparTela();
        } catch (SQLException | ClassNotFoundException ex) {
            view.exibeMensagemAtencao("Falha ao cadastrar!");
        }
        
    }
    
    public void updateUsuario(){
        
       Usuario usuario = helper.obterModelo();
       UsuarioDAO dao = new UsuarioDAO();
        try {
            dao.editar(usuario);
            helper.limparTela();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       

       
        
    }
    
    public void getUsuario() throws ClassNotFoundException{
        
                
        try {
            
            String textoBusca = view.getTxtBusca().getText();
            
            //Usuario usuario = helper.obterModelo();
            UsuarioDAO dao = new UsuarioDAO();
            
            ArrayList<Usuario> ListUsuarios = dao.buscar(textoBusca);
            
            if(ListUsuarios.size()>0){
                DefaultTableModel tmUsuarios = new DefaultTableModel();
                 tmUsuarios.addColumn("Código");
                 tmUsuarios.addColumn("Tipo");
                 tmUsuarios.addColumn("Nome");
                 tmUsuarios.addColumn("Usuário");
                view.getTblUsuario().setModel(tmUsuarios);
                
               tmUsuarios.setRowCount(0);
               
               for (Usuario u : ListUsuarios) {
                tmUsuarios.addRow(new Object[]{u.getId(),u.getTipo(),u.getNome(),u.getUsuario()});
                }
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public void deleteUsuario() throws Exception{
        Usuario usuario = helper.obterModelo();
        UsuarioDAO dao = new UsuarioDAO();
        
        
        try {
            dao.deletar(usuario.getId());
            helper.limparTela();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
