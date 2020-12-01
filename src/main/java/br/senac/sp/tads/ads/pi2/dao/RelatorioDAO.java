/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.dao;

import br.senac.sp.tads.ads.pi2.modal.RelatorioAnalitico;
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
        
        String SQL = null;
        
        
        if(de != null && ate != null){
            SQL = "SELECT * FROM venda WHERE dataVenda BETWEEN '"+de+"' AND '"+ate+"';";
        }
        
        if(de == null && ate == null){
            SQL = "SELECT * FROM venda";
            
        }
        
        if(de != null && ate==null){
            SQL = "SELECT * FROM venda WHERE dataVenda >= '"+de+"';";
            
        }
        
        if(ate != null && de==null){
            SQL = "SELECT * FROM venda WHERE dataVenda <= '"+ate+"';";
            
        }
        
        
        
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
        
        
       public RelatorioSintetico vendaID(int codVenda) throws ClassNotFoundException, SQLException {

        GerenciadorConexao.abrirConexao();
         RelatorioSintetico rlSintetico = null;

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;
        
        String SQL = "SELECT * FROM venda WHERE id= "+codVenda+";";
        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery(SQL);
        Date data = null;

        try {

            while (rs.next()) {

                rlSintetico = new RelatorioSintetico();
                rlSintetico.setCodCliente(rs.getInt("cliente_id"));
                rlSintetico.setCodUsuario(rs.getInt("usuario_id"));
                rlSintetico.setCodVenda(rs.getInt("id"));                
                rlSintetico.setDtVenda(rs.getString("dataVenda"));
                rlSintetico.setTipoPagamento(rs.getString("tipoPagamento"));
                rlSintetico.setQtdLivros(rs.getInt("quantidade"));
                rlSintetico.setValorTotal(rs.getFloat("valorTotal"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            st.close();
            rs.close();
            GerenciadorConexao.fecharConexao();
        }
        return rlSintetico;
    }
       
        public ArrayList<RelatorioAnalitico> buscarItemVenda(int codVenda) throws ClassNotFoundException, SQLException {

        ArrayList<RelatorioAnalitico> relatorio = new ArrayList<>();

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;
        
        
        
        String SQL = "SELECT P.nome, P.tipo,I.venda_id, I.valorUnitario, I.quantidade, I.id, I.produto_ID FROM itemVenda AS I\n" +
                     "INNER JOIN produto AS P ON I.produto_id = P.id\n" +
                      "WHERE venda_id= "+codVenda+";";
        
        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery(SQL);
        Date data = null;

        try {

            while (rs.next()) {

                RelatorioAnalitico rlAnalitico = new RelatorioAnalitico();
                
                int quantidade = rs.getInt("I.quantidade");
                float valorUnitario = rs.getFloat("I.valorUnitario");
                float valorTotalItem = quantidade * valorUnitario;
                

                rlAnalitico.setId(rs.getInt("I.id"));
                rlAnalitico.setCodVenda(rs.getInt("I.venda_id"));
                rlAnalitico.setCodProduto(rs.getInt("I.produto_id"));                
                rlAnalitico.setValorUnitario(valorUnitario);
                rlAnalitico.setQuantidade(quantidade);
                rlAnalitico.setValorTotalItem(valorTotalItem);
                rlAnalitico.setNomeProduto(rs.getString("P.nome"));
                rlAnalitico.setTipoProduto(rs.getString("P.tipo"));
                
                
                relatorio.add(rlAnalitico);
                
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
