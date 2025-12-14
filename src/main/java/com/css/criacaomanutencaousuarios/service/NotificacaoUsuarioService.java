package com.css.criacaomanutencaousuarios.service;

import com.pss.criacaomanutencaousuarios.model.Notificacao;
import com.pss.criacaomanutencaousuarios.model.NotificacaoUsuario;
import com.pss.criacaomanutencaousuarios.repository.NotificacaoUsuarioRepository;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class NotificacaoUsuarioService {
    
    public void EnviarNotificacao(List<Usuario> usuarios, Notificacao notificacao, NotificacaoUsuarioRepository notificacoesUsuario) {
        
        for(Usuario usuario : usuarios) {
            NotificacaoUsuario notificacaoUsuario = new NotificacaoUsuario(notificacao, usuario);
            // NotificacaoUsuarioService vai se comunicar com NotifiacaoUsuarioRepository no futuro
            // notificacoesUsuario.incluirNotificacaoUsuario(notificacaoUsuario);
            
            // por enquanto, print para debug:
                            
            System.out.println(
                    "Notificação enviada para " + notificacaoUsuario.getUsuario().getNome() + ": \"" +
                    notificacaoUsuario.getNotificacao().getMessage() + "\""
            );
            
            notificacoesUsuario.incluirNotificacaoUsuario(notificacaoUsuario);
        }
    }
    
    public List<NotificacaoUsuario> getNotificacoes(Usuario usuario, NotificacaoUsuarioRepository repository) {
        List<NotificacaoUsuario> notificacoesSaida = new ArrayList<>();
        
        for(NotificacaoUsuario notificacao : repository.getAll()) {
            System.out.println("notificacao encontrada: " + notificacao.getNotificacao().getMessage() + " para " + notificacao.getUsuario().getNome());
            if(notificacao.getUsuario().getNome().equals(usuario.getNome())) {
                notificacoesSaida.add(notificacao);
            }
        }
        
        return notificacoesSaida;
    }
}
