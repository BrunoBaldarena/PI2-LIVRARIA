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
public class ItemVenda {
    
    private int id;
    private int quantidade;
    private Double valorTotalItem;
    private Double valor; 
    private int codigoProd;
    private String nome;
    private Double valorUnitario;
    private int codVenda; 

    public ItemVenda() {
    }

    public ItemVenda(int id, int quantidade, Double valorTotalItem, Double valor, int codigoProd, String nome, Double valorUnitario,  int codVenda) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorTotalItem = valorTotalItem;
        this.valor = valor;
        this.codigoProd = codigoProd;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.codVenda = codVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorTotalItem() {
        return valorTotalItem;
    }

    public void setValorTotalItem(Double valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getCodigoProd() {
        return codigoProd;
    }

    public void setCodigoProd(int codigoProd) {
        this.codigoProd = codigoProd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }


    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }
    
    
    
   
    
}
