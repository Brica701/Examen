package jsp_servlet_jdbc.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jsp_servlet_jdbc.dao.ClienteDAO;
import jsp_servlet_jdbc.dao.ComercialDAO;
import jsp_servlet_jdbc.dao.ClienteDAOImpl;
import jsp_servlet_jdbc.dao.ComercialDAOImpl;
import jsp_servlet_jdbc.model.Cliente;
import jsp_servlet_jdbc.model.Comercial;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/pedidos/formulario-crear")
public class MostrarFormularioCrearPedidoServlet extends HttpServlet {

    private ClienteDAO clienteDAO;
    private ComercialDAO comercialDAO;

    @Override
    public void init() {
        Connection conn = (Connection) getServletContext().getAttribute("conexion");
        this.clienteDAO = new ClienteDAOImpl(conn) {
            @Override
            public Cliente findById(int id) {
                return null;
            }

            @Override
            public List<Cliente> findAll() {
                return List.of();
            }

            @Override
            public boolean update(Cliente cliente) {
                return false;
            }
        };
        this.comercialDAO = new ComercialDAOImpl(conn) {
            @Override
            public Comercial findById(int id) {
                return null;
            }

            @Override
            public List<Comercial> findAll() {
                return List.of();
            }
        };
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Cliente> clientes = clienteDAO.findAll();
        List<Comercial> comerciales = comercialDAO.findAll();

        request.setAttribute("clientes", clientes);
        request.setAttribute("comerciales", comerciales);

        request.getRequestDispatcher("/views/pedidos/formulario.jsp").forward(request, response);
    }
}
