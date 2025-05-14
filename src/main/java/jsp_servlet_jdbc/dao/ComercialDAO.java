package jsp_servlet_jdbc.dao;


import jsp_servlet_jdbc.model.Comercial;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ComercialDAO {
    private Connection connection;

    public ComercialDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Comercial> findAll() throws SQLException {
        String sql = "SELECT * FROM comercial";
        List<Comercial> comerciales = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Comercial comercial = new Comercial();
                comercial.setId(rs.getInt("id"));
                comercial.setNombre(rs.getString("nombre"));
                comercial.setApellido1(rs.getString("apellido1"));
                comercial.setApellido2(rs.getString("apellido2"));
                comercial.setComision(rs.getFloat("comision"));
                comerciales.add(comercial);
            }
        }
        return comerciales;
    }

    public abstract List<Comercial> listarComerciales();

    public abstract Comercial obtenerComercialPorId(int id);

    public abstract void insertarComercial(Comercial comercial);

    public abstract void actualizarComercial(Comercial comercial);

    public abstract void eliminarComercial(int id);
}
