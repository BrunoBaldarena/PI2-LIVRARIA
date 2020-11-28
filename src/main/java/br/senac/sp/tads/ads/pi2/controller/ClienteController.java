/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.controller;

import br.senac.sp.tads.ads.pi2.dao.ClienteDAO;
import br.senac.sp.tads.ads.pi2.helper.ClienteHelper;
import br.senac.sp.tads.ads.pi2.modal.Cliente;
import br.senac.tads.ads.pi2.view.telaCliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victorsantos
 */
public class ClienteController {
    
    private final telaCliente view;
    private final ClienteHelper helper;
    
    public ClienteController (telaCliente view){
        this.view = view;
        this.helper = new ClienteHelper(view);
    }
    
    public void createCliente(){
        Cliente cliente = helper.obterModelo();
        ClienteDAO dao = new ClienteDAO();
        
        try {
            dao.salvar(cliente);
            helper.limparTela();
        } catch (SQLException | ClassNotFoundException ex) {
            view.exibeMensagemAtencao("Falha ao cadastrar!");
        }
    }
    
    public void updateCliente(){
        
        Cliente cliente = helper.obterModelo();
        ClienteDAO dao = new ClienteDAO();
        try {
            dao.editar(cliente);
            helper.limparTela();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getCliente() throws ClassNotFoundException{   
        try {
            String textoBusca = view.getTxtBusca().getText();
            ClienteDAO dao = new ClienteDAO();
            
            ArrayList<Cliente> ListCliente = dao.buscar(textoBusca);
            
            if(ListCliente.size()>0){
                DefaultTableModel tmClientes = new DefaultTableModel();
                tmClientes.addColumn("Codigo");
                tmClientes.addColumn("Nome");
                tmClientes.addColumn("Sexo");
                tmClientes.addColumn("E-Mail");
                tmClientes.addColumn("CPF");
                tmClientes.addColumn("Data Nascimento");
                tmClientes.addColumn("Telefone");
                tmClientes.addColumn("CEP");
                tmClientes.addColumn("Logadouro");
                tmClientes.addColumn("Bairro");
                tmClientes.addColumn("Cidade");
                tmClientes.addColumn("UF");
                tmClientes.addColumn("Complemento");

                view.getTableCliente().setModel(tmClientes);
                
                tmClientes.setRowCount(0);
               
                for (Cliente u : ListCliente) {
                    tmClientes.addRow(new Object[]{u.getId(),u.getNome(),u.getSexo(),u.getEmail(),u.getCpf(),u.getDataNascimento(),u.getTelefone(),u.getCep(),u.getLogadoutro(),u.getBairro(),u.getCidade(),u.getUf(),u.getComplemento()});
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteCliente() throws Exception{
        Cliente cliente = helper.obterModelo();
        ClienteDAO dao = new ClienteDAO();
        
        
        try {
            dao.deletar(cliente.getId());
            helper.limparTela();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void cpfDuplicado() throws ClassNotFoundException{
        ClienteDAO dao = new ClienteDAO();
        
        try {
            dao.verificarCpfDuplicado(view.getTxtCPF().getText());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}