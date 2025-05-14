<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 14/5/25
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="jsp_servlet_jdbc.model.Cliente, jsp_servlet_jdbc.model.Comercial" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Crear Pedido</title>
</head>
<body>
<h2>Crear Nuevo Pedido</h2>
<form action="crearPedido" method="post">
  <label for="cantidad">Cantidad:</label>
  <input type="number" id="cantidad" name="cantidad" required>
  <br>
  <label for="fecha">Fecha:</label>
  <input type="date" id="fecha" name="fecha" required>
  <br>
  <label for="cliente">Cliente:</label>
  <select name="cliente" required>
    <c:forEach var="cliente" items="${clientes}">
      <option value="${cliente.id}">${cliente.nombre} ${cliente.apellido1}</option>
    </c:forEach>
  </select>
  <br>
  <label for="comercial">Comercial:</label>
  <select name="comercial" required>
    <c:forEach var="comercial" items="${comerciales}">
      <option value="${comercial.id}">${comercial.nombre} ${comercial.apellido1}</option>
    </c:forEach>
  </select>
  <br>
  <button type="submit">Crear Pedido</button>
</form>
</body>
</html>

