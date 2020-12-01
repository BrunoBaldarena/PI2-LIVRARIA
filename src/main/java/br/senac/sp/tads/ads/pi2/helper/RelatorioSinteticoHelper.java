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
    
     /** @author baldarena
     * Metodo que é utilizado para capturar os dados da view para um objeto
     * @return RelatorioSintetico
     */   
     public RelatorioSintetico obterModelo(){
         
        RelatorioSintetico rls = new RelatorioSintetico();
         String txtIni = view.getTxtDataInicial().getText();
         String txtFin = view.getTxtDataFinal().getText();
         
   
             String dtIni = Conversores.convertDate(txtIni);
             rls.setDtInicio(dtIni);

         
       
             String dtFin = Conversores.convertDate(txtFin);
             rls.setDtFinal(dtFin);


        return rls;
        
     }
     
     /** @author baldarena
     * Metodo que é utilizado para limpar os campos da view
     */  
     public void limparTela(){
        view.getTxtDataInicial().setText("");
        view.getTxtDataFinal().setText("");
       
    }
        
    
}
