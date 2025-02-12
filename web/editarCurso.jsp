<%-- 
    Document   : editarCurso
    Created on : Jun 5, 2024, 7:50:02 PM
    Author     : Paulino
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.CursoDao" %>
<%@ page import="model.Curso"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Curso</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container-sm">
        <form action="EditarCursoServlet" method="get">
            <div class="form-group">
                <%
                int codigo = Integer.parseInt(request.getParameter("cc"));
                CursoDao dao = new CursoDao();
                Curso curso = dao.getCurso(codigo);
                %>
                <label for="codCurso">Código do Curso</label>
                <input type="text" class="form-control" id="codCurso" name="cc" required value="<%=curso.getCodCurso()%>">
            </div>
            <div class="form-group">
                <label for="nomeCurso">Nome do Curso</label>
                <input type="text" class="form-control" id="nomeCurso" name="nome" required value="<%=curso.getNome()%>">
            </div>
            <button type="submit" class="btn btn-primary">Atualizar</button>
        </form>
    </div>
</body>
</html>
