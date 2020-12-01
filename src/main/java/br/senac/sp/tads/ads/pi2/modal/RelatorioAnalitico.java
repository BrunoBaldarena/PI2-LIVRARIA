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
    private int codVenda;
    private int codProduto;
    private float valorTotalItem;
    private float valorUnitario;
    private int quantidade;
    private String tipoProduto;
    private String nomeProduto;

    public RelatorioAnalitico() {
    }

    public RelatorioAnalitico(int id, int codVenda, int codProduto, float valorTotalItem, float valorUnitario, int quantidade, String tipoProduto, String nomeProduto) {
        this.id = id;
        this.codVenda = codVenda;
        this.codProduto = codProduto;
        this.valorTotalItem = valorTotalItem;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.tipoProduto = tipoProduto;
        this.nomeProduto = nomeProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public float getValorTotalItem() {
        return valorTotalItem;
    }

    public void setValorTotalItem(float valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    

}
