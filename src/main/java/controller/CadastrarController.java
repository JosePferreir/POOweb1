package controller;

import dao.UsuarioDAO;
import model.Permissao;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("cadastrar")
public class CadastrarController extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String idade = req.getParameter("idade");
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Usuario u = new Usuario();

        u.setNome(nome);
        u.setIdade(Integer.parseInt(idade));
        u.setCpf(cpf);
        u.setEmail(email);
        u.setSenha(senha);

        Permissao p = new Permissao(2,"CLIENTE");
        u.setPermissao(p);

        new UsuarioDAO().cadastrarUsuario(u);

        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }
}
