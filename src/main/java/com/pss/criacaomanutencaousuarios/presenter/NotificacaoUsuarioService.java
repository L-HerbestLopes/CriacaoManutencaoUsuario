package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.model.Notificacao;
import com.pss.criacaomanutencaousuarios.model.NotificacaoRepository;
import com.pss.criacaomanutencaousuarios.model.NotificacaoUsuario;
import com.pss.criacaomanutencaousuarios.model.NotificacaoUsuarioRepository;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.model.UsuarioRepository;
import java.util.List;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class NotificacaoUsuarioService {
    private UsuarioRepository usuarios;
    private NotificacaoRepository notificacoes;
    private NotificacaoUsuarioRepository notificacoesUsuario;
    
    public NotificacaoUsuarioService() {
        // ...
    }
    
    public void EnviarNotificacao(List<Usuario> usuarios, Notificacao notificacao) {
        
        for(Usuario usuario : usuarios) {
            NotificacaoUsuario notificacaoUsuario = new NotificacaoUsuario(notificacao, usuario);
            notificacoesUsuario.incluirNotificacaoUsuario(notificacaoUsuario);
        }
    }
}
