<%-- 
    Document   : formularioCurso
    Created on : Jun 6, 2024, 1:44:50 AM
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
    <title>Adicionar Curso</title>
     <style>
            body{

                background-color:aliceblue;
            }
        </style>
</head>
<body>
    <div class="container mt-5">
        <a href="detalheCurso.jsp" class="btn btn-primary">Voltar</a>
        <h2>Adicionar Curso</h2>
        <form action="CursoServlet" method="post">
            <div class="form-group">
                <label for="codCurso">Código do Curso</label>
                <input type="number" class="form-control" id="codCurso" name="codCurso" required>
            </div>
            <div class="form-group">
                <label for="nomeCurso">Nome do Curso</label>
                <input type="text" class="form-control" id="nomeCurso" name="nomeCurso" required>
            </div>
            <button type="submit" class="btn btn-primary">Adicionar</button>
            <a href="detalheCurso.jsp" class="btn btn-secondary">Voltar</a>
        </form>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
