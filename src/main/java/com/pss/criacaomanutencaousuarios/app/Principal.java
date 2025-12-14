package com.pss.criacaomanutencaousuarios.app;

import com.pss.criacaomanutencaousuarios.database.DatabaseInitializer;
import com.pss.criacaomanutencaousuarios.model.NotificacaoUsuario;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.presenter.CadastroUsuarioPresenter;
import com.pss.criacaomanutencaousuarios.presenter.SistemaPresenter;
import com.pss.criacaomanutencaousuarios.repository.NotificacaoUsuarioRepository;
import com.pss.criacaomanutencaousuarios.repository.UsuarioRepository;
import java.util.ArrayList;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class Principal {

    public static void main(String[] args) {
          new DatabaseInitializer();
      
        SistemaPresenter sistema = SistemaPresenter.getInstancia();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<NotificacaoUsuario> notificacoes = new ArrayList<>();
        UsuarioRepository repository = new UsuarioRepository();
        sistema.setUsuarioRepository(repository);
        sistema.setNotificacaoUsuarioRepository(new NotificacaoUsuarioRepository(notificacoes));
 
        
        new CadastroUsuarioPresenter(repository);
    }
    
}



