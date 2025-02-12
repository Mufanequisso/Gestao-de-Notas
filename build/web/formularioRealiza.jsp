<%-- 
    Document   : formularioRealiza
    Created on : Jun 5, 2024, 9:51:55 PM
    Author     : Paulino
--%>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Formulário de Realização</title>
</head>
<body>
    <div class="container mt-5">
        
        <a href="detalheRealiza.jsp" class="btn btn-primary">Voltar</a>
    

        <h2>Adicionar Realização</h2>
        <form action="FormularioServlet" method="post">
            <div class="form-group">
                <label for="nrmatricula">Número de Matrícula</label>
                <input type="number" class="form-control" id="nrmatricula" name="nrmatricula" required>
            </div>
            <div class="form-group">
                <label for="codigoAvaliacao">Código da Avaliação</label>
                <input type="number" class="form-control" id="codigoAvaliacao" name="codigoAvaliacao" required>
            </div>
            <div class="form-group">
                <label for="nota">Nota</label>
                <input type="number" class="form-control" id="nota" name="nota" required>
            </div>
            <button type="submit" class="btn btn-primary">Adicionar</button>
        </form>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
