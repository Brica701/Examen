package jsp_servlet_jdbc.dao;

import jsp_servlet_jdbc.model.Cliente;


import java.util.List;

public interface ClienteDAO {
    Cliente findById(int id);
    List<Cliente> findAll();
    boolean update(Cliente cliente);

    List<Cliente> getAllClientes();

    Cliente getClienteById(int id);

    boolean updateCliente(Cliente cliente);

    void insertarCliente(Cliente cliente);

    void eliminarCliente(int id);
}

