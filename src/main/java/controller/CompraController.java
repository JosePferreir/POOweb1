package controller;

import dao.CompraDAO;
import dao.RoupaDAO;
import model.Compra;
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

@WebServlet("compra")
public class CompraController extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        String op = req.getParameter("op");

        HttpSession session = req.getSession();
        Compra carrinho = (Compra) session.getAttribute("carrinho");
        Usuario user = (Usuario) session.getAttribute("user");

        if(user == null){
            dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        }else{
            System.out.println("\n\n");
            System.out.println(user.getPermissao().getNome());
            System.out.println(user.getNome());
        }

        if(op.equals("AdicionarItem")){
            boolean jaTem = false;
            String id = req.getParameter("id");

            System.out.println(jaTem);
            for(int i = 0; i < carrinho.getRoupas().size(); i++){
                System.out.println(carrinho.getRoupas().get(i).getId());
                if(carrinho.getRoupas().get(i).getId() == parseInt(id)){
                    carrinho.getRoupas().get(i).setQuantidade(1);
                    System.out.println(carrinho.getRoupas().get(i).getQuantidade());
                    carrinho.setTotalCompra(carrinho.getRoupas().get(i).getPreco());
                    jaTem = true;
                }
            }
            if(jaTem == false){
                Roupa r = new RoupaDAO().getRoupa(parseInt(id));
                carrinho.setRoupas(r);
                System.out.println("aaa");
            }
            System.out.println(jaTem);

            req.setAttribute("roupas",new RoupaDAO().getAllRoupas());
            dispatcher = req.getRequestDispatcher("/WEB-INF/principal.jsp");
            dispatcher.forward(req, resp);
        }else if(op.equals("VerCarrinho")){

            req.setAttribute("carrinho",carrinho);
            dispatcher = req.getRequestDispatcher("/WEB-INF/verCarrinho.jsp");
            dispatcher.forward(req, resp);

        }else if(op.equals("VerCatalogo")) {
            req.setAttribute("roupas",new RoupaDAO().getAllRoupas());
            dispatcher = req.getRequestDispatcher("/WEB-INF/principal.jsp");
            dispatcher.forward(req, resp);
        }else if(op.equals("FinalizarCompra")){
            System.out.println(carrinho.getId());
            //new CompraDAO().cadastrarCompra(carrinho,user);
            req.setAttribute("roupas",new RoupaDAO().getAllRoupas());
            dispatcher = req.getRequestDispatcher("/WEB-INF/principal.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
