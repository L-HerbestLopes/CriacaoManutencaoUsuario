package com.css.criacaomanutencaousuarios.service;

import com.pss.criacaomanutencaousuarios.model.Notificacao;
import com.pss.criacaomanutencaousuarios.repository.NotificacaoRepository;
import com.pss.criacaomanutencaousuarios.model.NotificacaoUsuario;
import com.pss.criacaomanutencaousuarios.repository.NotificacaoUsuarioRepository;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.repository.UsuarioRepository;
import java.util.ArrayList;
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
            // NotificacaoUsuarioService vai se comunicar com NotifiacaoUsuarioRepository no futuro
            // notificacoesUsuario.incluirNotificacaoUsuario(notificacaoUsuario);
            
            // por enquanto, print para debug:
            System.out.println(
                    "Notificação enviada para " + notificacaoUsuario.getUsuario().getNome() + ": \"" +
                    notificacaoUsuario.getNotificacao().getMessage() + "\""
            );
        }
    }
    
    public List<NotificacaoUsuario> getNotificacoes(Usuario usuario, NotificacaoUsuarioRepository repository) {
        List<NotificacaoUsuario> notificacoesSaida = new ArrayList<>();
        
        for(NotificacaoUsuario notificacao : repository.getAll()) {
            if(notificacao.getUsuario().equals(usuario)) {
                notificacoesSaida.add(notificacao);
            }
        }
        
        return notificacoesSaida;
    }
}
