<%-- 
    Document   : disciplina
    Created on : Jun 5, 2024, 7:15:19 PM
    Author     : Paulino
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.DisciplinaDao"%>
<%@ page import="model.Disciplina"%>
<%@ page import="model.Curso"%>
<%@ page import="dao.CursoDao"%>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Tabela Disciplina</title>
</head>
<body>
    <div class="container mt-5">
         
        <h2 class="mb-4">Dados de Disciplina</h2>
        
         <a class="btn btn-primary " href="formularioDisciplina.jsp">Adicione Diciplina</a>
         <a class="btn btn-danger justify-content-end m-2" href="index.jsp">Voltar</a>
            
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Código da Disciplina</th>
                    <th>Nome</th>
                    <th>Crédito</th>
                    <th>Carga Horária</th>
                    <th>Código do Curso</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    DisciplinaDao disciplinaDao = new DisciplinaDao();
                    List<Disciplina> disciplinas = disciplinaDao.getAllDisciplinas();
                    
                    for (Disciplina disciplina : disciplinas) {
                        Curso curso = disciplina.getCurso();
                %>
                <tr>
                    <td><%= disciplina.getCodD() %></td>
                    <td><%= disciplina.getNome() %></td>
                    <td><%= disciplina.getCredito() %></td>
                    <td><%= disciplina.getCh() %></td>
                    <td><%= curso != null ? curso.getCodCurso() : "N/A" %></td>
                    <td>
                        <a href="editarDisciplina.jsp?cod=<%= disciplina.getCodD()%>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="RemoverDisciplinaServlet?cod=<%= disciplina.getCodD()%>" class="btn btn-danger btn-sm">Remover</a>
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
