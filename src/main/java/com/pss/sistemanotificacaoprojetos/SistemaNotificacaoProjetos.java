package com.pss.sistemanotificacaoprojetos;

import com.pss.sistemanotificacaoprojetos.model.Usuario;
import com.pss.sistemanotificacaoprojetos.model.UsuarioRepository;
import com.pss.sistemanotificacaoprojetos.presenter.FormularioUsuarioPresenter;
import com.pss.sistemanotificacaoprojetos.presenter.SistemaPresenter;
import java.util.ArrayList;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class SistemaNotificacaoProjetos {

    public static void main(String[] args) {
        SistemaPresenter sistema = SistemaPresenter.getInstancia();
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        UsuarioRepository repository = new UsuarioRepository(usuarios);
        sistema.setRepository(repository);
        
        FormularioUsuarioPresenter formulario = new FormularioUsuarioPresenter("Editar usuário");
        sistema.abrirJanela(formulario);
    }
}
