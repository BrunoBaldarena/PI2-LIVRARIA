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
    private float valorTotalItem;
    private float valor; 
    private int codigoProd;
    private String nome;
    private float valorUnitario;
    private float descontoItem; 
    private int codVenda; 

    public ItemVenda() {
    }

    public ItemVenda(int id, int quantidade, float valorTotalItem, float valor, int codigoProd, String nome, float valorUnitario, float descontoItem, int codVenda) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorTotalItem = valorTotalItem;
        this.valor = valor;
        this.codigoProd = codigoProd;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.descontoItem = descontoItem;
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

    public float getValorTotalItem() {
        return valorTotalItem;
    }

    public void setValorTotalItem(float valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
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

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public float getDescontoItem() {
        return descontoItem;
    }

    public void setDescontoItem(float descontoItem) {
        this.descontoItem = descontoItem;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }
    
    
    
   
    
}
