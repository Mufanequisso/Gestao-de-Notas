<%-- 
    Document   : formularioAvaliacao
    Created on : Jun 6, 2024, 1:46:06 AM
    Author     : Paulino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Formulário de Avaliação</title>
    
     <style>
            body{

                background-color:aliceblue;
            }
        </style>
</head>
<body>
    <div class="container mt-5">
        <a href="detalheAvaliacao.jsp" class="btn btn-primary">Voltar</a>
        <h2>Formulário de Avaliação</h2>
        <form action="AvaliacaoServlet" method="post">
            <div class="form-group">
                <label for="codigoA">Código da Avaliação</label>
                <input type="text" class="form-control" id="codigoA" name="codigoA" required>
            </div>
            <div class="form-group">
                <label for="descricao">Descrição</label>
                <input type="text" class="form-control" id="descricao" name="descricao" required>
            </div>
            <div class="form-group">
                <label for="peso">Peso</label>
                <input type="number" class="form-control" id="peso" name="peso" required>
            </div>
            <button type="submit" class="btn btn-primary">Salvar</button>
        </form>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
