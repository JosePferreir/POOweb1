package controller;

import dao.UsuarioDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class LoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("acertei porra");

        req.setAttribute("clientes", new UsuarioDAO().getAllUsuarios());
        RequestDispatcher rd = req.getRequestDispatcher("/clientes.jsp");
        rd.forward(req, resp);
    }
}
