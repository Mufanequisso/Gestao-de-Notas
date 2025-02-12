<%-- 
    Document   : estudante
    Created on : Jun 5, 2024, 7:15:38 PM
    Author     : Paulino
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.EsduanteDao" %>
<%@ page import="model.Estudante"%>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Tabela Estudante</title>
</head>
<body>
    <div class="container mt-5">
         
        <h2 class="mb-4">Dados de Estudante</h2>
         <a class="btn btn-primary " href="formularioEstudante.jsp">Adicione Estudante</a>
         <a class="btn btn-danger justify-content-end m-2" href="index.jsp">Voltar</a>
            
        
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Número de Matrícula</th>
                    <th>Nome</th>
                    <th>Apelido</th>
                    <th>Endereço</th>
                    <th>Contacto</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    EsduanteDao estudanteDao = new EsduanteDao();
                    List<Estudante> estudantes = estudanteDao.getAllEstudante();
                    
                    for (Estudante estudante : estudantes) {
                %>
                <tr>
                    <td><%= estudante.getNrmatricula() %></td>
                    <td><%= estudante.getNome() %></td>
                    <td><%= estudante.getApelido() %></td>
                    <td><%= estudante.getEndereco() %></td>
                    <td><%= estudante.getContacto() %></td>
                    <td>
                        <a href="editarEstudante.jsp?id=<%= estudante.getNrmatricula() %>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="RemoverEstudante?id=<%= estudante.getNrmatricula() %>" class="btn btn-danger btn-sm">Remover</a>
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
