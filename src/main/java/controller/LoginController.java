package controller;

import dao.RoupaDAO;
import dao.UsuarioDAO;
import model.Compra;
import model.Roupa;
import model.Usuario;
import service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("login")
public class LoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String op = req.getParameter("op");
        RequestDispatcher dispatcher;

        if(op.equals("logar")){
            String email = req.getParameter("email");
            String senha = req.getParameter("senha");

            Usuario u = new LoginService().autenticar(email,senha);

            if(u != null){
                if(u.getPermissao().getNome().equals("CLIENTE")){
                    HttpSession session = req.getSession();
                    session.setAttribute("carrinho",new Compra());
                    session.setAttribute("user",u);

                    req.setAttribute("roupas",new RoupaDAO().getAllRoupas());
                    dispatcher = req.getRequestDispatcher("/WEB-INF/principal.jsp");
                    dispatcher.forward(req, resp);
                } else if (u.getPermissao().getNome().equals("ADMIN")) {
                    HttpSession session = req.getSession();
                    session.setAttribute("user",u);

                    dispatcher = req.getRequestDispatcher("/WEB-INF/principalAdmin.jsp");
                    dispatcher.forward(req, resp);
                }
            }else{
                dispatcher = req.getRequestDispatcher("/index.jsp");
                dispatcher.forward(req, resp);
            }
        }else if(op.equals("sair")){
            HttpSession session = req.getSession();
            session.invalidate();
            dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
