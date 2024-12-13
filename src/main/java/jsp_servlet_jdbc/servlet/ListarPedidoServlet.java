package jsp_servlet_jdbc.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListarPedidoServlet", value = "/ListarPedidoServlet")
public class ListarPedidoServlet extends HttpServlet {

    private pedidoDAO = new pedidoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listadoPedido.jsp");

        List<pedido> listado = this.pedidoDAO.getAll();
        request.setAttribute("listado", listado);

        dispatcher.forward(request, response);

    }
}