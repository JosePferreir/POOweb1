package controller;


import dao.RoupaDAO;
import dao.UsuarioDAO;
import model.Permissao;
import model.Roupa;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

@WebServlet("clientes")
public class UsuarioController extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        String userId = req.getParameter("userId");

        HttpSession session = req.getSession();
        Usuario user = (Usuario) session.getAttribute("user");

        if(user == null){
            RequestDispatcher dispatcher;
            dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        }else{
            System.out.println("\n\n");
            System.out.println(user.getPermissao().getNome());
            System.out.println(user.getNome());
        }

        if(op.equals("getAllUsuarios")){
            req.setAttribute("cliente", new UsuarioDAO().getAllUsuarios());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/clientes.jsp");
            dispatcher.forward(req, resp);
        }else if(op.equals("cadastrar")){
            String nome = req.getParameter("nome");
            String idade = req.getParameter("idade");
            String cpf = req.getParameter("cpf");
            String email = req.getParameter("email");
            String senha = req.getParameter("senha");

            Usuario u = new Usuario();

            u.setNome(nome);
            u.setIdade(parseInt(idade));
            u.setCpf(cpf);
            u.setEmail(email);
            u.setSenha(senha);

            Permissao p = new Permissao(2,"CLIENTE");
            u.setPermissao(p);

            new UsuarioDAO().cadastrarUsuario(u);

            RequestDispatcher dispatcher;
            dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        }else if(op.equals("EditarUsuario")){
            String id = req.getParameter("id");

            req.setAttribute("usuarioEditar", new UsuarioDAO().getUsuarioById(parseInt(id)));

            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/editarUsuario.jsp");
            dispatcher.forward(req, resp);
        }else if(op.equals("confirmarEditar")){
            String id = req.getParameter("id");
            String nome = req.getParameter("nome");
            String idade = req.getParameter("idade");
            String cpf = req.getParameter("cpf");
            String email = req.getParameter("email");
            String senha = req.getParameter("senha");

            Usuario u = new Usuario();

            u.setId(parseInt(id));
            u.setNome(nome);
            u.setIdade(parseInt(idade));
            u.setCpf(cpf);
            u.setEmail(email);
            u.setSenha(senha);

            new UsuarioDAO().editarUsuario(u);
            System.out.println(user.getPermissao().getNome());
            if(user.getPermissao().getNome().equals("CLIENTE")){
                session.setAttribute("user",new UsuarioDAO().getUsuarioById(u.getId()));
                req.setAttribute("roupas",new RoupaDAO().getAllRoupas());
                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/principal.jsp");
                dispatcher.forward(req, resp);
            }else{
                req.setAttribute("cliente", new UsuarioDAO().getAllUsuarios());
                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/clientes.jsp");
                dispatcher.forward(req, resp);
            }

        }else if(op.equals("ExcluirUsuario")){
            String id = req.getParameter("id");
            new UsuarioDAO().excluirUsuario(parseInt(id));

            req.setAttribute("cliente", new UsuarioDAO().getAllUsuarios());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/clientes.jsp");
            dispatcher.forward(req, resp);
        }else if(op.equals("EditarPerfil")){
            //req.setAttribute("usuarioEditar", user);
            System.out.println(user.getEndereco());
            req.setAttribute("usuario", user);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/EditarPerfil.jsp");
            dispatcher.forward(req, resp);
        }


    }
}
