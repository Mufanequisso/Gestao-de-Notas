<%-- 
    Document   : erro
    Created on : Jun 6, 2024, 12:22:29 AM
    Author     : Paulino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Erro</title>
</head>
<body>
    <div class="container mt-5">
        <div class="alert alert-danger" role="alert">
            <%= request.getAttribute("errorMessage") %>
        </div>
        <a href="index.jsp" class="btn btn-primary">Voltar</a>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>