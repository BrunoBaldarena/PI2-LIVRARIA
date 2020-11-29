/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.controller;

import br.senac.sp.tads.ads.pi2.dao.CaixaDAO;
import br.senac.sp.tads.ads.pi2.dao.ProdutoDAO;
import br.senac.sp.tads.ads.pi2.helper.CaixaHelper;
import br.senac.sp.tads.ads.pi2.helper.ProdutoHelper;
import br.senac.sp.tads.ads.pi2.modal.Caixa;
import br.senac.sp.tads.ads.pi2.modal.ItemVenda;
import br.senac.sp.tads.ads.pi2.modal.Produto;
import br.senac.sp.tads.ads.pi2.modal.ProdutoVenda;
import br.senac.tads.ads.pi2.view.telaCaixa;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victorsantos
 */
public class CaixaController {
    private final telaCaixa view;
    int seqCod = 0;
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

        seqCod += 1;
        countItem += qtd;
        valorAtual += pv.getPreco() * qtd;
        
        DecimalFormat df = new DecimalFormat("###.##");
        df.setRoundingMode(RoundingMode.UP);
        
        String preco = "R$"+String.valueOf(df.format(valorAtual)).replace(".", ",");
        
        
        
        tmItemVenda.addRow(new Object[]{seqCod,pv.getId(), pv.getNome(), pv.getTipo(), pv.getPreco(), qtd, pv.getPreco() * qtd });
        
        view.getTblItensVenda().setModel(tmItemVenda);
        view.getLblQtdItens().setText(String.valueOf(countItem));
        view.getLblValorAtual().setText(preco);

    }
    
    public void removeItemVenda(){
        DefaultTableModel tmItemVenda = (DefaultTableModel) view.getTblItensVenda().getModel();
        
        int linha = view.getTblItensVenda().getSelectedRow();
        
        double valorItemRemovido = Double.parseDouble(tmItemVenda.getValueAt(linha, 5).toString());
        int qtdItemRemovido = Integer.parseInt(tmItemVenda.getValueAt(linha, 4).toString());
        
        tmItemVenda.removeRow(linha);
        
        view.getTblItensVenda().setModel(tmItemVenda);
        
        countItem -= qtdItemRemovido;
        valorAtual -= valorItemRemovido;
        
        DecimalFormat df = new DecimalFormat("###.##");
        df.setRoundingMode(RoundingMode.UP);
        
        String preco = "R$"+String.valueOf(df.format(valorAtual)).replace(".", ",");
        
        view.getLblQtdItens().setText(String.valueOf(countItem));
        view.getLblValorAtual().setText(preco);
    }
    
    public void createVenda(int userID, int cliID) throws SQLException, ClassNotFoundException{
    
        Date data = new Date(System.currentTimeMillis()); 
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd"); 
        
        String dataVenda = formatarDate.format(data);
        Double valorTotal = Double.parseDouble(view.getLblValorAtual().getText().substring(2).replace(",", "."));
        int qtdItens = Integer.parseInt(view.getLblQtdItens().getText());
        String tipoPagamento = view.getMetodoPagamento();
        int usuarioId = userID;
        int clienteId = cliID;
        
        Caixa caixa = new Caixa();
        
        caixa.setDataVenda(dataVenda);
        caixa.setValorTotal(valorTotal);
        caixa.setQuantidade(qtdItens);
        caixa.setTipoPagamento(tipoPagamento);
        caixa.setIdCaixa(usuarioId);
        caixa.setIdCliente(clienteId);
        
        CaixaDAO dao = new CaixaDAO();
        int idVenda = dao.salvar(caixa);
        int idProduto = 0;
        Double valorUnitario = 0.00;
        int qtd = 0;
        
        DefaultTableModel tmItemVenda = (DefaultTableModel) view.getTblItensVenda().getModel();

        int totalRows = tmItemVenda.getRowCount();
        
         for (int i = 0; i < totalRows; i++) {
             ItemVenda iv = new ItemVenda();
             
             iv.setCodVenda(idVenda);
             iv.setCodigoProd((int) tmItemVenda.getValueAt(i, 1));
             iv.setQuantidade((int) tmItemVenda.getValueAt(i, 5));
             iv.setValor((Double)tmItemVenda.getValueAt(i, 4));
             
             dao.salvarItens(iv);
             JOptionPane.showMessageDialog(null, i, "Aviso",JOptionPane.WARNING_MESSAGE);
         }
        
        //
        
        //JOptionPane.showMessageDialog(null, dataVenda + " | " + valorTotal + " | " + qtdItens + " | " + tipoPagamento + " | " + usuarioId + " | " + clienteId, "Aviso",JOptionPane.WARNING_MESSAGE);
    }
    
}
