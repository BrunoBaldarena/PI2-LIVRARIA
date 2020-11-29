/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.dao;

import br.senac.sp.tads.ads.pi2.modal.Caixa;
import br.senac.sp.tads.ads.pi2.modal.ItemVenda;
import br.senac.sp.tads.ads.pi2.utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author victorsantos
 */
public class CaixaDAO {
    
    public int salvar(Caixa caixa) throws SQLException, ClassNotFoundException {

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;

        String SQL = "INSERT INTO venda (dataVenda, valorTotal, quantidade, tipoPagamento, usuario_id, cliente_id) VALUES (?,?,?,?,?,?);";

        PreparedStatement ps = conexao.prepareStatement(SQL);
        int idCriado = -1;

        try {
            

            ps.setString(1, caixa.getDataVenda());
            ps.setDouble(2, caixa.getValorTotal());
            ps.setInt(3, caixa.getQuantidade());
            ps.setString(4, caixa.getTipoPagamento());
            ps.setInt(5, caixa.getIdCaixa());
            ps.setInt(6, caixa.getIdCliente());
            
            
            
            ps.execute();     // Executa o Comando
            
            SQL = "SELECT MAX(id) FROM venda;";
            
            ps = conexao.prepareStatement(SQL);
            
            ResultSet rs = ps.executeQuery(SQL);
            
             while (rs.next()) {
                idCriado = rs.getInt("MAX(id)");
             }
                    
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            ps.close();
            GerenciadorConexao.fecharConexao();
        }
        return idCriado;
    }

    public void salvarItens(ItemVenda iv) throws ClassNotFoundException, SQLException {
        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;

        String SQL = "INSERT INTO itemVenda (venda_id, produto_id, valorUnitario, quantidade) VALUES (?,?,?,?);";

        PreparedStatement ps = conexao.prepareStatement(SQL);
        
        
         try {
            

            ps.setInt(1, iv.getCodVenda());
            ps.setDouble(2, iv.getCodigoProd());
            ps.setDouble(3, iv.getValor());
            ps.setInt(4, iv.getQuantidade());
               
            
            
            ps.execute();     // Executa o Comando
            
            ProdutoDAO dao = new ProdutoDAO();
            dao.atualizarQtd(iv.getCodigoProd(), iv.getQuantidade());
                    
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            ps.close();
            GerenciadorConexao.fecharConexao();
        }
    }
    

}
