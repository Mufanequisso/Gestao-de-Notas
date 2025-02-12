<%-- 
    Document   : Dashboard
    Created on : May 31, 2024, 7:12:12 PM
    Author     : Paulino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard de Estudantes</title>

        <!--        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
                <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>-->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                background-color: tomato;
                display: flex;
                align-items: center;
                justify-content: center;
                height: 100vh;
            }
            .btn-group-vertical .btn {
                margin-bottom: 10px;

            }

            #imgHeader {
                max-width: 100%; 
                height: auto;    
            }
        </style>
    </head>
    <body>
        <header>
            <img src="../src/java/iscim.png" alt="" id="imgHeader">
        </header>



        <div class="container text-center">
            <div class="d-flex flex-column align-items-center">
                <div class="btn-group-vertical">
                    <!--<a href="formularioGeral.jsp" class="btn btn-primary btn-lg"> Adicionar dados </a>-->
                    <hr>
                    <a href="detalheEstudante.jsp" class="btn btn-primary btn-lg"> Estudantes </a>
                    <a href="detalheDisciplina.jsp" class="btn btn-success btn-lg">Disciplinas</a>
                    <a href="detalheAvaliacao.jsp" class="btn btn-success btn-lg">Avaliacoes</a>
                    <a href="detalheCurso.jsp" class="btn btn-info btn-lg">Cursos</a>
                    <a href="detalheRealiza.jsp" class="btn btn-warning btn-lg">Realizacoes</a>
                    <!--<a href="verDados.jsp" class="btn btn-info btn-lg">Ver todos os dados</a>-->
                </div>
            </div>
        </div>
    </body>
</html>
