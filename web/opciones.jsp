<%-- 
    Document   : opciones
    Created on : 18-11-2024, 09:31:04 PM
    Author     : ivanb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="Styles/estilos.css">
<h1>Campeonato</h1>
<p>
    Opciones: 
    <a href="<c:url value="/AgregarParticipanteServlet" />">Agregar Participante</a>
    |
    <a href="<c:url value="/ListarParticipanteServlet" />">Listar Participantes</a>

</p>
<hr />
