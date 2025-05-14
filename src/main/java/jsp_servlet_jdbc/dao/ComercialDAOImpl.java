package jsp_servlet_jdbc.dao;

import jsp_servlet_jdbc.model.Comercial;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComercialDAOImpl extends ComercialDAO {

    private Connection connection;

    public ComercialDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public List<Comercial> listarComerciales() {
        List<Comercial> comerciales = new ArrayList<>();
        String query = "SELECT * FROM comercial";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Comercial comercial = new Comercial(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getFloat("comision")
                );
                comerciales.add(comercial);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comerciales;
    }

    @Override
    public Comercial obtenerComercialPorId(int id) {
        Comercial comercial = null;
        String query = "SELECT * FROM comercial WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    comercial = new Comercial(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellido1"),
                            rs.getString("apellido2"),
                            rs.getFloat("comision")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comercial;
    }

    @Override
    public void insertarComercial(Comercial comercial) {
        String query = "INSERT INTO comercial (nombre, apellido1, apellido2, comision) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, comercial.getNombre());
            stmt.setString(2, comercial.getApellido1());
            stmt.setString(3, comercial.getApellido2());
            stmt.setFloat(4, comercial.getComision());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarComercial(Comercial comercial) {
        String query = "UPDATE comercial SET nombre = ?, apellido1 = ?, apellido2 = ?, comision = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, comercial.getNombre());
            stmt.setString(2, comercial.getApellido1());
            stmt.setString(3, comercial.getApellido2());
            stmt.setFloat(4, comercial.getComision());
            stmt.setInt(5, comercial.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarComercial(int id) {
        String query = "DELETE FROM comercial WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}