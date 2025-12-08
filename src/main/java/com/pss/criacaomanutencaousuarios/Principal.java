package com.pss.criacaomanutencaousuarios;

import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.model.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.presenter.FormularioUsuarioPresenter;
import com.pss.criacaomanutencaousuarios.presenter.SistemaPresenter;
import java.util.ArrayList;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class Principal {

    public static void main(String[] args) {
        SistemaPresenter sistema = SistemaPresenter.getInstancia();
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        UsuarioRepository repository = new UsuarioRepository(usuarios);
        sistema.setRepository(repository);
        
        FormularioUsuarioPresenter formulario = new FormularioUsuarioPresenter("Editar usuário");
        sistema.abrirJanela(formulario);
    }
}
