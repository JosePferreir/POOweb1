package controller;

import dao.UsuarioDAO;
import model.Usuario;
import service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("login")
public class LoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        RequestDispatcher dispatcher;

        Usuario u = new LoginService().autenticar(email,senha);

        if(u != null){
            System.out.println(u.getPermissao().getNome());
            if(u.getPermissao().getNome().equals("CLIENTE")){
                dispatcher = req.getRequestDispatcher("/WEB-INF/principal.jsp");
                dispatcher.forward(req, resp);
            } else if (u.getPermissao().getNome().equals("ADMIN")) {
                dispatcher = req.getRequestDispatcher("/WEB-INF/principalAdmin.jsp");
                dispatcher.forward(req, resp);
                //resp.sendRedirect("/WEB-INF/principalAdmin.jsp");
            }
        }else{
            dispatcher = req.getRequestDispatcher("/login.jsp");
            dispatcher.forward(req, resp);
        }


    }
}
