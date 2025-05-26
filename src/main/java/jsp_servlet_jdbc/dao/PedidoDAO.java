package jsp_servlet_jdbc.dao;

import jsp_servlet_jdbc.model.Cliente;
import jsp_servlet_jdbc.model.Comercial;
import jsp_servlet_jdbc.model.Pedido;


import java.util.List;

import java.sql.*;
import java.util.ArrayList;


import java.util.List;

public interface PedidoDAO {
    List<Pedido> findAllWithClienteComercial();
    boolean insert(Pedido pedido);
    List<Pedido> findByCantidadRange(double min, double max);

    List<Pedido> listarPedidos();

    void insertarPedido(Pedido pedido);

    List<Pedido> buscarPedidosPorRango(double min, double max);
}

