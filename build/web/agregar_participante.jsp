<%-- 
    Document   : agregar_participante
    Created on : 18-11-2024, 09:32:00 PM
    Author     : ivanb
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Participante</title>
        <link rel="stylesheet" href="Styles/estilos.css">
    </head>
    <body>
        <div class="container">
            <%@include file="opciones.jsp" %>
            <h2>Agregar Participante</h2>
        
            <div>
            <form action="<c:url value="/AgregarParticipanteServlet" />" method="post">
                ID:
                <input type="text"
                       name="id" 
                       value="<c:out value="${participante.id}" />"
                       autofocus="true"
                       />
                <c:out value="${mapMensajes['id']}" />
                <br />

                Nombre:
                <input type="text"
                       name="nombre" 
                       value="<c:out value="${participante.nombre}" />"
                       />
                <c:out value="${mapMensajes['nombre']}" />
                <br />

                Sexo:
                <select name="sexo">
                    <option value="">Seleccione</option> 
                    <option value="Hombre" ${participante.sexo.equals("Hombre") ? 'selected' : 'Mujer'}>Hombre</option>
                    <option value="Mujer" ${participante.sexo.equals("Mujer") ? 'selected' : 'Hombre'}>Mujer</option>
                </select>
                <c:out value="${mapMensajes['sexo']}" />
                <br />

                Distancia:
                <input type="text"
                       name="distancia"
                       value="<c:out value="${participante.distancia}" />"
                       />
                <c:out value="${mapMensajes['distancia']}" />
                <br />

                Categoría:
                <input type="text"
                       name="categoria"
                       value="<c:out value="${participante.categoria}" />"
                       />
                <c:out value="${mapMensajes['categoria']}" />
                <br />
                <br />

                <input type="submit" value="Registrar" />
                <br />

            </form>
            <br/>

            <c:out value="${mensaje}" />
            </div>
        </div>
    </body>
</html>
