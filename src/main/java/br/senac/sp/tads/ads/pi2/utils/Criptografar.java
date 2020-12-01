/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author baldarena
 * Classe usada para declarar os metodos de criptografia utilizados para criptografar os dados necessarios
 */
public class Criptografar {
    
     /**
     * @author baldarena
     * Metodo que recebe a senha cadastrada no usuario e criptografa no padrao MD5
     * @param data senha em String
     * @return senha criptografada
     */
    public static String criptografar(String Senha){
        String retorno=""; 
        MessageDigest md; 
        try {
            md = MessageDigest.getInstance("MD5"); 
            BigInteger hash = new BigInteger(1, md.digest(Senha.getBytes()));
            retorno = hash.toString(16); 
        } catch (Exception e) {
        }return retorno;
    }
}
