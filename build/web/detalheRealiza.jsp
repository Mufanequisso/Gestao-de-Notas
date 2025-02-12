<%-- 
    Document   : realiza
    Created on : Jun 5, 2024, 6:55:34 PM
    Author     : Paulino
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.RealizaDao" %>
<%@ page import="model.Realiza" %>
<%@ page import="model.Estudante"%>
<%@ page import="model.Avaliacao"%>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Tabela Realiza</title>
</head>
<body>
    <div class="container mt-5">
         
        <h2 class="mb-4">Dados de Realiza</h2>
         <a class="btn btn-primary " href="formularioRealiza.jsp">Adicione uma realizaczao</a>
         <a class="btn btn-danger justify-content-end m-2" href="index.jsp">Voltar</a>
            
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Número de Matrícula</th>
                    <th>Código da Avaliação</th>
                    <th>Nota</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    RealizaDao realizaDao = new RealizaDao();
                    List<Realiza> realizas = realizaDao.getAllRealiza();
                    
                    for (Realiza realiza : realizas) {
                        Estudante estudante = realiza.getEstudante();
                        Avaliacao avaliacao = realiza.getAvaliacao();
                %>
                <tr>
                    <td><%= estudante.getNrmatricula()%></td>
                    <td><%= avaliacao.getCodigoA()%></td>
                    <td><%= realiza.getNota()%></td>
                    <td>
                        <a href="editarRealiza.jsp?ma=<%=estudante.getNrmatricula()%>&codigoA=<%=avaliacao.getCodigoA() %>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="RemoveRealizaServlet?nrmatricula=<%=estudante.getNrmatricula()%>&codigoA=<%=avaliacao.getCodigoA()%>" class="btn btn-danger btn-sm">Remover</a>
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

