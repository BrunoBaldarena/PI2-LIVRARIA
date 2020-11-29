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
public class Caixa {
    
    private int codigoVenda;
    private String dataVenda;
    private double valorTotal;
    private int IdCliente;
    private int idCaixa;
    private int quantidade;
    private String tipoPagamento; 

    public Caixa() {
    }

    public Caixa(int codigoVenda, String dataVenda, double valorTotal, int IdCliente, int idCaixa, int quantidade, String tipoPagamento) {
        this.codigoVenda = codigoVenda;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.IdCliente = IdCliente;
        this.idCaixa = idCaixa;
        this.quantidade = quantidade;
        this.tipoPagamento = tipoPagamento;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }


    
    
    
    
}
