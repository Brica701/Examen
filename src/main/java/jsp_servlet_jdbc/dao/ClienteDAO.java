package jsp_servlet_jdbc.dao;

import jsp_servlet_jdbc.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Cliente> findAll() throws SQLException {
        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido1(rs.getString("apellido1"));
                cliente.setApellido2(rs.getString("apellido2"));
                cliente.setCiudad(rs.getString("ciudad"));
                cliente.setCategoria(rs.getInt("categoria"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public Cliente findById(int id) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("id"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellido1(rs.getString("apellido1"));
                    cliente.setApellido2(rs.getString("apellido2"));
                    cliente.setCiudad(rs.getString("ciudad"));
                    cliente.setCategoria(rs.getInt("categoria"));
                    return cliente;
                }
            }
        }
        return null;
    }

    public void update(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente SET nombre=?, apellido1=?, apellido2=?, ciudad=?, categoria=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido1());
            ps.setString(3, cliente.getApellido2());
            ps.setString(4, cliente.getCiudad());
            ps.setInt(5, cliente.getCategoria());
            ps.setInt(6, cliente.getId());
            ps.executeUpdate();
        }
    }
}
