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
public class RelatorioSintetico {
    
    private int id;
    private int qtdVendas;
    private int qtdLivrosPeriodo;
    private int qtdLivros;
    private float valorVendaPeriodo;
    private String dtInicio;
    private String dtFinal;
    private String dtCompra;
    private int codCliente; 
    private int codCaixa;
    private int codVenda; 

    public RelatorioSintetico() {
    }

    public RelatorioSintetico(int id, int qtdVendas, int qtdLivrosPeriodo, int qtdLivros, float valorVendaPeriodo, String dtInicio, String dtFinal, String dtCompra, int codCliente, int codCaixa, int codVenda) {
        this.id = id;
        this.qtdVendas = qtdVendas;
        this.qtdLivrosPeriodo = qtdLivrosPeriodo;
        this.qtdLivros = qtdLivros;
        this.valorVendaPeriodo = valorVendaPeriodo;
        this.dtInicio = dtInicio;
        this.dtFinal = dtFinal;
        this.dtCompra = dtCompra;
        this.codCliente = codCliente;
        this.codCaixa = codCaixa;
        this.codVenda = codVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtdVendas() {
        return qtdVendas;
    }

    public void setQtdVendas(int qtdVendas) {
        this.qtdVendas = qtdVendas;
    }

    public int getQtdLivrosPeriodo() {
        return qtdLivrosPeriodo;
    }

    public void setQtdLivrosPeriodo(int qtdLivrosPeriodo) {
        this.qtdLivrosPeriodo = qtdLivrosPeriodo;
    }

    public int getQtdLivros() {
        return qtdLivros;
    }

    public void setQtdLivros(int qtdLivros) {
        this.qtdLivros = qtdLivros;
    }

    public float getValorVendaPeriodo() {
        return valorVendaPeriodo;
    }

    public void setValorVendaPeriodo(float valorVendaPeriodo) {
        this.valorVendaPeriodo = valorVendaPeriodo;
    }

    public String getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }

    public String getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(String dtFinal) {
        this.dtFinal = dtFinal;
    }

    public String getDtCompra() {
        return dtCompra;
    }

    public void setDtCompra(String dtCompra) {
        this.dtCompra = dtCompra;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodCaixa() {
        return codCaixa;
    }

    public void setCodCaixa(int codCaixa) {
        this.codCaixa = codCaixa;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }
    
    
}
