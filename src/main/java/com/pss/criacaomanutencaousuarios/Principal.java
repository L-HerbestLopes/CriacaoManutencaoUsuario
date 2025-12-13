package com.pss.criacaomanutencaousuarios;

import com.pss.criacaomanutencaousuarios.database.DatabaseConnection;
import com.pss.criacaomanutencaousuarios.database.NotificacaoTable;
import com.pss.criacaomanutencaousuarios.database.UsuarioTable;
import com.pss.criacaomanutencaousuarios.database.NotificacaoUsuarioTable;
import com.pss.criacaomanutencaousuarios.database.DatabaseInitializer;
import com.pss.criacaomanutencaousuarios.database.TabelaDatabase;
import com.pss.criacaomanutencaousuarios.database.TableInfo;
import com.pss.criacaomanutencaousuarios.model.NotificacaoUsuario;
import com.pss.criacaomanutencaousuarios.model.NotificacaoUsuarioRepository;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.model.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.presenter.EnvioNotificacaoPresenter;
import com.pss.criacaomanutencaousuarios.presenter.CadastroUsuarioPresenter;
import com.pss.criacaomanutencaousuarios.presenter.NotificacaoUsuarioService;
import com.pss.criacaomanutencaousuarios.presenter.SistemaPresenter;
import com.pss.criacaomanutencaousuarios.model.TipoDeUsuarioEnum;
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
        List<TabelaDatabase> tabelas = new ArrayList<>();
        tabelas.add(new UsuarioTable());
        tabelas.add(new NotificacaoTable());
        tabelas.add(new NotificacaoUsuarioTable());
        DatabaseInitializer databaseInitializer = new DatabaseInitializer(tabelas);
        databaseInitializer.inicializar();
        
        TableInfo.listTables(DatabaseConnection.connect());
        
        //SistemaPresenter sistema = SistemaPresenter.getInstancia();
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<NotificacaoUsuario> notificacoes = new ArrayList<>();
        UsuarioRepository repository = new UsuarioRepository(usuarios);
        //sistema.setUsuarioRepository(repository);
        //sistema.setNotificacaoUsuarioRepository(new NotificacaoUsuarioRepository(notificacoes));
        
//        repository.incluirUsuario(new Usuario(
//                "Marcos", "marcos123", TipoDeUsuarioEnum.usuarioComum, LocalDate.now()
//                        ));
//        repository.incluirUsuario(new Usuario(
//                "Júlia", "senhajulia", TipoDeUsuarioEnum.administrador, LocalDate.now()
//                        ));
//        repository.incluirUsuario(new Usuario(
//                "Guilherme", "silva2003", TipoDeUsuarioEnum.usuarioComum, LocalDate.now()
//                        ));
        
        //sistema.setUsuario(repository.buscarUsuario("Júlia"));
        //sistema.recarregarView();
        
        new CadastroUsuarioPresenter(repository);
    }
    
}



