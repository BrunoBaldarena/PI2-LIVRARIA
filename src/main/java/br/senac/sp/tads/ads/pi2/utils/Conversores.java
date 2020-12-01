/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.utils;


/**
 *
 * @author victorsantos
 */
public class Conversores {
    public static String convertDate(String data){      // Define data para padrao para inclusao no banco de dados
        data = data.replaceAll("/","").replaceAll(" ", "");
        
        String dia = data.substring(0,2);
        String mes = data.substring(2,4);
        String ano = data.substring(4,8);
        
        
        String dataConvertida = ano + "-" + mes + "-" + dia;
            
        return dataConvertida;
    }
    
    public static String convertDateToView(String data){
        data = data.replaceAll("-","");
        
        String dia = data.substring(6,8);
        String mes = data.substring(4,6);
        String ano = data.substring(0,4);
        
        
        String dataConvertida = dia + "/" + mes + "/" + ano;
            
        return dataConvertida;
    }
}

