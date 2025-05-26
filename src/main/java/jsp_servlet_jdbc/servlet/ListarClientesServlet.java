package jsp_servlet_jdbc.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jsp_servlet_jdbc.dao.ClienteDAO;
import jsp_servlet_jdbc.dao.ClienteDAOImpl;
import jsp_servlet_jdbc.model.Cliente;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/clientes")
public class ListarClientesServlet extends HttpServlet {
    private ClienteDAO clienteDAO;

    @Override
    public void init() {
        Connection conn = (Connection) getServletContext().getAttribute("conexion");
        this.clienteDAO = new ClienteDAOImpl(conn);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Cliente> listaClientes = clienteDAO.getAllClientes();
        request.setAttribute("clientes", listaClientes);

        request.getRequestDispatcher("/listar-clientes.jsp").forward(request, response);
    }
}
