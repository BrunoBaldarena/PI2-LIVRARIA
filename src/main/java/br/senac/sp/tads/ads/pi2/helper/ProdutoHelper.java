/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.helper;

import br.senac.sp.tads.ads.pi2.modal.Produto;
import br.senac.tads.ads.pi2.view.telaProduto;

/**
 *
 * @author diogo.carauta
 */
public class ProdutoHelper {
    
    private final telaProduto view;
    
    public ProdutoHelper(telaProduto view){
        this.view = view;
    }
    
     /** @author diogo.carauta
     * Metodo que é utilizado para capturar os dados da view para um objeto
     * @return Produto
     */   
    public Produto obterModelo(){
        int codigo = 0;
        String codProduto = view.getTxtCodProduto().getText();
        String nome = view.getTxtNome().getText();
        String autor = view.getTxtAutor().getText();
        String editora = view.getTxtEditora().getText();
        String ano = view.getTxtAno().getText();
        String qtd = view.getTxtQtd().getText();
        String preco = view.getTxtPreco().getText();
        String obs = view.getTxtObeservacao().getText();
        String tipo = view.getCbxTipo().getSelectedItem().toString();
        String categoria = view.getCbxCategoria().getSelectedItem().toString();

        if(codProduto.length() >0){
            codigo = Integer.parseInt(codProduto);
        }
        
        Produto modelo = new Produto();
        modelo.setId(codigo);
        modelo.setNome(nome);
        modelo.setAutor(autor);
        modelo.setEditora(editora);
        modelo.setAno(Integer.parseInt(ano)); 
        modelo.setQuantidade(Integer.parseInt(qtd));
        modelo.setPreco(Double.parseDouble(preco.replaceAll(",", ".")));
        modelo.setObservacao(obs);
        modelo.setCategoria(categoria);
        modelo.setTipo(tipo);    
        
        
        
        return modelo;
    }
    
     /** @author diogo.carauta
     * Metodo que é utilizado para definir os dados da de um objeti na view
     */   
    public void setarModelo(Produto modelo){
        view.getTxtCodProduto().setText(Integer.toString(modelo.getId()));
        view.getTxtNome().setText(modelo.getNome());
        view.getTxtAutor().setText(modelo.getAutor());
        view.getTxtEditora().setText(modelo.getEditora());
        view.getTxtAno().setText(Integer.toString(modelo.getAno()));
        view.getTxtQtd().setText(Integer.toString(modelo.getQuantidade()));
        view.getTxtPreco().setText(Double.toString(modelo.getPreco()).replace(".",","));
        view.getTxtObeservacao().setText(modelo.getObservacao());
        view.getCbxCategoria().setSelectedItem(modelo.getCategoria());
        view.getCbxTipo().setSelectedItem(modelo.getTipo());
       
    }
    
    
     /** @author baldarena
     * Metodo que é utilizado para limpar os campos da view
     */ 
    public void limparTela(){
        view.getTxtCodProduto().setText("");
        view.getTxtNome().setText("");
        view.getTxtAutor().setText("");
        view.getTxtEditora().setText("");
        view.getTxtAno().setText("");
        view.getTxtQtd().setText("");
        view.getTxtPreco().setText("");
        view.getTxtObeservacao().setText("");
        view.getCbxTipo().setSelectedIndex(0);
        view.getCbxCategoria().setSelectedIndex(0);
    }
        
}
