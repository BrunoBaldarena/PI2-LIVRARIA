/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.controller;

import br.senac.sp.tads.ads.pi2.dao.ProdutoDAO;
import br.senac.sp.tads.ads.pi2.helper.CaixaHelper;
import br.senac.sp.tads.ads.pi2.helper.ProdutoHelper;
import br.senac.sp.tads.ads.pi2.modal.Caixa;
import br.senac.sp.tads.ads.pi2.modal.Produto;
import br.senac.sp.tads.ads.pi2.modal.ProdutoVenda;
import br.senac.tads.ads.pi2.view.telaCaixa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victorsantos
 */
public class CaixaController {
    private final telaCaixa view;
    int countItem = 0;
    double valorAtual = 0;

    public CaixaController(telaCaixa view) {
        this.view = view;        
    }
    
    public void getProduto() throws ClassNotFoundException{   
        try {
            String textoBusca = view.getTxtBusca().getText();
            ProdutoDAO dao = new ProdutoDAO();
            
            ArrayList<Produto> listaInclusaoCaixa = dao.buscarCaixa(textoBusca);
            
            DefaultTableModel tmProdutos = new DefaultTableModel();
            tmProdutos.addColumn("ID");
            tmProdutos.addColumn("Nome");
            tmProdutos.addColumn("Tipo");
            tmProdutos.addColumn("Preco");
            tmProdutos.addColumn("Qtd Estoque");

            view.getTblInclusaoProduto().setModel(tmProdutos);
                
            tmProdutos.setRowCount(0);
                
               
               
            for (Produto p : listaInclusaoCaixa) {
                tmProdutos.addRow(new Object[]{p.getId(),p.getNome(),p.getTipo(),p.getPreco(),p.getQuantidade()});
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public void addItemVenda(ProdutoVenda pv) {
        DefaultTableModel tmItemVenda = (DefaultTableModel) view.getTblItensVenda().getModel();
        
        int qtd = Integer.parseInt(view.getTxtQuantidade().getText());

        
        countItem += 1;
        valorAtual += pv.getPreco() * qtd;
        String preco = "R$"+String.valueOf(valorAtual).replace(".", ",");
        
        
        
        tmItemVenda.addRow(new Object[]{countItem, pv.getTipo(), pv.getNome(), pv.getPreco(), qtd, pv.getPreco() * qtd });
        
        view.getTblItensVenda().setModel(tmItemVenda);
        view.getLblQtdItens().setText(String.valueOf(countItem));
        view.getLblValorAtual().setText(preco);

    }
    
}
