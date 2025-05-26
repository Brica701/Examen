package jsp_servlet_jdbc.dao;

import jsp_servlet_jdbc.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    private Connection connection;

    public ClienteDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Cliente findById(int id) {
        String query = "SELECT * FROM cliente WHERE id = ?";
        Cliente cliente = null;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellido1"),
                            rs.getString("apellido2"),
                            rs.getString("ciudad"),
                            rs.getObject("categoria") != null ? rs.getInt("categoria") : null
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }

    @Override
    public List<Cliente> findAll() {
        return getAllClientes(); // reutilizamos la implementación
    }

    @Override
    public boolean update(Cliente cliente) {
        return updateCliente(cliente); // reutilizamos la implementación
    }

    @Override
    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM cliente";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("ciudad"),
                        rs.getObject("categoria") != null ? rs.getInt("categoria") : null
                );
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    @Override
    public Cliente getClienteById(int id) {
        return findById(id); // reutilizamos la implementación
    }

    @Override
    public void insertarCliente(Cliente cliente) {
        String query = "INSERT INTO cliente (nombre, apellido1, apellido2, ciudad, categoria) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido1());
            stmt.setString(3, cliente.getApellido2());
            stmt.setString(4, cliente.getCiudad());
            stmt.setObject(5, cliente.getCategoria(), Types.INTEGER); // puede ser null

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarCliente(int id) {
        String query = "DELETE FROM cliente WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateCliente(Cliente cliente) {
        String query = "UPDATE cliente SET nombre = ?, apellido1 = ?, apellido2 = ?, ciudad = ?, categoria = ? WHERE id = ?";
        boolean updated = false;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido1());
            stmt.setString(3, cliente.getApellido2());
            stmt.setString(4, cliente.getCiudad());
            stmt.setObject(5, cliente.getCategoria(), Types.INTEGER);
            stmt.setInt(6, cliente.getId());

            updated = stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }
}
