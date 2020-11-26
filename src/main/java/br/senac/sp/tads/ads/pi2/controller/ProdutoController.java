/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.controller;

import br.senac.sp.tads.ads.pi2.dao.ProdutoDAO;
import br.senac.sp.tads.ads.pi2.helper.ProdutoHelper;
import br.senac.sp.tads.ads.pi2.modal.Produto;
import br.senac.tads.ads.pi2.view.telaProduto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diogo.carauta
 */
public class ProdutoController {
    
    private final telaProduto view;
    private final ProdutoHelper helper;
    
    public ProdutoController (telaProduto view){
        this.view = view;
        this.helper = new ProdutoHelper(view);
    }
    
    public void createProduto(){
        Produto p = helper.obterModelo();
        ProdutoDAO dao = new ProdutoDAO();
        
        try {
            dao.salvar(p);
            helper.limparTela();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateProduto(){
        
        Produto p = helper.obterModelo();
        ProdutoDAO dao = new ProdutoDAO();
        try {
            dao.editar(p);
            helper.limparTela();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getProduto() throws ClassNotFoundException{   
        try {
            String textoBusca = view.getTxtBusca().getText();
            ProdutoDAO dao = new ProdutoDAO();
            
            ArrayList<Produto> listaProdutos = dao.buscar(textoBusca);
            
            DefaultTableModel tmProdutos = new DefaultTableModel();
            tmProdutos.addColumn("Codigo");
            tmProdutos.addColumn("Produto");
            tmProdutos.addColumn("Autor");
            tmProdutos.addColumn("Editora");
            tmProdutos.addColumn("Ano");
            tmProdutos.addColumn("Preco");
            tmProdutos.addColumn("Tipo");
            tmProdutos.addColumn("Categoria");
            tmProdutos.addColumn("Items em Estoque");
            tmProdutos.addColumn("Observação");

            view.getTblProduto().setModel(tmProdutos);
                
            tmProdutos.setRowCount(0);
                
               
               
            for (Produto p : listaProdutos) {
                tmProdutos.addRow(new Object[]{p.getId(),p.getNome(),p.getAutor(),p.getEditora(),p.getAno(),p.getPreco(),p.getTipo(),p.getCategoria(),p.getQuantidade(),p.getObservacao()});
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteProduto() throws Exception{
        Produto produto = helper.obterModelo();
        ProdutoDAO dao = new ProdutoDAO();
        
        
        try {
            dao.deletar(produto.getId());
            helper.limparTela();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}