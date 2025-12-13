package com.pss.criacaomanutencaousuarios.app;

import com.pss.criacaomanutencaousuarios.database.DatabaseConnection;
import com.pss.criacaomanutencaousuarios.database.NotificacaoTable;
import com.pss.criacaomanutencaousuarios.database.UsuarioTable;
import com.pss.criacaomanutencaousuarios.database.NotificacaoUsuarioTable;
import com.pss.criacaomanutencaousuarios.database.DatabaseInitializer;
import com.pss.criacaomanutencaousuarios.database.TabelaDatabase;
import com.pss.criacaomanutencaousuarios.database.TableInfo;
import com.pss.criacaomanutencaousuarios.model.NotificacaoUsuario;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.presenter.EnvioNotificacaoPresenter;
import com.pss.criacaomanutencaousuarios.presenter.CadastroUsuarioPresenter;
import com.css.criacaomanutencaousuarios.service.NotificacaoUsuarioService;
import com.pss.criacaomanutencaousuarios.presenter.SistemaPresenter;
import com.pss.criacaomanutencaousuarios.model.TipoDeUsuarioEnum;
import com.pss.criacaomanutencaousuarios.repository.NotificacaoUsuarioRepository;
import com.pss.criacaomanutencaousuarios.repository.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.view.CadastroUsuarioView;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class Principal {

    public static void main(String[] args) {
        
//        List<TabelaDatabase> tabelas = 
          new DatabaseInitializer();
//        databaseInitializer.inicializar();
//        TableInfo.listTables(DatabaseConnection.connect());
        
      
            SistemaPresenter sistema = SistemaPresenter.getInstancia();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<NotificacaoUsuario> notificacoes = new ArrayList<>();
        UsuarioRepository repository = new UsuarioRepository();
            sistema.setUsuarioRepository(repository);
            sistema.setNotificacaoUsuarioRepository(new NotificacaoUsuarioRepository(notificacoes));

//UNICAS COISAS QUE TEM Q TER NA MAIN   
        
        new CadastroUsuarioPresenter(repository);
    }
    
}



