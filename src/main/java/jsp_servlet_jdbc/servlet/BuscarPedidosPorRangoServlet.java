package jsp_servlet_jdbc.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jsp_servlet_jdbc.dao.PedidoDAO;
import jsp_servlet_jdbc.dao.PedidoDAOImpl;
import jsp_servlet_jdbc.model.Pedido;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/pedidos/buscar-rango")
public class BuscarPedidosPorRangoServlet extends HttpServlet {

    private PedidoDAO pedidoDAO;

    @Override
    public void init() {
        Connection conn = (Connection) getServletContext().getAttribute("conexion");
        this.pedidoDAO = new PedidoDAOImpl(conn);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double min = Double.parseDouble(request.getParameter("min"));
        double max = Double.parseDouble(request.getParameter("max"));

        List<Pedido> pedidos = pedidoDAO.buscarPedidosPorRango(min, max);
        request.setAttribute("pedidos", pedidos);

        request.getRequestDispatcher("/views/pedidos/lista.jsp").forward(request, response);
    }
}
