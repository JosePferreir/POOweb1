package controller;

import model.Compra;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("endereco")
public class EnderecoController extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String op = req.getParameter("op");


        HttpSession session = req.getSession();
        Compra carrinho = (Compra) session.getAttribute("carrinho");
        Usuario user = (Usuario) session.getAttribute("user");

        if(user == null){
            dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        }

        if(op.equals("AdicionarEndereco")){
            dispatcher = req.getRequestDispatcher("/WEB-INF/AdicionarEndereco.jsp");
            dispatcher.forward(req, resp);
        }
    }

}
