package jsp_servlet_jdbc.dao;


import jsp_servlet_jdbc.model.Comercial;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public interface ComercialDAO {
    Comercial findById(int id);
    List<Comercial> findAll();

    List<Comercial> listarComerciales();

    Comercial obtenerComercialPorId(int id);

    void insertarComercial(Comercial comercial);

    void actualizarComercial(Comercial comercial);

    void eliminarComercial(int id);
}
