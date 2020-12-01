/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.helper;
import br.senac.sp.tads.ads.pi2.modal.RelatorioSintetico;
import br.senac.sp.tads.ads.pi2.utils.Conversores;
import br.senac.tads.ads.pi2.view.telaRelatorio;

/**
 *
 * @author baldarena
 */
public class RelatorioSinteticoHelper {
    
    private final telaRelatorio view;

    public RelatorioSinteticoHelper(telaRelatorio view) {
        this.view = view;
    }
    
    
     public RelatorioSintetico obterModelo(){
         
        RelatorioSintetico rls = new RelatorioSintetico();
         String txtIni = view.getTxtDataInicial().getText();
         String txtFin = view.getTxtDataFinal().getText();
         
   
         if(!txtIni.equals("  /  /    ")){
             String dtIni = Conversores.convertDate(txtIni);
             rls.setDtInicio(dtIni);
         }
         
         if(!txtFin.equals("  /  /    ")){
             String dtFin = Conversores.convertDate(txtFin);
             rls.setDtFinal(dtFin); 
         }
         
        return rls;
        
     }
     
     public void limparTela(){
        view.getTxtDataInicial().setText("");
        view.getTxtDataFinal().setText("");
       
    }
        
    
}
