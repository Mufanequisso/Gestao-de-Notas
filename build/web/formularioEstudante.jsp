<%-- 
    Document   : FormularioEstudante
    Created on : Jun 6, 2024, 1:43:51 AM
    Author     : Paulino
--%>


<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Adicionar Estudante</title>
    
     <style>
            body{

                background-color:aliceblue;
            }
        </style>
</head>
<body>
    <div class="container mt-5">
        <a href="detalheEstudante.jsp" class="btn btn-primary">Voltar</a>
        <h2>Adicionar Estudante</h2>
        <form action="EstudanteServlet" method="post">
            <div class="form-group">
                <label for="nrmatricula">Número de Matrícula</label>
                <input type="number" class="form-control" id="nrmatricula" name="nrmatricula" required>
            </div>
            <div class="form-group">
                <label for="nomeEstudante">Nome</label>
                <input type="text" class="form-control" id="nomeEstudante" name="nomeEstudante" required>
            </div>
            <div class="form-group">
                <label for="apelido">Apelido</label>
                <input type="text" class="form-control" id="apelido" name="apelido" required>
            </div>
            <div class="form-group">
                <label for="endereco">Endereço</label>
                <input type="text" class="form-control" id="endereco" name="endereco" required>
            </div>
            <div class="form-group">
                <label for="contacto">Contacto</label>
                <input type="text" class="form-control" id="contacto" name="contacto" required>
            </div>
            <button type="submit" class="btn btn-primary">Adicionar</button>
        </form>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
