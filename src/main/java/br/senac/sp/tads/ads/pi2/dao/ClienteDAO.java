/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.dao;

import br.senac.sp.tads.ads.pi2.utils.GerenciadorConexao;
import br.senac.sp.tads.ads.pi2.modal.Cliente;
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
public class ClienteDAO {

    public void salvar(Cliente cliente) throws SQLException, ClassNotFoundException {

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;

        String SQL = "INSERT INTO cliente (nome, cpf, sexo, dataNascimento, telefone, logadouro, cep, cidade, bairro, uf, complemento, email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

        PreparedStatement ps = conexao.prepareStatement(SQL);

        try {

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getSexo());
            ps.setString(4, cliente.getDataNascimento());
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getLogadoutro());
            ps.setString(7, cliente.getCep());
            ps.setString(8, cliente.getCidade());
            ps.setString(9, cliente.getBairro());
            ps.setString(10, cliente.getUf());
            ps.setString(11, cliente.getComplemento());
            ps.setString(12, cliente.getEmail());

            ps.execute();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            ps.close();
            GerenciadorConexao.fecharConexao();
        }

    }

    public void editar(Cliente cliente) throws SQLException, ClassNotFoundException {

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;

        String SQL = "UPDATE cliente SET nome=?, cpf=?, sexo=?, dataNascimento=?, telefone=?, logadouro=?, cep=?, cidade=?, bairro=? ,uf=?, complemento=?, email=? WHERE id=?;";
        PreparedStatement ps = conexao.prepareStatement(SQL);

        try {

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getSexo());
            ps.setString(4, cliente.getDataNascimento());
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getLogadoutro());
            ps.setString(7, cliente.getCep());
            ps.setString(8, cliente.getCidade());
            ps.setString(9, cliente.getBairro());
            ps.setString(10, cliente.getUf());
            ps.setString(11, cliente.getComplemento());
            ps.setString(12, cliente.getEmail());
            ps.setString(13, Integer.toString(cliente.getId()));

            ps.execute();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            ps.close();
            GerenciadorConexao.fecharConexao();
        }

    }

    public ArrayList<Cliente> buscar(String textoBusca) throws ClassNotFoundException, SQLException {

        ArrayList<Cliente> clientes = new ArrayList<>();

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;
        String SQL = "SELECT * FROM cliente";
        //WHERE nome LIKE '%" + textoBusca + "% OR cpf LIKE '%" + textoBusca + "%';";

        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery(SQL);

        try {

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setDataNascimento(rs.getString("dataNascimento"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setLogadoutro(rs.getString("logadouro"));
                cliente.setCep(rs.getString("cep"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setUf(rs.getString("uf"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setEmail(rs.getString("email"));

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            st.close();
            rs.close();
            GerenciadorConexao.fecharConexao();
        }
        return clientes;
    }

    public void deletar(int id)
            throws SQLException, Exception {

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;
        String sql = "DELETE FROM cliente WHERE id=?;";

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

}