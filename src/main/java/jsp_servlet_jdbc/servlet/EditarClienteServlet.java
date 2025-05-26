package jsp_servlet_jdbc.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jsp_servlet_jdbc.dao.ClienteDAO;
import jsp_servlet_jdbc.dao.ClienteDAOImpl;
import jsp_servlet_jdbc.model.Cliente;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/clientes/editar")
public class EditarClienteServlet extends HttpServlet {

    private ClienteDAO clienteDAO;

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
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = clienteDAO.findById(id);
        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("/views/clientes/editar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String ciudad = request.getParameter("ciudad");
        int categoria = Integer.parseInt(request.getParameter("categoria"));

        // Validaciones
        if (nombre.isEmpty() || apellido1.isEmpty() || categoria < 1 || categoria > 10) {
            request.setAttribute("error", "Datos inválidos");
            request.setAttribute("cliente", new Cliente(id, nombre, apellido1, apellido2, ciudad, categoria));
            request.getRequestDispatcher("/views/clientes/editar.jsp").forward(request, response);
            return;
        }

        Cliente cliente = new Cliente(id, nombre, apellido1, apellido2, ciudad, categoria);
        clienteDAO.update(cliente);

        response.sendRedirect(request.getContextPath() + "/pedidos");
    }
}
