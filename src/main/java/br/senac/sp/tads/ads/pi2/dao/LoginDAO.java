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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baldarena
 */
public class LoginDAO {

    public LoginDAO() {
        try {
            GerenciadorConexao.abrirConexao();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public Usuario checkLogin(Usuario user) throws SQLException {

        Connection con = GerenciadorConexao.CONEXAO;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        
        
          Usuario usuario = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM usuario WHERE usuario = ? and senha = ?");
            stmt.setString(1, user.getUsuario());
            stmt.setString(2, Criptografar.criptografar(user.getSenha()));

            rs = stmt.executeQuery();
          

            if (rs.next()) {
                usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
               
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rs.close();
            stmt.close();
            GerenciadorConexao.fecharConexao();
        }

        return usuario;

    }
        
}
