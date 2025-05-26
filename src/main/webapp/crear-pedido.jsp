<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 26/05/2025
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="jsp_servlet_jdbc.model.Cliente" %>
<%@ page import="jsp_servlet_jdbc.model.Comercial" %>
<html>
<head>
  <title>Crear Pedido</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-6">

<div class="max-w-xl mx-auto bg-white p-6 rounded shadow">
  <h1 class="text-2xl font-bold mb-6">Crear Pedido</h1>

  <form action="insertar" method="post" class="space-y-4">
    <div>
      <label class="block font-medium">Total</label>
      <input type="number" name="total" required min="0" step="0.01"
             class="w-full border p-2 rounded">
    </div>

    <div>
      <label class="block font-medium">Fecha</label>
      <input type="date" name="fecha" required class="w-full border p-2 rounded">
    </div>

    <div>
      <label class="block font-medium">Cliente</label>
      <select name="id_cliente" class="w-full border p-2 rounded">
        <%
          List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
          for (Cliente c : clientes) {
        %>
        <option value="<%= c.getId() %>"><%= c.getNombre() %> <%= c.getApellido1() %> <%= c.getApellido2() %></option>
        <%
          }
        %>
      </select>
    </div>

    <div>
      <label class="block font-medium">Comercial</label>
      <select name="id_comercial" class="w-full border p-2 rounded">
        <%
          List<Comercial> comerciales = (List<Comercial>) request.getAttribute("comerciales");
          for (Comercial c : comerciales) {
        %>
        <option value="<%= c.getId() %>"><%= c.getNombre() %> <%= c.getApellido1() %> <%= c.getApellido2() %></option>
        <%
          }
        %>
      </select>
    </div>

    <div>
      <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded">Guardar</button>
    </div>
  </form>
</div>

</body>
</html>

