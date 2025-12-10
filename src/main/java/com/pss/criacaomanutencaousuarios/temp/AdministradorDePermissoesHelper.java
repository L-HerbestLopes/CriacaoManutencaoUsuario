package com.pss.criacaomanutencaousuarios.temp;

import com.pss.criacaomanutencaousuarios.model.*;



public class AdministradorDePermissoesHelper {
        
        public boolean podeSerPromovido(Usuario usuario){
            return usuario.getTipo().equals(TipoDeUsuarioEnum.usuarioComum);
        }
        
        public boolean podeSerRebaixado(Usuario usuario){
           return usuario.getTipo().equals(TipoDeUsuarioEnum.administrador);
        }
        
        public boolean podeAlterarUsuario(Usuario usuario){
            return !usuario.getTipo().equals(TipoDeUsuarioEnum.usuarioComum);
        }
        
        public boolean podeExcluirUsuario(Usuario usuario){
            return usuario.getTipo().equals(TipoDeUsuarioEnum.administradorPrincipal);
        }
        
        public boolean podeEnviarNotificacao(Usuario usuario){
            return !usuario.getTipo().equals(TipoDeUsuarioEnum.usuarioComum);
        }
        
        public boolean podeAutenticarUsuario(Usuario usuario){
            return usuario.getTipo().equals(TipoDeUsuarioEnum.administradorPrincipal);
        }
        
        public boolean podeAtualizarUsuario(Usuario usuario){
            return !usuario.getTipo().equals(TipoDeUsuarioEnum.usuarioComum);
        }
}
