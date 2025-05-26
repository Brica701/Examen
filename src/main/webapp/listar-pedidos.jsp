<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 26/05/2025
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="jsp_servlet_jdbc.model.Pedido" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <title>Listado de Pedidos</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-6">

<div class="max-w-6xl mx-auto bg-white p-6 rounded shadow">
    <h1 class="text-2xl font-bold mb-6">Resumen de Clientes por Comercial</h1>
    <table class="w-full table-auto border mb-8">
        <thead class="bg-gray-200">
        <tr>
            <th class="p-2 text-left">Comercial</th>
            <th class="p-2 text-left">#Clientes</th>
        </tr>
        </thead>
        <tbody>
        <%
            Map<String, Integer> resumen = (Map<String, Integer>) request.getAttribute("resumen");
            if (resumen != null) {
                for (Map.Entry<String, Integer> entry : resumen.entrySet()) {
        %>
        <tr>
            <td class="p-2"><%= entry.getKey() %></td>
            <td class="p-2"><%= entry.getValue() %></td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>

    <h2 class="text-xl font-semibold mb-4">Buscador por rango de cantidad</h2>
    <form action="buscar-pedidos" method="get" class="mb-6 flex gap-4">
        <input type="number" step="0.01" name="min" placeholder="Cantidad mínima" class="p-2 border rounded w-48">
        <input type="number" step="0.01" name="max" placeholder="Cantidad máxima" class="p-2 border rounded w-48">
        <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded">Buscar</button>
    </form>

    <div class="flex justify-between items-center mb-4">
        <h1 class="text-2xl font-bold">Listado de Pedidos</h1>
        <a href="crear-pedido" class="bg-green-600 text-white px-4 py-2 rounded">Crear Pedido</a>
    </div>

    <table class="w-full table-auto border">
        <thead class="bg-gray-200">
        <tr>
            <th class="p-2 text-left">ID</th>
            <th class="p-2 text-left">Cantidad</th>
            <th class="p-2 text-left">Fecha</th>
            <th class="p-2 text-left">Cliente</th>
            <th class="p-2 text-left">Comercial</th>
            <th class="p-2 text-left">Acciones</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Pedido> pedidos = (List<Pedido>) request.getAttribute("pedidos");
            if (pedidos != null) {
                for (Pedido p : pedidos) {
        %>
        <tr class="border-t">
            <td class="p-2"><%= p.getId() %></td>
            <td class="p-2"><%= p.getTotal() %></td>
            <td class="p-2"><%= p.getFecha() %></td>
            <td class="p-2">
                <a class="text-blue-600 hover:underline"
                   href="<%= request.getContextPath() + "/cliente/editar?id=" + p.getIdCliente() %>">
                    <%= p.getNombreCliente() %> <%= p.getApellido1Cliente() %> <%= p.getApellido2Cliente() %>
                </a>
            </td>
            <td class="p-2"><%= p.getNombreComercial() %> <%= p.getApellido1Comercial() %> <%= p.getApellido2Comercial() %></td>
            <td class="p-2 text-sm">
                <!-- Aquí iría botón de borrar si quieres -->
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>

