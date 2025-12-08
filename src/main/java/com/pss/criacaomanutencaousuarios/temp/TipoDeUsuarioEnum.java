package com.pss.criacaomanutencaousuarios.temp;

public enum TipoDeUsuarioEnum {
    
    usuarioComum{
        @Override
        public boolean podeSerPromovido(){
            return true;
        }
        @Override
        public boolean podeSerRebaixado(){
            return false;
        }
        @Override
        public boolean podeAlterarUsuario(){
            return false;
        }
        @Override
        public boolean podeExcluirUsuario(){
            return false;
        }
        @Override
        public boolean podeEnviarNotificacao(){
            return false;
        }
        @Override
        public boolean podeAutenticarUsuario(){
            return false;
        }
        @Override
        public boolean podeAtualizarUsuario(){
            return false;
        }
    }, 
    administrador{
        @Override
        public boolean podeSerPromovido(){
            return false;
        }
        @Override
        public boolean podeSerRebaixado(){
            return true;
        }
        @Override
        public boolean podeAlterarUsuario(){
            return true;
        }
        @Override
        public boolean podeExcluirUsuario(){
            return false;
        }
        @Override
        public boolean podeEnviarNotificacao(){
            return true;
        }
        @Override
        public boolean podeAutenticarUsuario(){
            return true;
        }
        @Override
        public boolean podeAtualizarUsuario(){
            return true;
        }
    }, 
    administradorPrincipal{
        @Override
        public boolean podeSerPromovido(){
            return false;
        }
        @Override
        public boolean podeSerRebaixado(){
            return false;
        }
        @Override
        public boolean podeAlterarUsuario(){
            return true;
        }
        @Override
        public boolean podeExcluirUsuario(){
            return true;
        }
        @Override
        public boolean podeEnviarNotificacao(){
            return true;
        }
        @Override
        public boolean podeAutenticarUsuario(){
            return true;
        }
        @Override
        public boolean podeAtualizarUsuario(){
            return true;
        }
    };
    
    public abstract boolean podeSerPromovido();
    public abstract boolean podeSerRebaixado();
    public abstract boolean podeAlterarUsuario();
    public abstract boolean podeExcluirUsuario();
    public abstract boolean podeEnviarNotificacao();
    public abstract boolean podeAutenticarUsuario();
    public abstract boolean podeAtualizarUsuario();
}
