package controller;

import dao.RoupaDAO;
import model.Compra;
import model.Roupa;

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

        if(op.equals("AdicionarItem")){
            /**/
            String id = req.getParameter("id");
            if(carrinho.getRoupas().size() == 0){
                Roupa r = new RoupaDAO().getRoupa(parseInt(id));
                carrinho.setRoupas(r);
            }else{


                Roupa r = new RoupaDAO().getRoupa(parseInt(id));
                carrinho.setRoupas(r);
            }


            req.setAttribute("roupas",new RoupaDAO().getAllRoupas());
            dispatcher = req.getRequestDispatcher("/WEB-INF/principal.jsp");
            dispatcher.forward(req, resp);
        }else if(op.equals("VerCarrinho")){

            req.setAttribute("roupas",carrinho.getRoupas());
            req.setAttribute("total",carrinho.getTotalCompra());
            dispatcher = req.getRequestDispatcher("/WEB-INF/verCarrinho.jsp");
            dispatcher.forward(req, resp);

        }else if(op.equals("VerCatalogo")) {
            req.setAttribute("roupas",new RoupaDAO().getAllRoupas());
            dispatcher = req.getRequestDispatcher("/WEB-INF/principal.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
