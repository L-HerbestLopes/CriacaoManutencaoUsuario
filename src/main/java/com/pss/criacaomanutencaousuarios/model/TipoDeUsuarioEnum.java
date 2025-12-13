package com.pss.criacaomanutencaousuarios.model;

public enum TipoDeUsuarioEnum {
   naoConfirmado(-1),usuarioComum(0), administrador(1), administradorPrincipal(2), excluido(3);
   
   private final int codigo;

    TipoDeUsuarioEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
