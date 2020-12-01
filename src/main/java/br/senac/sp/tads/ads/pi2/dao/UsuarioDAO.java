/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.dao;

import br.senac.sp.tads.ads.pi2.utils.GerenciadorConexao;
import br.senac.sp.tads.ads.pi2.modal.Usuario;
import br.senac.sp.tads.ads.pi2.utils.Criptografar;
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
public class UsuarioDAO {
    
    public void salvar(Usuario usuario) throws SQLException, ClassNotFoundException {

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;

        String SQL = "INSERT INTO usuario (tipo, nome, usuario, senha) VALUES (?,?,?,?);";

        PreparedStatement ps = conexao.prepareStatement(SQL);

        try {

            ps.setString(1, usuario.getTipo());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getUsuario());
            ps.setString(4, Criptografar.criptografar(usuario.getSenha()));
            

            ps.execute();


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            ps.close();
            GerenciadorConexao.fecharConexao();
        }

    }

    public void editar(Usuario usuario) throws SQLException, ClassNotFoundException {

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;

        String SQL = "UPDATE usuario SET tipo=?, nome=?, usuario=?, senha=? WHERE id=?;";
        PreparedStatement ps = conexao.prepareStatement(SQL);

        try {

            ps.setString(1, usuario.getTipo());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getUsuario());
            ps.setString(4, Criptografar.criptografar(usuario.getSenha()));
            ps.setInt(5, usuario.getId());
            
            ps.execute();


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            ps.close();
            GerenciadorConexao.fecharConexao();
        }

    }

    public ArrayList<Usuario> buscar(String textoBusca) throws ClassNotFoundException, SQLException {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;
        String SQL = "SELECT * FROM usuario WHERE usuario LIKE '%"+textoBusca+"%' OR nome LIKE '%"+textoBusca+"%';";
        
        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery(SQL);

        try {

            while (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            st.close();
            rs.close();
            GerenciadorConexao.fecharConexao();
        }
        return usuarios;
    }

    public void deletar(int id)
            throws SQLException, Exception {

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;
        String sql = "DELETE FROM usuario WHERE id=?;";

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
    
    public Usuario buscarID(int idUser) throws ClassNotFoundException, SQLException {

        Usuario usuario =null;

        GerenciadorConexao.abrirConexao();

        //Chama a conexao com o banco de dados 
        Connection conexao = GerenciadorConexao.CONEXAO;
        String SQL = "SELECT * FROM usuario WHERE id= "+idUser+";";
        
        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery(SQL);

        try {

            while (rs.next()) {

                usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            st.close();
            rs.close();
            GerenciadorConexao.fecharConexao();
        }
        return usuario;
    }

    public boolean vendaRealizada(String idUsuario) throws SQLException, ClassNotFoundException {
        GerenciadorConexao.abrirConexao();

        
        Connection conexao = GerenciadorConexao.CONEXAO;
        String SQL = "SELECT usuario_id FROM venda WHERE usuario_id = '"+idUsuario+"';";
        
        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery(SQL);
        String id = "";
        

        
        while (rs.next()){
            id = rs.getString("usuario_id");
        }

        
        rs.close();
        GerenciadorConexao.fecharConexao();
        
        return !id.equals("");
    }

    
}
