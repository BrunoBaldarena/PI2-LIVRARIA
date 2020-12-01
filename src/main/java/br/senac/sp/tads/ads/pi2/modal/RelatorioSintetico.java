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
    
    
    private String tipoPagamento;
    private int qtdLivros;
    private float valorTotal;
    private String dtInicio;
    private String dtFinal;
    private String dtVenda;
    private int codCliente; 
    private int codUsuario;
    private int codVenda; 

    public RelatorioSintetico() {
    }

    public RelatorioSintetico(String tipoPagamento, int qtdLivros, float valorTotal, String dtInicio, String dtFinal, String dtVenda, int codCliente, int codUsuario, int codVenda) {
        this.tipoPagamento = tipoPagamento;
        this.qtdLivros = qtdLivros;
        this.valorTotal = valorTotal;
        this.dtInicio = dtInicio;
        this.dtFinal = dtFinal;
        this.dtVenda = dtVenda;
        this.codCliente = codCliente;
        this.codUsuario = codUsuario;
        this.codVenda = codVenda;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public int getQtdLivros() {
        return qtdLivros;
    }

    public void setQtdLivros(int qtdLivros) {
        this.qtdLivros = qtdLivros;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
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

    public String getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(String dtVenda) {
        this.dtVenda = dtVenda;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }
    
    
    
}
