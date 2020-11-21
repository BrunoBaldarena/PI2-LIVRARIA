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
 */
public class Criptografar {
    
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
