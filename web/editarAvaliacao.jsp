<%-- 
    Document   : editarAvaliacao
    Created on : Jun 5, 2024, 9:04:01 PM
    Author     : Paulino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="dao.AvaliacaoDao" %>
<%@ page import="model.Avaliacao"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Avaliação</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container-sm">
        <form action="EditarAvaliacaoServlet" method="post">
            <div class="form-group">
                <%
                int codigoAvaliacao = Integer.parseInt(request.getParameter("codigoA"));
                AvaliacaoDao dao = new AvaliacaoDao();
                Avaliacao avaliacao = dao.getAvaliacao(codigoAvaliacao);
                %>
                <label for="codigoAvaliacao">Código da Avaliação</label>
                <input type="text" class="form-control" id="codigoAvaliacao" name="codigoA" required value="<%= avaliacao.getCodigoA()%>">
            </div>
            <div class="form-group">
                <label for="descricaoAvaliacao">Descrição</label>
                <input type="text" class="form-control" id="descricaoAvaliacao" name="descricao" required value="<%= avaliacao.getDescricao()%>">
            </div>
            <div class="form-group">
                <label for="pesoAvaliacao">Peso</label>
                <input type="text" class="form-control" id="pesoAvaliacao" name="peso" required value="<%= avaliacao.getPeso()%>">
            </div>
            <button type="submit" class="btn btn-primary">Atualizar</button>
        </form>
    </div>
</body>
</html>
