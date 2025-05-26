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
import java.sql.DriverManager;
import java.util.List;

@WebServlet("/listar-pedidos")
public class ListarPedidosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Conecta a la base de datos (reemplaza los valores reales)
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tu_basededatos", "usuario", "contraseña");

            // Usa directamente tu implementación de PedidoDAOImpl
            PedidoDAO pedidoDAO = new PedidoDAOImpl(connection) {
                @Override
                public List<Pedido> findAllWithClienteComercial() {
                    return List.of();
                }

                @Override
                public boolean insert(Pedido pedido) {
                    return false;
                }

                @Override
                public List<Pedido> findByCantidadRange(double min, double max) {
                    return List.of();
                }
            };
            List<Pedido> pedidos = pedidoDAO.listarPedidos();

            // Atributo a la request y reenvío al JSP
            request.setAttribute("pedidos", pedidos);
            request.getRequestDispatcher("/listarPedidos.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "Error al listar pedidos");
        }
    }
}
