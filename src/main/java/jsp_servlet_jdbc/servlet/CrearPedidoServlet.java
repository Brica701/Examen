package jsp_servlet_jdbc.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jsp_servlet_jdbc.dao.ClienteDAO;
import jsp_servlet_jdbc.dao.ComercialDAO;
import jsp_servlet_jdbc.dao.PedidoDAO;
import jsp_servlet_jdbc.model.Cliente;
import jsp_servlet_jdbc.model.Comercial;

import java.io.IOException;
import java.util.List;

@WebServlet("/crearPedido")
public class CrearPedidoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PedidoDAO pedidoDAO = new PedidoDAOImpl();
    private ClienteDAO clienteDAO = new ClienteDAOImpl();
    private ComercialDAO comercialDAO = new ComercialDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> clientes = clienteDAO.listarClientes();
        List<Comercial> comerciales = comercialDAO.listarComerciales();
        request.setAttribute("clientes", clientes);
        request.setAttribute("comerciales", comerciales);
        request.getRequestDispatcher("/crearPedido.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double cantidad = Double.parseDouble(request.getParameter("cantidad"));
        String fecha = request.getParameter("fecha");
        int clienteId = Integer.parseInt(request.getParameter("cliente"));
        int comercialId = Integer.parseInt(request.getParameter("comercial"));

        // Validaciones
        if (cantidad <= 0 || fecha == null || fecha.isEmpty()) {
            request.setAttribute("error", "Datos no válidos");
            doGet(request, response);
            return;
        }

        Pedido pedido = new Pedido();
        pedido.setTotal(cantidad);
        pedido.setFecha(fecha);
        pedido.setIdCliente(clienteId);
        pedido.setIdComercial(comercialId);

        pedidoDAO.insertarPedido(pedido);
        response.sendRedirect("listarPedidos");
    }
}
