<%-- 
    Document   : seeing
    Created on : Jun 3, 2024, 5:51:53 PM
    Author     : Paulino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Formulário de Dados</title>
    <style>
        .step { display: none; }
        .step.active { display: block; }
    </style>
</head>
<body>
    <div class="container mt-5">
        <a class="btn btn-primary" href="index.jsp">Pagina Inicial</a>
        <h2>Adicionar Dados</h2>
        <form id="multiStepForm" action="FormularioGeral1" method="post">
            
            <!-- Curso -->
            <div class="step active">
                <h4>Curso</h4>
                <div class="form-group">
                    <label for="codCurso">Código do Curso</label>
                    <input type="number" class="form-control" id="codCurso" name="codCurso" required>
                </div>
                <div class="form-group">
                    <label for="nomeCurso">Nome do Curso</label>
                    <input type="text" class="form-control" id="nomeCurso" name="nomeCurso">
                </div>
                <button type="button" class="btn btn-primary next">Próximo</button>
            </div>
            
            <!-- Disciplina -->
            <div class="step">
                <h4>Disciplina</h4>
                <div class="form-group">
                    <label for="codDisciplina">Código da Disciplina</label>
                    <input type="number" class="form-control" id="codDisciplina" name="codDisciplina" required>
                </div>
                <div class="form-group">
                    <label for="nomeDisciplina">Nome da Disciplina</label>
                    <input type="text" class="form-control" id="nomeDisciplina" name="nomeDisciplina">
                </div>
                <div class="form-group">
                    <label for="credito">Crédito</label>
                    <input type="number" class="form-control" id="credito" name="credito">
                </div>
                <div class="form-group">
                    <label for="ch">Carga Horária</label>
                    <input type="number" class="form-control" id="ch" name="ch">
                </div>
<!--                <div class="form-group">
                    <label for="codCursoDisciplina">Código do Curso (Disciplina)</label>
                    <input type="number" class="form-control" id="codCursoDisciplina" name="codCursoDisciplina">
                </div>-->
                <button type="button" class="btn btn-secondary prev">Voltar</button>
                <button type="button" class="btn btn-primary next">Próximo</button>
            </div>
            
            <!-- Estudante -->
            <div class="step">
                <h4>Estudante</h4>
                <div class="form-group">
                    <label for="nrmatricula">Número de Matrícula</label>
                    <input type="number" class="form-control" id="nrmatricula" name="nrmatricula" required>
                </div>
                <div class="form-group">
                    <label for="nomeEstudante">Nome</label>
                    <input type="text" class="form-control" id="nomeEstudante" name="nomeEstudante">
                </div>
                <div class="form-group">
                    <label for="apelido">Apelido</label>
                    <input type="text" class="form-control" id="apelido" name="apelido">
                </div>
                <div class="form-group">
                    <label for="endereco">Endereço</label>
                    <input type="text" class="form-control" id="endereco" name="endereco">
                </div>
                <div class="form-group">
                    <label for="contacto">Contacto</label>
                    <input type="text" class="form-control" id="contacto" name="contacto">
                </div>
                <button type="button" class="btn btn-secondary prev">Voltar</button>
                <button type="button" class="btn btn-primary next">Próximo</button>
            </div>
            
            <!-- Avaliação -->
            <div class="step">
                <h4>Avaliação</h4>
                <div class="form-group">
                    <label for="codigoAvaliacao">Código da Avaliação</label>
                    <input type="number" class="form-control" id="codigoAvaliacao" name="codigoAvaliacao" required>
                </div>
                <div class="form-group">
                    <label for="descricaoAvaliacao">Descrição</label>
                    <input type="text" class="form-control" id="descricaoAvaliacao" name="descricaoAvaliacao">
                </div>
                <div class="form-group">
                    <label for="pesoAvaliacao">Peso</label>
                    <input type="number" class="form-control" id="pesoAvaliacao" name="pesoAvaliacao">
                </div>
                <button type="button" class="btn btn-secondary prev">Voltar</button>
                <button type="button" class="btn btn-primary next">Próximo</button>
            </div>
            
            <!-- Realiza -->
            <div class="step">
                <h4>Realiza</h4>
                <div class="form-group">
                    <label for="nrmatriculaRealiza">Número de Matrícula (Realiza)</label>
                    <input type="number" class="form-control" id="nrmatriculaRealiza" name="nrmatriculaRealiza" required>
                </div>
                <div class="form-group">
                    <label for="codigoAvaliacaoRealiza">Código da Avaliação (Realiza)</label>
                    <input type="number" class="form-control" id="codigoAvaliacaoRealiza" name="codigoAvaliacaoRealiza" required>
                </div>
                <div class="form-group">
                    <label for="notaRealiza">Nota</label>
                    <input type="number" class="form-control" id="notaRealiza" name="notaRealiza">
                </div>
                <button type="button" class="btn btn-secondary prev">Voltar</button>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </div>
            
        </form>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function(){
            var currentStep = 0;
            showStep(currentStep);

            $(".next").click(function(){
                if (currentStep < $(".step").length - 1) {
                    currentStep++;
                    showStep(currentStep);
                }
            });

            $(".prev").click(function(){
                if (currentStep > 0) {
                    currentStep--;
                    showStep(currentStep);
                }
            });

            function showStep(step) {
                $(".step").removeClass("active");
                $(".step").eq(step).addClass("active");
            }
        });
    </script>
</body>
</html>
