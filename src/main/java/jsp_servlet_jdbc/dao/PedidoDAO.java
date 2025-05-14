package jsp_servlet_jdbc.dao;

import jsp_servlet_jdbc.model.Cliente;
import jsp_servlet_jdbc.model.Comercial;
import jsp_servlet_jdbc.model.Pedido;


import java.util.List;

import java.sql.*;
import java.util.ArrayList;

public class PedidoDAO {
    private Connection connection;

    public PedidoDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Pedido> findAll() throws SQLException {
        String sql = "SELECT p.*, c.nombre AS nombre_cliente, c.apellido1 AS apellido1_cliente, co.nombre AS nombre_comercial, co.apellido1 AS apellido1_comercial " +
                "FROM pedido p " +
                "JOIN cliente c ON p.id_cliente = c.id " +
                "JOIN comercial co ON p.id_comercial = co.id";

        List<Pedido> pedidos = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setFecha(rs.getDate("fecha"));

                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre_cliente"));
                cliente.setApellido1(rs.getString("apellido1_cliente"));

                Comercial comercial = new Comercial();
                comercial.setId(rs.getInt("id_comercial"));
                comercial.setNombre(rs.getString("nombre_comercial"));
                comercial.setApellido1(rs.getString("apellido1_comercial"));

                pedido.setCliente(cliente);
                pedido.setComercial(comercial);

                pedidos.add(pedido);
            }
        }
        return pedidos;
    }

    public void save(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO pedido (total, fecha, id_cliente, id_comercial) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, pedido.getTotal());
            ps.setDate(2, new java.sql.Date(pedido.getFecha().getTime()));
            ps.setInt(3, pedido.getCliente().getId());
            ps.setInt(4, pedido.getComercial().getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM pedido WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
