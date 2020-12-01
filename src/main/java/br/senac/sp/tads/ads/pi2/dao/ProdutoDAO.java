/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.dao;

import br.senac.sp.tads.ads.pi2.modal.ItemVenda;
import br.senac.sp.tads.ads.pi2.utils.GerenciadorConexao;
import br.senac.sp.tads.ads.pi2.modal.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author baldarena
 */
public class ProdutoDAO {
    
 public void salvar(Produto produto) throws SQLException, ClassNotFoundException {

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;

        String SQL = "INSERT INTO produto (nome, categoria, tipo, autor, preco, quantidade, editora, observacao, ano) VALUES (?,?,?,?,?,?,?,?,?);";

        PreparedStatement ps = conexao.prepareStatement(SQL);

        try {

            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getCategoria());
            ps.setString(3, produto.getTipo());
            ps.setString(4, produto.getAutor());
            ps.setDouble(5, produto.getPreco());
            ps.setInt(6, produto.getQuantidade());
            ps.setString(7, produto.getEditora());
            ps.setString(8, produto.getObservacao());
            ps.setInt(9, produto.getAno());

            ps.execute();


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            ps.close();
            GerenciadorConexao.fecharConexao();
        }

    }

    public void editar(Produto produto) throws SQLException, ClassNotFoundException {

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;

        
        String SQL = "UPDATE produto SET nome=?, categoria=?, tipo=?, autor=?, preco=?, quantidade=?, editora=?, observacao=?, ano=? WHERE id=?;";

        PreparedStatement ps = conexao.prepareStatement(SQL);

        try {

            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getCategoria());
            ps.setString(3, produto.getTipo());
            ps.setString(4, produto.getAutor());
            ps.setDouble(5, produto.getPreco());
            ps.setInt(6, produto.getQuantidade());
            ps.setString(7, produto.getEditora());
            ps.setString(8, produto.getObservacao());
            ps.setInt(9, produto.getAno());
            ps.setInt(10, produto.getId());
            

            ps.execute();


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            ps.close();
            GerenciadorConexao.fecharConexao();
        }

    }

    public ArrayList<Produto> buscar(String textoBusca) throws ClassNotFoundException, SQLException {

        ArrayList<Produto> produtos = new ArrayList<>();

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;
        String SQL = "SELECT * FROM produto WHERE id LIKE '%"+textoBusca+"%' OR nome LIKE '%"+textoBusca+"%';";
        
        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery(SQL);

        try {

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setTipo(rs.getString("tipo"));
                produto.setAutor(rs.getString("autor"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setEditora(rs.getString("editora"));
                produto.setObservacao(rs.getString("observacao"));
                produto.setAno(rs.getInt("ano"));
                produtos.add(produto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            st.close();
            rs.close();
            GerenciadorConexao.fecharConexao();
        }
        return produtos;
    }
    
    public ArrayList<Produto> buscarCaixa(String textoBusca) throws ClassNotFoundException, SQLException {

        ArrayList<Produto> produtos = new ArrayList<>();

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;
        String SQL = "SELECT id, nome, tipo, preco, quantidade FROM produto WHERE nome LIKE '%"+textoBusca+"%';";
        
        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery(SQL);

        try {

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setTipo(rs.getString("tipo"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            st.close();
            rs.close();
            GerenciadorConexao.fecharConexao();
        }
        return produtos;
    }

    public void deletar(int id)
            throws SQLException, Exception {

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;
        String sql = "DELETE FROM produto WHERE id=?;";

        PreparedStatement pst = conexao.prepareStatement(sql);

        try {

            pst.setInt(1, id);

            pst.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            pst.close();
            GerenciadorConexao.fecharConexao();

        }

    }

    public void atualizarQtd(ItemVenda iv) throws ClassNotFoundException, SQLException {
        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;

        
        String SQL = "UPDATE produto SET quantidade=quantidade-"+iv.getQuantidade()+" WHERE id="+iv.getCodigoProd()+";";

        Statement st = conexao.createStatement();

        try {

            st.execute(SQL);


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            st.close();
            GerenciadorConexao.fecharConexao();
        }
    }   

    public boolean foiVendido(String idProduto) throws SQLException, ClassNotFoundException {
        GerenciadorConexao.abrirConexao();

        
        Connection conexao = GerenciadorConexao.CONEXAO;
        String SQL = "SELECT produto_id FROM itemVenda WHERE produto_id = '"+idProduto+"';";
        
        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery(SQL);
        String id = "";
        

        
        while (rs.next()){
            id = rs.getString("produto_id");
        }

        
        rs.close();
        GerenciadorConexao.fecharConexao();
        
        return !id.equals("");
    }

}

