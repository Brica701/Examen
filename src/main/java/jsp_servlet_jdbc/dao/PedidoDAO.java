package jsp_servlet_jdbc.dao;

import jsp_servlet_jdbc.model.Pedido;

import java.util.List;

public interface PedidoDAO {
    List<Pedido> findAllWithClienteComercial();
    boolean insertarPedido(Pedido pedido);

    boolean insert(Pedido pedido);

    List<Pedido> listarPedidos();
    List<Pedido> buscarPedidosPorRango(double min, double max);
}
