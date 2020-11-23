package br.senac.sp.tads.ads.pi2.utils;

import br.senac.sp.tads.ads.pi2.modal.Usuario;

/**
 *
 * @author baldarena
 */
public class Sessao{
    
   private static Sessao instance = null;
   private Usuario usuario;

   private Sessao(){
   }

   public void setUsuario(Usuario usuario){
      this.usuario = usuario;
   }

   public Usuario getUsuario(){
       return usuario;
   }
   
   public static Sessao getInstance(){
         if(instance == null){
               instance = new Sessao();
         }
        return instance;
   }
}