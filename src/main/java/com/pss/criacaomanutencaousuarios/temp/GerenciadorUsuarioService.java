package temp;

import com.pss.criacaomanutencaousuarios.model.Usuario;

public class GerenciadorUsuarioService {
    private Usuario usuarioLogado;
        
    public GerenciadorUsuarioService(Usuario usuario){
        this.usuarioLogado = usuario;
    }
    
    public void promoverUsuario(Usuario usuario){
        if (usuario == null) throw new RuntimeException("Usuário a ser promovido não existe!");
        if (usuario.getTipo().podeSerPromovido() && usuarioLogado.getTipo().podeAlterarUsuario()) usuario.setTipo(TipoDeUsuarioEnum.administrador);
        else throw new RuntimeException("O usuário "+usuario.getNome()+" não pode ser promovido ou credencial inválida.");
    }
    
    public void rebaixarUsuario(Usuario usuario){
        if (usuario == null) throw new RuntimeException("Usuário a ser rebaixado não existe!");
        if (usuario.getTipo().podeSerRebaixado() && usuarioLogado.getTipo().podeAlterarUsuario()) usuario.setTipo(TipoDeUsuarioEnum.usuarioComum);
        else throw new RuntimeException("O usuário "+usuario.getNome()+" não pode ser rebaixado ou credencial inválida.");   
    }
    
    public void excluirUsuario(Usuario usuario){
        if (usuario == null) throw new RuntimeException("Usuário não existe!");
        if (usuarioLogado.getTipo().podeExcluirUsuario()) usuario.setAtivo(false);
    }
}
