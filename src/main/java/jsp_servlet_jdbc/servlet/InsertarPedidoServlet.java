package jsp_servlet_jdbc.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jsp_servlet_jdbc.dao.PedidoDAO;
import jsp_servlet_jdbc.dao.PedidoDAOImpl;
import jsp_servlet_jdbc.model.Pedido;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

@WebServlet("/pedidos/insertar")
public class InsertarPedidoServlet extends HttpServlet {
    private PedidoDAO pedidoDAO;

    @Override
    public void init() {
        Connection conn = (Connection) getServletContext().getAttribute("conexion");
        this.pedidoDAO = new PedidoDAOImpl(conn);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double total = Double.parseDouble(request.getParameter("total"));
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
        int idCliente = Integer.parseInt(request.getParameter("id_cliente"));
        int idComercial = Integer.parseInt(request.getParameter("id_comercial"));

        Pedido pedido = new Pedido(0, total, fecha, idCliente, idComercial);
        pedidoDAO.insertarPedido(pedido);

        response.sendRedirect(request.getContextPath() + "/pedidos");
    }
}
