/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.modal;

/**
 *
 * @author baldarena
 */
public class Usuario {
    
    private int cod; 
    private String tipo;
    private String nome; 
    private String usuario;
    private String senha;

    public Usuario(int cod, String nome, String tipo, String usuario, String senha) {
        this.cod = cod;
        this.nome = nome;
        this.tipo = tipo;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario() {
    }

    public int getCod() {
        return cod;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
    
    
    
     
    
   
    
    
    
}
