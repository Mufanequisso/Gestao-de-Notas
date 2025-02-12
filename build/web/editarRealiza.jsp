<%-- 
    Document   : editarRealiza
    Created on : Jun 5, 2024, 9:14:37 PM
    Author     : Paulino
--%>

<%@page import="model.RealizaId"%>
<%@page import="dao.RealizaIdDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dao.RealizaDao" %>
<%@ page import="model.Realiza" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Realização</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container-sm">
        <form action="EditarRealizaServlet" method="post">
            <div class="form-group">
                <%
                int nrmatricula = Integer.parseInt(request.getParameter("ma"));
                int codigoAvaliacao = Integer.parseInt(request.getParameter("codigoA"));
                 RealizaId realizaId = new RealizaId();
                 
                 
                realizaId.setNrmatricula(nrmatricula);
                 realizaId.setCodigoA(codigoAvaliacao);
                 Realiza realiza = new Realiza();
                 realiza.setId(realizaId);
                %>
                <label for="nrmatricula">Número de Matrícula</label>
                <input type="text" class="form-control" id="nrmatricula" name="nrmatricula" required value="<%=realizaId.getNrmatricula()%>">
            </div>
            <div class="form-group">
                <label for="codigoAvaliacao">Código da Avaliação</label>
                <input type="text" class="form-control" id="codigoAvaliacao" name="codigoAvaliacao" required value="<%= realizaId.getCodigoA()%>">
            </div>
            <div class="form-group">
                <label for="nota">Nota</label>
                <input type="text" class="form-control" id="nota" name="nota" required value="<%= realiza.getNota()%>">
            </div>
            <button type="submit" class="btn btn-primary">Atualizar</button>
        </form>
    </div>
</body>
</html>
