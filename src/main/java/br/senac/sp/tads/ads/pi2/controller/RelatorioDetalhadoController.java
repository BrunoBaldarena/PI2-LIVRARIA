/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.controller;

import br.senac.sp.tads.ads.pi2.dao.ClienteDAO;
import br.senac.sp.tads.ads.pi2.dao.RelatorioDAO;
import br.senac.sp.tads.ads.pi2.dao.UsuarioDAO;
import br.senac.sp.tads.ads.pi2.modal.Cliente;
import br.senac.sp.tads.ads.pi2.modal.RelatorioAnalitico;
import br.senac.sp.tads.ads.pi2.modal.RelatorioSintetico;
import br.senac.sp.tads.ads.pi2.modal.Usuario;
import br.senac.sp.tads.ads.pi2.utils.Conversores;
import br.senac.tads.ads.pi2.view.telaDetalhesRelatorio;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baldarena
 */
public class RelatorioDetalhadoController {
    
    private final telaDetalhesRelatorio view;

    

    public RelatorioDetalhadoController(telaDetalhesRelatorio view) {
        this.view = view;
    }
    
      public void getRelatorioAnalitico(int CodVenda) throws ClassNotFoundException, SQLException {


        RelatorioDAO dao = new RelatorioDAO();
        ClienteDAO clienteDao = new ClienteDAO();
        
        
        RelatorioSintetico dadosVenda = dao.vendaID(CodVenda);
        
        ArrayList<RelatorioAnalitico> listaItens = dao.buscarItemVenda(CodVenda);
        
        DefaultTableModel tmItens = new DefaultTableModel();
        
        tmItens.addColumn("Código");
        tmItens.addColumn("Produto");
        tmItens.addColumn("Tipo");
        tmItens.addColumn("Quantidade");
        tmItens.addColumn("Preço Unitário");
        tmItens.addColumn("Preço Final");
        

        view.getTblDetalhe().setModel(tmItens);

        tmItens.setRowCount(0);

   
        for (RelatorioAnalitico r : listaItens) {
            
            tmItens.addRow(new Object[]{r.getId(), r.getNomeProduto(), r.getTipoProduto(), r.getQuantidade(), r.getValorUnitario(), r.getValorTotalItem()});
        }
        
    
        
        ClienteDAO cDAO = new ClienteDAO();
        UsuarioDAO uDAO = new UsuarioDAO();
        
        Usuario u = uDAO.buscarID(dadosVenda.getCodUsuario());
        Cliente c = cDAO.buscarID(dadosVenda.getCodCliente());
        
        view.getLbNomeCliente().setText(c.getNome());
        view.getLbDataVenda().setText(Conversores.convertDateToView(dadosVenda.getDtVenda()));
        view.getLbTipoPagamento().setText(dadosVenda.getTipoPagamento());
        view.getLbValorTotal().setText(String.valueOf( dadosVenda.getValorTotal()));
        view.getLbVendedor().setText(u.getUsuario());
        view.getLbTotalItensVenda().setText(String.valueOf(dadosVenda.getQtdLivros()));



    
    }

    
    
    
}
