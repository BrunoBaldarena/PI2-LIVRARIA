/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.utils;

import javax.swing.JOptionPane;

/**
 *
 * @author victorsantos
 */
public class Conversores {
    public static String convertDate(String data){
        data = data.replaceAll("/","").replaceAll(" ", "");
        
        String dia = data.substring(0,2);
        String mes = data.substring(2,4);
        String ano = data.substring(4,8);
        
        
        String dataConvertida = ano + "-" + mes + "-" + dia;
            
        return dataConvertida;
    }
}
