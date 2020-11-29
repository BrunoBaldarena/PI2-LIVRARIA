/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.dao;

import br.senac.sp.tads.ads.pi2.modal.Caixa;
import br.senac.sp.tads.ads.pi2.utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author victorsantos
 */
public class CaixaDAO {
    
    public void salvar(Caixa caixa) throws SQLException, ClassNotFoundException {

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;

        String SQL = "INSERT INTO venda (dataVenda, valorTotal, quantidade, tipoPagamento, descontoTotal, usuario_id, cliente_id) VALUES (?,?,?,?,?,?,?);";

        PreparedStatement ps = conexao.prepareStatement(SQL);

        try {

            ps.setString(1, caixa.getDataVenda());
            ps.setDouble(2, caixa.getValorTotal());
            ps.setInt(3, caixa.getQuantidade());
            ps.setString(4, caixa.getTipoPagamento());
            ps.setDouble(5, caixa.getDescontoTotal());
            ps.setInt(6, caixa.getIdCaixa());
            ps.setInt(7, caixa.getIdCliente());
            
            
            boolean sucess = ps.execute();     // Executa o Comando
            if(sucess) JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            ps.close();
            GerenciadorConexao.fecharConexao();
        }

    }
    
}
