/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.helper;

import br.senac.sp.tads.ads.pi2.modal.Produto;
import br.senac.sp.tads.ads.pi2.modal.ProdutoVenda;
import br.senac.tads.ads.pi2.view.telaCaixa;
import javax.swing.JOptionPane;

/**
 *
 * @author victorsantos
 */
public class CaixaHelper {
    
        private final telaCaixa view;


    public CaixaHelper(telaCaixa view) {
        this.view = view;
    }
    
        
    public boolean verificaEstoque(){
        int quantidadeInformada = Integer.parseInt(view.getTxtQuantidade().getText());
        int quantidadeDisponivel = Integer.parseInt(view.getLblQtdDisponivel().getText());
                
            return quantidadeDisponivel >= quantidadeInformada;
        
    }
    

    public ProdutoVenda getProdutoVenda() {
        
        
        ProdutoVenda pv = new ProdutoVenda();
        
        pv.setNome((String) view.getTblInclusaoProduto().getValueAt(view.getTblInclusaoProduto().getSelectedRow(), 1));
        pv.setTipo((String) view.getTblInclusaoProduto().getValueAt(view.getTblInclusaoProduto().getSelectedRow(), 2));
        pv.setPreco((Double) view.getTblInclusaoProduto().getValueAt(view.getTblInclusaoProduto().getSelectedRow(), 3));
        pv.setQuantidade((int) view.getTblInclusaoProduto().getValueAt(view.getTblInclusaoProduto().getSelectedRow(), 4));
                
        return pv;
    }
    
}

