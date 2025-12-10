package com.pss.criacaomanutencaousuarios.temp;

import com.pss.criacaomanutencaousuarios.model.*;

public class GerenciadorUsuarioService {
    private Usuario usuarioLogado;
    private AdministradorDePermissoesHelper permissoesHelper;
        
    public GerenciadorUsuarioService(Usuario usuario){
        this.usuarioLogado = usuario;
        this.permissoesHelper = new AdministradorDePermissoesHelper();
    }
    
    public void promoverUsuario(Usuario usuario){
        if (usuario == null) throw new RuntimeException("Usuário a ser promovido não existe!");
        if (permissoesHelper.podeSerPromovido(usuario) && permissoesHelper.podeAlterarUsuario(usuarioLogado)) usuario.setTipo(TipoDeUsuarioEnum.administrador);
        else throw new RuntimeException("O usuário "+usuario.getNome()+" não pode ser promovido ou credencial inválida.");
    }
    
    public void rebaixarUsuario(Usuario usuario){
        if (usuario == null) throw new RuntimeException("Usuário a ser rebaixado não existe!");
        if (permissoesHelper.podeSerRebaixado(usuario) && permissoesHelper.podeAlterarUsuario(usuarioLogado)) usuario.setTipo(TipoDeUsuarioEnum.usuarioComum);
        else throw new RuntimeException("O usuário "+usuario.getNome()+" não pode ser rebaixado ou credencial inválida.");   
    }
    
    public void excluirUsuario(Usuario usuario){
        if (usuario == null) throw new RuntimeException("Usuário não existe!");
        if (permissoesHelper.podeExcluirUsuario(usuarioLogado)) usuario.setAtivo(false);
    }
}
