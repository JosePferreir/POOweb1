package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("admin")
public class AdminController extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");

        if(op.equals("VerClientes")){
            resp.sendRedirect("clientes");
        }else if(op.equals("CadastrarRoupa")){
            RequestDispatcher dispatcher;
            dispatcher = req.getRequestDispatcher("/WEB-INF/cadastrarRoupa.jsp");
            dispatcher.forward(req, resp);
        }else if(op.equals("Menu")){
            RequestDispatcher dispatcher;
            dispatcher = req.getRequestDispatcher("/WEB-INF/principalAdmin.jsp");
            dispatcher.forward(req, resp);
        }else if(op.equals("Excluir")){
            System.out.println("entrou");
        }

    }
}
