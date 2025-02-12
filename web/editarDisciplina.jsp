<%-- 
    Document   : editarDisciplina
    Created on : Jun 5, 2024, 8:16:07 PM
    Author     : Paulino
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.DisciplinaDao"%>
<%@ page import="model.Disciplina"%>
<%@ page import="model.Curso"%>
<%@ page import="dao.CursoDao"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Disciplina</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container-sm">
        <form action="EditarDisciplinaServlet" method="post">
            <div class="form-group">
                <%
                int codDisciplina=Integer.parseInt(request.getParameter("cod"));
//                int codCurso=Integer.parseInt(request.getParameter("cod"));
                DisciplinaDao dao = new DisciplinaDao();
                Disciplina disciplina1 = dao.getDisciplina(codDisciplina);
                %>
                <label for="codDisciplina">Código da Disciplina</label>
                <input type="text" class="form-control" id="codDisciplina" name="codD" required value="<%=disciplina1.getCodD()%>">
            </div>
            <div class="form-group">
                <label for="nomeDisciplina">Nome da Disciplina</label>
                <input type="text" class="form-control" id="nomeDisciplina" name="nome" required value="<%=disciplina1.getNome()%>">
            </div>
            <div class="form-group">
                <label for="credito">Crédito</label>
                <input type="text" class="form-control" id="credito" name="credito" required value="<%=disciplina1.getCredito()%>">
            </div>
            <div class="form-group">
                <label for="ch">Carga Horária</label>
                <input type="text" class="form-control" id="ch" name="ch" required value="<%=disciplina1.getCh()%>">
            </div>
            <div class="form-group">
                <label for="codCursoDisciplina">Código do Curso (Disciplina)</label>
                <input type="text" class="form-control" id="codCursoDisciplina" name="codCurso" required value="<%= disciplina1.getCurso().getCodCurso()%>">
            </div>
            <button type="submit" class="btn btn-primary">Atualizar</button>
        </form>
    </div>
</body>
</html>
