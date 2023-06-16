package controller;

import dao.RoupaDAO;
import dao.UsuarioDAO;
import model.Roupa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("roupas")
public class RoupasController extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String op = req.getParameter("op");

        /*
        req.setAttribute("clientes", new UsuarioDAO().getAllUsuarios());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/verRoupas.jsp");
        dispatcher.forward(req, resp);

         */
        if(op.equals("VerRoupas")){

            //req.setAttribute("clientes", new UsuarioDAO().getAllUsuarios());
            req.setAttribute("roupas",new RoupaDAO().getAllRoupas());
            RequestDispatcher dispatcher;
            dispatcher = req.getRequestDispatcher("/WEB-INF/verRoupasAdmin.jsp");
            dispatcher.forward(req, resp);
        }
        if(op.equals("CadastrarRoupa")){
            String nome = req.getParameter("nome");
            String tamanho = req.getParameter("tamanho");
            String preco = req.getParameter("preco");
            String cor = req.getParameter("cor");
            String descricao = req.getParameter("descricao");



            Roupa r = new Roupa(nome,tamanho,Integer.parseInt(preco),cor,descricao);

            new RoupaDAO().cadastrarRoupa(r);

            RequestDispatcher dispatcher;
            dispatcher = req.getRequestDispatcher("/WEB-INF/principalAdmin.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
