/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.dao;

import br.senac.sp.tads.ads.pi2.modal.RelatorioSintetico;
import br.senac.sp.tads.ads.pi2.utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author baldarena
 */
public class RelatorioDAO {
    
        public ArrayList<RelatorioSintetico> buscar(String de, String ate) throws ClassNotFoundException, SQLException {

        ArrayList<RelatorioSintetico> relatorio = new ArrayList<>();

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;
        String SQL = "SELECT * FROM venda WHERE dataVenda BETWEEN '"+de+"%' AND '"+ate+"%';";
        
        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery(SQL);
        Date data = null;

        try {

            while (rs.next()) {

                RelatorioSintetico rlSintetico = new RelatorioSintetico();

                rlSintetico.setCodCliente(rs.getInt("cliente_id"));
                rlSintetico.setCodUsuario(rs.getInt("usuario_id"));
                rlSintetico.setCodVenda(rs.getInt("id"));                
                rlSintetico.setDtVenda(rs.getString("dataVenda"));
                rlSintetico.setTipoPagamento(rs.getString("tipoPagamento"));
                rlSintetico.setQtdLivros(rs.getInt("quantidade"));
                rlSintetico.setValorTotal(rs.getFloat("valorTotal"));
                
                relatorio.add(rlSintetico);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            st.close();
            rs.close();
            GerenciadorConexao.fecharConexao();
        }
        return relatorio;
    }
        
        public ArrayList<RelatorioSintetico> getVendas() throws ClassNotFoundException, SQLException {

        ArrayList<RelatorioSintetico> relatorio = new ArrayList<>();

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;
        String SQL = "SELECT * FROM venda;";
        
        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery(SQL);
        Date data = null;

        try {

            while (rs.next()) {

                RelatorioSintetico rlSintetico = new RelatorioSintetico();

                rlSintetico.setCodCliente(rs.getInt("cliente_id"));
                rlSintetico.setCodUsuario(rs.getInt("usuario_id"));
                rlSintetico.setCodVenda(rs.getInt("id"));                
                rlSintetico.setDtVenda(rs.getString("dataVenda"));
                rlSintetico.setTipoPagamento(rs.getString("tipoPagamento"));
                rlSintetico.setQtdLivros(rs.getInt("quantidade"));
                rlSintetico.setValorTotal(rs.getFloat("valorTotal"));
                
                relatorio.add(rlSintetico);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            st.close();
            rs.close();
            GerenciadorConexao.fecharConexao();
        }
        return relatorio;
    }
    
}
