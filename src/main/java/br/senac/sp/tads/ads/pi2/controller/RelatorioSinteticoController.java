/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.controller;

import br.senac.sp.tads.ads.pi2.dao.ClienteDAO;
import br.senac.sp.tads.ads.pi2.dao.RelatorioDAO;
import br.senac.sp.tads.ads.pi2.dao.UsuarioDAO;
import br.senac.sp.tads.ads.pi2.helper.RelatorioSinteticoHelper;
import br.senac.sp.tads.ads.pi2.modal.Cliente;
import br.senac.sp.tads.ads.pi2.modal.RelatorioSintetico;
import br.senac.sp.tads.ads.pi2.modal.Usuario;
import br.senac.sp.tads.ads.pi2.utils.Conversores;
import br.senac.tads.ads.pi2.view.telaRelatorio;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baldarena
 */
public class RelatorioSinteticoController {

    private final telaRelatorio view;
    private final RelatorioSinteticoHelper helper;

    public RelatorioSinteticoController(telaRelatorio view) {
        this.view = view;
        this.helper = new RelatorioSinteticoHelper(view);
    }

    public void getRelatorioSinteticoParam() throws ClassNotFoundException, SQLException {

        RelatorioSintetico rls = helper.obterModelo();

        RelatorioDAO dao = new RelatorioDAO();
        ClienteDAO clienteDao = new ClienteDAO();
        
        
        ArrayList<RelatorioSintetico> listaRelatorio = dao.buscar(rls.getDtInicio(), rls.getDtFinal());
        


        DefaultTableModel tmRelatorio = new DefaultTableModel();
        
        tmRelatorio.addColumn("Código");
        tmRelatorio.addColumn("Cliente");
        tmRelatorio.addColumn("Vendedor");
        tmRelatorio.addColumn("Data Compra");
        tmRelatorio.addColumn("Quantidade Livros");
        tmRelatorio.addColumn("Valor Total");

        view.getTblVendas().setModel(tmRelatorio);

        tmRelatorio.setRowCount(0);

        int intQtdTotal = 0;
        int intQtdVendas = listaRelatorio.size();
        float FvalorTotal = 0;
        
        UsuarioDAO uDAO = new UsuarioDAO();
        
        
        
        
        
        for (RelatorioSintetico r : listaRelatorio) {
            
            Usuario u = uDAO.buscarID(r.getCodUsuario());
            
            Cliente cliente = clienteDao.buscarID(r.getCodCliente());

            intQtdTotal += r.getQtdLivros();
            FvalorTotal += r.getValorTotal();
            tmRelatorio.addRow(new Object[]{r.getCodVenda(),cliente.getNome(),u.getUsuario(), Conversores.convertDateToView(r.getDtVenda()), r.getQtdLivros(), r.getValorTotal()});
        }

        String qtdLivros = String.valueOf(intQtdTotal);
        String qtdVendas = String.valueOf(intQtdVendas);
        String valorTotal = String.valueOf(FvalorTotal);

        view.getLblLivrosVendidos().setText(qtdLivros);
        view.getLblQtdVendas().setText(qtdVendas);
        view.getLblValorTotal().setText(valorTotal);

    
    }

    
}
