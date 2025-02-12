<%-- 
    Document   : curso
    Created on : Jun 5, 2024, 7:14:49 PM
    Author     : Paulino
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.CursoDao" %>
<%@ page import="model.Curso" %>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Tabela Curso</title>
</head>
<body>
    <div class="container mt-5">
        
   
   
        <h2 class="mb-4">Dados de Curso</h2>
        
         <a class="btn btn-primary " href="formularioCurso.jsp">Adicione Curso</a>
         <a class="btn btn-danger justify-content-end m-2" href="index.jsp">Voltar</a>
            
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Código do Curso</th>
                    <th>Nome</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    CursoDao cursoDao = new CursoDao();
                    List<Curso> cursos = cursoDao.getAllCursos();
                    
                    for (Curso curso : cursos) {
                %>
                <tr>
                    <td><%= curso.getCodCurso()%></td>
                    <td><%= curso.getNome()%></td>
                    <td>
                        <a href="editarCurso.jsp?cc=<%=curso.getCodCurso()%>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="RemoverCursoServlet?cc=<%=curso.getCodCurso()%>" class="btn btn-danger btn-sm">Remover</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
