
package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.model.TipoDeUsuarioEnum;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.model.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.view.CadastroUsuarioView;
import com.pss.senha.validacao.ValidadorSenha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */

public class CadastroUsuarioPresenter {
    private CadastroUsuarioView view;
    private UsuarioRepository repository;
    
    public CadastroUsuarioPresenter(UsuarioRepository repository) {
        this.view = new CadastroUsuarioView();
        this.repository = repository;
        configuraView();
    }
    public CadastroUsuarioPresenter() {
        this.view = new CadastroUsuarioView();
        configuraView();
    }
    
    public CadastroUsuarioView getView() {
        return view;
    }
    
    private void configuraView() {
        view.addAcaoLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cancelar();
                } catch(Exception ex) {
                    ex.printStackTrace();
                    // lidar e registrar erro aqui...
                }
            }
        });
        
        view.addAcaoCadastrar(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    confirmar();
                } catch(Exception ex) {
                    ex.printStackTrace();
                    // lidar e registrar erro aqui...
                }
            }
        });
        
        view.setVisible(true);
    }
    
    private void cancelar() {
        view.limparCampos();
        view.setVisible(false);
        new LoginPresenter();
    }
    
    private void confirmar() {
        
        ValidadorSenha validador = new ValidadorSenha();
        List<String> resultado = validador.validar(view.getTxtSenha());
        
        // falha caso validar retorne alguma string indicando erro
        if(!resultado.isEmpty()) {
            
            System.err.println(resultado.get(0));
            JOptionPane.showMessageDialog(null,resultado.get(0), "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(/*view.getTxtNome() == "" || */view.getTxtNome().length() < 2){
            System.err.println("Nome invalido!");
                JOptionPane.showMessageDialog(null, "Informe um nome válido", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!view.getTxtSenha().equals(view.getTxtSenhaConfirmada())) {
            System.err.println("Senhas fornecidas são diferentes!");
                JOptionPane.showMessageDialog(null, "As senhas fornecidas são diferentes", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(view.getTxtNome().equals(repository.buscarUsuario(view.getTxtNome()))){
            System.err.println("Já existe usuario com esse nome!");
                JOptionPane.showMessageDialog(null, "Já existe usuario com esse nome, informe um nome diferente!", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(repository.listaVazia()){
            Usuario usuario = new Usuario(view.getTxtNome(), view.getTxtSenha(), TipoDeUsuarioEnum.administradorPrincipal, LocalDate.now());
            repository.incluirUsuario(usuario);
            JOptionPane.showMessageDialog(null, "Administrador criado com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Usuario usuario = new Usuario(view.getTxtNome(), view.getTxtSenha(), TipoDeUsuarioEnum.naoConfirmado, LocalDate.now());
            repository.incluirUsuario(usuario);
            JOptionPane.showMessageDialog(null, "Usuário criado com sucesso! Aguardando confirmação", "", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
            
        //MOSTRAR adicionado com sucedo (alert) joptionpane
        // view.getTxtSenha(); e view.getTxtSenhaConfirmada();
    
        // 2. Criar o Usuário (Model)
        //repository.incluirUsuario(new Usuario(view.getName(), view.getTxtSenha(), LocalDate.now()));
        //repository.cadastrar()

        //usuarioRepository.cadastrar(novoUsuario);
        //JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!", "Criado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
        //System.out.println("Validação do usuário '" + view.getName() + "'solicitado, aguardando confirmação"); 
        view.setVisible(false);
        new SistemaPresenter();
        //view.carregarView();
    }

}
