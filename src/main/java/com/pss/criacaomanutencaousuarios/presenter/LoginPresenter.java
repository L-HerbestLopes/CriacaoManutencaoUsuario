package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.model.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.view.CadastroUsuarioView;
import com.pss.criacaomanutencaousuarios.view.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPresenter {
    private LoginView view;
    private UsuarioRepository repository;
    
    public LoginPresenter(UsuarioRepository repository){
        this.view = new LoginView();
        this.repository = repository;
        configuraView();
        
    }
    
    private void configuraView(){
        view.acaoCadastrar(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    cancelar();
                }
                catch(Exception ex){ex.printStackTrace();}
            }
        });
        
        view.acaoLogin(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            try{
                confirmar();
            }
            catch(Exception ex){ex.printStackTrace();}
            }
        });
        view.setVisible(true);
        
        }
    private void cancelar() {
        view.setVisible(false);
        new CadastroUsuarioPresenter(repository);
    }
    
    private void confirmar() {
        try{
            //TO DO
        //buscar usuario no banco -> usuarioRepository.buscar(usuario);
        //mostrar o sistema  SistemaPresenter sistema = SistemaPresenter.getInstancia();
        //criar algo q identifique quem esta logado ssingleton chamada secao
        
        
            String nome = view.getNome();
            String senha = view.getSenha();

            Usuario usuarioEncontrado = repository.buscarUsuario(nome);

            // 2. Valida a senha
            if (usuarioEncontrado != null && usuarioEncontrado.getSenha().equals(senha)) {

                
                SistemaPresenter sistema = SistemaPresenter.getInstancia();
                sistema.setUsuario(usuarioEncontrado);

                view.setVisible(false);

                sistema.carregarView(); 
            
            } else {
                System.out.println("Usuário ou senha incorretos");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}     
