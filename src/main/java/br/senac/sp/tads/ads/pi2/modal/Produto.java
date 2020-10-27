/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.modal;

/**
 *
 * @author victorsantos
 */
public class Produto {
    private String nome;
    private String categoria;
    private String tipo;
    private String autor;
    private Double preco;
    private int quantidade; 
    private String editora;
    private String observacao; 
    private int ano; 
    private int id;

    public Produto(String nome, String categoria, String tipo, String autor, Double preco, int quantidade, String editora, String observacao, int ano, int id) {
        this.nome = nome;
        this.categoria = categoria;
        this.tipo = tipo;
        this.autor = autor;
        this.preco = preco;
        this.quantidade = quantidade;
        this.editora = editora;
        this.observacao = observacao;
        this.ano = ano;
        this.id = id;
    }

 
    
     public Produto(){
         
     }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
     
     

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public String getAutor() {
        return autor;
    }

    public Double getPreco() {
        return preco;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
