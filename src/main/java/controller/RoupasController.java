package controller;

import dao.RoupaDAO;
import dao.UsuarioDAO;
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

@WebServlet("roupas")
public class RoupasController extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String op = req.getParameter("op");
        System.out.println(op);

        HttpSession session = req.getSession();
        Usuario u = (Usuario) session.getAttribute("user");
        ArrayList<Roupa> carrinho = (ArrayList<Roupa>) session.getAttribute("carrinho");


        if(u == null){
            RequestDispatcher dispatcher;
            dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        }else{
            System.out.println("\n\n");
            System.out.println(u.getPermissao().getNome());
            System.out.println(u.getNome());
            System.out.println("oi"+carrinho);
            System.out.println("\n\n");
        }

        if(op.equals("VerRoupas")){

            req.setAttribute("roupas",new RoupaDAO().getAllRoupas());
            RequestDispatcher dispatcher;
            dispatcher = req.getRequestDispatcher("/WEB-INF/verRoupasAdmin.jsp");
            dispatcher.forward(req, resp);
        }
        if(op.equals("CadastrarRoupa")){
            System.out.println(u.getNome());
            String nome = req.getParameter("nome");
            String tamanho = req.getParameter("tamanho");
            String preco = req.getParameter("preco");
            String cor = req.getParameter("cor");
            String descricao = req.getParameter("descricao");



            Roupa r = new Roupa(nome,tamanho, parseInt(preco),cor,descricao);

            new RoupaDAO().cadastrarRoupa(r);

            RequestDispatcher dispatcher;
            dispatcher = req.getRequestDispatcher("/WEB-INF/principalAdmin.jsp");
            dispatcher.forward(req, resp);
        }
        else if(op.equals("Excluir")){
            String id = req.getParameter("id");
            new RoupaDAO().excluirRoupa(parseInt(id));

            req.setAttribute("roupas",new RoupaDAO().getAllRoupas());
            RequestDispatcher dispatcher;
            dispatcher = req.getRequestDispatcher("/WEB-INF/verRoupasAdmin.jsp");
            dispatcher.forward(req, resp);

        }else if(op.equals("Editar")){
            String id = req.getParameter("id");

            req.setAttribute("roupaEditar",new RoupaDAO().getRoupa(parseInt(id)));

            RequestDispatcher dispatcher;
            dispatcher = req.getRequestDispatcher("/WEB-INF/editarRoupa.jsp");
            dispatcher.forward(req, resp);
        }else if(op.equals("confirmarEditar")){
            String id = req.getParameter("id");
            String nome = req.getParameter("nome");
            String tamanho = req.getParameter("tamanho");
            String preco = req.getParameter("preco");
            String cor = req.getParameter("cor");
            String descricao = req.getParameter("descricao");

            Roupa r = new Roupa(nome,tamanho, parseInt(preco),cor,descricao);
            r.setId(parseInt(id));
            new RoupaDAO().editarRoupa(r);

            req.setAttribute("roupas",new RoupaDAO().getAllRoupas());
            RequestDispatcher dispatcher;
            dispatcher = req.getRequestDispatcher("/WEB-INF/verRoupasAdmin.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
