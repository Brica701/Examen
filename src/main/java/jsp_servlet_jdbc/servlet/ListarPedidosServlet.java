package jsp_servlet_jdbc.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jsp_servlet_jdbc.dao.PedidoDAO;
import jsp_servlet_jdbc.dao.PedidoDAOImpl;
import jsp_servlet_jdbc.model.Pedido;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/pedidos")
public class ListarPedidosServlet extends HttpServlet {
    private PedidoDAO pedidoDAO;

    @Override
    public void init() {
        Connection conn = (Connection) getServletContext().getAttribute("conexion");
        this.pedidoDAO = new PedidoDAOImpl(conn); // <- Usa la implementación real
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Pedido> pedidos = pedidoDAO.listarPedidos();
        request.setAttribute("pedidos", pedidos);
        request.getRequestDispatcher("/views/pedidos/lista.jsp").forward(request, response);
    }
}
