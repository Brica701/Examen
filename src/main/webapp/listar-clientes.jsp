<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 26/05/2025
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="jsp_servlet_jdbc.model.Cliente" %>
<%
  List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Clientes</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex flex-col items-center p-6">
<h1 class="text-3xl font-bold mb-6">Listado de Clientes</h1>

<table class="min-w-full bg-white shadow-md rounded-xl overflow-hidden">
  <thead class="bg-gray-200 text-gray-600">
  <tr>
    <th class="px-6 py-3 text-left">ID</th>
    <th class="px-6 py-3 text-left">Nombre</th>
    <th class="px-6 py-3 text-left">Apellido</th>
    <th class="px-6 py-3 text-left">Email</th>
    <th class="px-6 py-3">Acciones</th>
  </tr>
  </thead>
  <tbody>
  <%
    for (Cliente c : clientes) {
  %>
  <tr class="border-b">
    <td class="px-6 py-4"><%= c.getId() %></td>
    <td class="px-6 py-4"><%= c.getNombre() %></td>
    <td class="px-6 py-4 text-center">
      <a href="editar-cliente?id=<%= c.getId() %>" class="text-blue-500 hover:underline">Editar</a>
    </td>
  </tr>
  <%
    }
  %>
  </tbody>
</table>
</body>
</html>

