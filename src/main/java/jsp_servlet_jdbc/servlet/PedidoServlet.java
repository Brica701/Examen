package jsp_servlet_jdbc.servlet;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jsp_servlet_jdbc.dao.ComercialDAO;
import jsp_servlet_jdbc.dao.PedidoDAO;
import jsp_servlet_jdbc.model.Pedido;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/listarPedidos")
public class PedidoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PedidoDAO pedidoDAO = new PedidoDAOImpl();
    private ComercialDAO comercialDAO = new ComercialDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pedido> pedidos = pedidoDAO.listarPedidos();
        List<Comercial> comerciales = comercialDAO.listarComerciales();

        // Calculando el número de clientes por cada comercial
        Map<Comercial, Integer> clientesPorComercial = new HashMap<>();
        for (Comercial comercial : comerciales) {
            int numeroClientes = pedidoDAO.obtenerClientesPorComercial(comercial.getId());
            clientesPorComercial.put(comercial, numeroClientes);
        }

        request.setAttribute("pedidos", pedidos);
        request.setAttribute("clientesPorComercial", clientesPorComercial);
        request.getRequestDispatcher("/listarPedidos.jsp").forward(request, response);
    }
}



