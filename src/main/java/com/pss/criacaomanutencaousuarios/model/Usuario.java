package com.pss.criacaomanutencaousuarios.model;

import com.pss.criacaomanutencaousuarios.temp.*;
import java.time.LocalDate;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class Usuario {
    private String nome;
    private String senha;
    private TipoDeUsuarioEnum tipo;
    private LocalDate dataRegistro;
    private boolean ativo;
    
    
    public Usuario(String nome, String senha, TipoDeUsuarioEnum tipo, LocalDate data) {
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
        this.dataRegistro = data;
        this.ativo = false;
    }
    public Usuario(String nome, String senha, LocalDate dataRegistro){
        this.nome = nome;
        this.senha = senha;
        this.tipo = TipoDeUsuarioEnum.naoConfirmado;
        this.dataRegistro = dataRegistro;
        this.ativo = false;
    }
    

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public TipoDeUsuarioEnum getTipo(){
        return tipo;
    }
    public void setTipo(TipoDeUsuarioEnum tipo){
        this.tipo = tipo;
    }
    
    public LocalDate getDataRegistro(){
        return dataRegistro;
    }
    
    public boolean getAtivo(){
        return ativo;
    }
    
    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }
    
}
