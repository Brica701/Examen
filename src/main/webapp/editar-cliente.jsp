<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 26/05/2025
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jsp_servlet_jdbc.model.Cliente" %>
<html>
<head>
  <title>Editar Cliente</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-6">

<div class="max-w-xl mx-auto bg-white p-6 rounded shadow">
  <h1 class="text-2xl font-bold mb-6">Editar Cliente</h1>

  <form action="editar" method="post" class="space-y-4">
    <input type="hidden" name="id" value="${cliente.id}"/>

    <div>
      <label class="block font-medium">Nombre</label>
      <input type="text" name="nombre" value="${cliente.nombre}" required class="w-full border p-2 rounded">
    </div>

    <div>
      <label class="block font-medium">Apellido 1</label>
      <input type="text" name="apellido1" value="${cliente.apellido1}" required class="w-full border p-2 rounded">
    </div>

    <div>
      <label class="block font-medium">Apellido 2</label>
      <input type="text" name="apellido2" value="${cliente.apellido2}" class="w-full border p-2 rounded">
    </div>

    <div>
      <label class="block font-medium">Ciudad</label>
      <input type="text" name="ciudad" value="${cliente.ciudad}" class="w-full border p-2 rounded">
    </div>

    <div>
      <label class="block font-medium">Categoría (1 a 10)</label>
      <input type="number" name="categoria" value="${cliente.categoria}" min="1" max="10" required
             class="w-full border p-2 rounded">
    </div>

    <div>
      <button type="submit" class="bg-green-600 text-white px-4 py-2 rounded">Actualizar</button>
    </div>
  </form>
</div>
</body>
</html>
