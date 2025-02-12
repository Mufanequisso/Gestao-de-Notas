<%-- 
    Document   : avaliacao
    Created on : Jun 5, 2024, 7:16:26 PM
    Author     : Paulino
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.AvaliacaoDao" %>
<%@ page import="model.Avaliacao" %>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Tabela Avaliação</title>
</head>
<body>
     <div class="container mt-5">
        
           
        </div>
            
    
    <div class="container m-5"> 
        
        
        <h2 class="mb-4">Dados de Avaliação</h2>
        
         <a class="btn btn-primary " href="formularioAvaliacao.jsp">Adicione Avaliacao</a>
         <a class="btn btn-danger justify-content-end m-2" href="index.jsp">Voltar</a>
            
        
        
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Código da Avaliação</th>
                    <th>Descrição</th>
                    <th>Peso</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
                    List<Avaliacao> avaliacoes = avaliacaoDao.getAllavaliacao();
                    
                    for (Avaliacao avaliacao :  avaliacoes){
                %>
                <tr>
                    <td><%= avaliacao.getCodigoA()%></td>
                    <td><%= avaliacao.getDescricao()%></td>
                    <td><%= avaliacao.getPeso()%></td>
                    <td>
                        <a href="editarAvaliacao.jsp?codigoA=<%=avaliacao.getCodigoA()%>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="RemoverAvaliacaoServlet?codigoA=<%=avaliacao.getCodigoA()%>" class="btn btn-danger btn-sm">Remover</a>
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
