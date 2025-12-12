package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.model.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.view.CadastroUsuarioView;
import com.pss.criacaomanutencaousuarios.view.ICadastroUsuarioView;
import com.pss.criacaomanutencaousuarios.view.ILoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPresenter {
    private ILoginView view;
    private UsuarioRepository usuario;
    
    public LoginPresenter(ILoginView view, UsuarioRepository usuario){
        this.view = view;
        this.usuario = usuario;
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
        ICadastroUsuarioView cadastro = new CadastroUsuarioView();
        new CadastroUsuarioPresenter(cadastro, this.usuario);
    }
    
    private void confirmar() {
        try{
        //buscar usuario no banco
        //usuarioRepository.buscar(usuario);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        view.setVisible(false);
    }
}
