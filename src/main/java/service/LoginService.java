package service;

import dao.UsuarioDAO;
import model.Usuario;

public class LoginService {

    public Usuario autenticar(String email, String senha){
        Usuario u = new UsuarioDAO().getUsuario(email);

        if(u.getPermissao() != null && u.getEmail().equals(email) && u.getSenha().equals(senha)){
            return u;
        }
        return  null;
    }

}
