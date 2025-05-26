package jsp_servlet_jdbc.dao;

import jsp_servlet_jdbc.model.Cliente;
import jsp_servlet_jdbc.model.Comercial;
import jsp_servlet_jdbc.model.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOImpl implements PedidoDAO {

    private Connection connection;

    public PedidoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Pedido> findAllWithClienteComercial() {
        return List.of(); // Implementa esto más adelante si lo necesitas
    }

    @Override
    public boolean insertarPedido(Pedido pedido) {
        return false;
    }

    @Override
    public boolean insert(Pedido pedido) {
        String query = "INSERT INTO pedido (total, fecha, id_cliente, id_comercial) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, pedido.getTotal());
            stmt.setDate(2, Date.valueOf(pedido.getFecha()));
            stmt.setInt(3, pedido.getIdCliente());
            stmt.setInt(4, pedido.getIdComercial());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Pedido> listarPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        String query = """
            SELECT p.*, 
                   c.nombre AS c_nombre, c.apellido1 AS c_apellido1,
                   cm.nombre AS cm_nombre, cm.apellido1 AS cm_apellido1
            FROM pedido p
            JOIN cliente c ON p.id_cliente = c.id
            JOIN comercial cm ON p.id_comercial = cm.id
        """;

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("c_nombre"),
                        rs.getString("c_apellido1"),
                        null, null, 0
                );

                Comercial comercial = new Comercial(
                        rs.getInt("id_comercial"),
                        rs.getString("cm_nombre"),
                        rs.getString("cm_apellido1"),
                        null, 0
                );

                Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getDouble("total"),
                        rs.getDate("fecha").toLocalDate(),
                        cliente,
                        comercial
                );

                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }

    @Override
    public List<Pedido> buscarPedidosPorRango(double min, double max) {
        List<Pedido> pedidos = new ArrayList<>();
        String query = """
            SELECT p.*, 
                   c.nombre AS c_nombre, c.apellido1 AS c_apellido1,
                   cm.nombre AS cm_nombre, cm.apellido1 AS cm_apellido1
            FROM pedido p
            JOIN cliente c ON p.id_cliente = c.id
            JOIN comercial cm ON p.id_comercial = cm.id
            WHERE p.total BETWEEN ? AND ?
        """;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, min);
            stmt.setDouble(2, max);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente(
                            rs.getInt("id_cliente"),
                            rs.getString("c_nombre"),
                            rs.getString("c_apellido1"),
                            null, null, 0
                    );

                    Comercial comercial = new Comercial(
                            rs.getInt("id_comercial"),
                            rs.getString("cm_nombre"),
                            rs.getString("cm_apellido1"),
                            null, 0
                    );

                    Pedido pedido = new Pedido(
                            rs.getInt("id"),
                            rs.getDouble("total"),
                            rs.getDate("fecha").toLocalDate(),
                            cliente,
                            comercial
                    );

                    pedidos.add(pedido);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }
}
