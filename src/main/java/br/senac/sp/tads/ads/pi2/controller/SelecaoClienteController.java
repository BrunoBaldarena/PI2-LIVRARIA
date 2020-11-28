/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.controller;

import br.senac.sp.tads.ads.pi2.dao.ClienteDAO;
import br.senac.sp.tads.ads.pi2.modal.Cliente;
import br.senac.tads.ads.pi2.view.telaSelecaoCliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victorsantos
 */
public class SelecaoClienteController {
    private final telaSelecaoCliente view;

    public SelecaoClienteController(telaSelecaoCliente view) {
        this.view = view;
    }
    
    public void getClienteCaixa() throws ClassNotFoundException{   
        try {
            String textoBusca = view.getTxtBusca().getText();
            ClienteDAO dao = new ClienteDAO();
            
            ArrayList<Cliente> ListCliente = dao.buscaCaixa(textoBusca);
            
            if(ListCliente.size()>0){
                DefaultTableModel tmClientes = new DefaultTableModel();
                tmClientes.addColumn("Codigo");
                tmClientes.addColumn("Nome");
                tmClientes.addColumn("CPF");
                

                view.getTableCliente().setModel(tmClientes);
                
                tmClientes.setRowCount(0);
               
                for (Cliente u : ListCliente) {
                    tmClientes.addRow(new Object[]{u.getId(),u.getNome(),u.getCpf()});
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] clienteSelecionado(){
        
        DefaultTableModel tmCliente = (DefaultTableModel) view.getTableCliente().getModel();

        int linha = view.getTableCliente().getSelectedRow();
        
        String id = tmCliente.getValueAt(linha, 0).toString();
        String nome = tmCliente.getValueAt(linha, 1).toString();
        
        String[] retorno = {id, nome};
        
        return retorno;
    }
}
