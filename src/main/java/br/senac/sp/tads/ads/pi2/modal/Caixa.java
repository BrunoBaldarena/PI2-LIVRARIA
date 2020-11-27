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
    private float valorTotal;
    private int IdCliente;
    private int idCaixa;
    private int quantidade;
    private String tipoPagamento; 
    private float descontoTotal; 

    public Caixa() {
    }

    public Caixa(int codigoVenda, String dataVenda, float valorTotal, int IdCliente, int idCaixa, int quantidade, String tipoPagamento, float descontoTotal) {
        this.codigoVenda = codigoVenda;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.IdCliente = IdCliente;
        this.idCaixa = idCaixa;
        this.quantidade = quantidade;
        this.tipoPagamento = tipoPagamento;
        this.descontoTotal = descontoTotal;
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

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
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

    public float getDescontoTotal() {
        return descontoTotal;
    }

    public void setDescontoTotal(float descontoTotal) {
        this.descontoTotal = descontoTotal;
    }
    
    
    
    
}
