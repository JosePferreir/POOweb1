package controller;


import dao.UsuarioDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("clientes")
public class UsuarioController extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("cliente", new UsuarioDAO().getAllUsuarios());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/clientes.jsp");
        dispatcher.forward(req, resp);

    }
}
