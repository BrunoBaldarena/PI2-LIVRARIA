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
public class RelatorioAnalitico {
    
    private int id;
    private int codCliente; 
    private int codVenda; 
    private int qtdLivros;
    private String dtCompra;
    private Float desconto;

    public RelatorioAnalitico() {
    }

    public RelatorioAnalitico(int id, int codCliente, int codVenda, int qtdLivros, String dtCompra, Float desconto) {
        this.id = id;
        this.codCliente = codCliente;
        this.codVenda = codVenda;
        this.qtdLivros = qtdLivros;
        this.dtCompra = dtCompra;
        this.desconto = desconto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getQtdLivros() {
        return qtdLivros;
    }

    public void setQtdLivros(int qtdLivros) {
        this.qtdLivros = qtdLivros;
    }

    public String getDtCompra() {
        return dtCompra;
    }

    public void setDtCompra(String dtCompra) {
        this.dtCompra = dtCompra;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }
    
    
   
    
    
}
