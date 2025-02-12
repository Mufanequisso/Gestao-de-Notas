<%-- 
    Document   : formularioDisciplina
    Created on : Jun 6, 2024, 1:45:39 AM
    Author     : Paulino
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Disciplina</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
     <style>
            body{

                background-color:aliceblue;
            }
        </style>
</head>
<body>
    <div class="container">
        <a href="detalheDisciplina.jsp" class="btn btn-primary">Voltar</a>
        <h2>Adicionar Disciplina</h2>
        <form action="DisciplinaServlet" method="post">
            <div class="form-group">
                <label for="codDisciplina">Código da Disciplina:</label>
                <input type="number" class="form-control" id="codDisciplina" name="codDisciplina" required>
            </div>
            <div class="form-group">
                <label for="nomeDisciplina">Nome da Disciplina:</label>
                <input type="text" class="form-control" id="nomeDisciplina" name="nomeDisciplina" required>
            </div>
            <div class="form-group">
                <label for="credito">Crédito:</label>
                <input type="number" class="form-control" id="credito" name="credito" required>
            </div>
            <div class="form-group">
                <label for="ch">Carga Horária:</label>
                <input type="text" class="form-control" id="ch" name="ch" required>
            </div>
            <div class="form-group">
                <label for="codCursoDisciplina">Código do Curso:</label>
                <input type="text" class="form-control" id="codCursoDisciplina" name="codCursoDisciplina" required>
            </div>
            <button type="submit" class="btn btn-primary">Adicionar</button>
            <a href="verDados.jsp" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>
