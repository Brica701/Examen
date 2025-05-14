<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 13/12/24
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="jsp_servlet_jdbc.model.Pedido, jsp_servlet_jdbc.model.Cliente, jsp_servlet_jdbc.model.Comercial" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listado de Pedidos</title>
</head>
<body>
<h2>Resumen de Clientes por Comercial</h2>
<table border="1">
    <thead>
    <tr>
        <th>Comercial</th>
        <th>Número de Clientes</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="comercial" items="${clientesPorComercial}">
        <tr>
            <td>${comercial.nombre} ${comercial.apellido1}</td>
            <td>${comercial.numeroClientes}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Listado de Pedidos</h2>
<form action="buscarPorRango" method="get">
    <label for="minCantidad">Cantidad mínima:</label>
    <input type="number" id="minCantidad" name="minCantidad">
    <label for="maxCantidad">Cantidad máxima:</label>
    <input type="number" id="maxCantidad" name="maxCantidad">
    <button type="submit">Buscar</button>
</form>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Cantidad</th>
        <th>Fecha</th>
        <th>Cliente</th>
        <th>Comercial</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="pedido" items="${pedidos}">
        <tr>
            <td>${pedido.id}</td>
            <td>${pedido.total}</td>
            <td>${pedido.fecha}</td>
            <td>${pedido.cliente.nombre} ${pedido.cliente.apellido1}</td>
            <td>${pedido.comercial.nombre} ${pedido.comercial.apellido1}</td>
            <td>
                <a href="editarPedido?id=${pedido.id}">Editar</a>
                <a href="borrarPedido?id=${pedido.id}">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
