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
public class Cliente {
    
    private int cod; 
    private String nome;
    private String cpf; 
    private String sexo;
    private String dataNascimento;
    private String telefone; 
    private String logadoutro; 
    private String cep; 
    private String cidade;
    private String bairro;
    private String uf;
    private String complemento;

    public Cliente(int cod, String nome, String cpf, String sexo, String dataNascimento, String telefone, String logadoutro, String cep, String cidade, String bairro, String uf, String complemento) {
        this.cod = cod;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.logadoutro = logadoutro;
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.uf = uf;
        this.complemento = complemento;
    }

    public Cliente() {
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogadoutro() {
        return logadoutro;
    }

    public void setLogadoutro(String logadoutro) {
        this.logadoutro = logadoutro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
    
    
    
     
    
   
    
    
    
}
