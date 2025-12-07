package com.pss.sistemanotificacaoprojetos.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class UsuarioRepository {
    private List<Usuario> usuarios;
    
    public UsuarioRepository(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void incluirUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    
    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }
    
    public Usuario acharUsuario(String nome) {
        if(usuarios.isEmpty()) { /* throw exception */ }
        if(usuarios == null) { /* throw exception */ }
        
        for(Usuario usuario : usuarios) {
            if(usuario.getNome().equals(nome)) return usuario;
        }
        
        return null;
    }
}
