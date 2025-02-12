<%--
    Document   : verDados
    Created on : Jun 3, 2024, 10:07:09 PM
    Author     : Paulino
--%>

<%@page import="model.Realiza"%>
<%@page import="dao.RealizaDao"%>
<%@page import="dao.CursoDao"%>
<%@page import="model.Avaliacao"%>
<%@page import="dao.AvaliacaoDao"%>
<%@page import="java.util.List"%>
<%@page import="model.Curso"%>
<%@page import="dao.DisciplinaDao"%>
<%@page import="dao.EsduanteDao"%>
<%@page import="model.Estudante"%>
<%@page import="model.Disciplina"%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>

<html lang="pt">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

        <title>Visualização de Dados</title>
        <style>
            body{

                background-color:aliceblue;
            }
        </style>
    </head>
    <body>






        <div class="container mt-5">
            <h2>Dados Cadastrados</h2>
            <a class="btn btn-primary" href="index.jsp">Pagina Inicial</a>

            <!-- Exemplo de Tabela para Estudante -->
            <h4>Estudantes</h4>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Número de Matrícula</th>
                        <th>Nome</th>
                        <th>Apelido</th>
                        <th>Endereço</th>
                        <th>Contacto</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        EsduanteDao dao = new EsduanteDao();
                        for (Estudante obj : dao.getAllEstudante()) {

                    %>
                    <tr>
                        <td><%=obj.getNrmatricula()%></td>
                        <td><%=obj.getNome()%></td>
                        <td><%=obj.getApelido()%></td>
                        <td><%=obj.getEndereco()%></td>
                        <td><%=obj.getContacto()%></td>
                        <td>

                            <a href="editarEstudante.jsp?id=<%=obj.getNrmatricula()%>" class="btn btn-warning btn-sm">Editar</a>

                            <a href="removerEstudante?id=<%=obj.getNrmatricula()%>" class="btn btn-danger btn-sm">Remover</a>
                        </td>
                    </tr>
                    <%
                        }

                    %>

                </tbody>
            </table>
        </div>
        <!--disciplinas-->

        <div class="container mt-5">
            <h2>Disciplinas</h2>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Crédito</th>
                        <th>Carga Horária</th>
                        <th>Código do Curso</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <%  DisciplinaDao disciplinaDao =new DisciplinaDao();
                        List<Disciplina> disciplinas =disciplinaDao.getAllDisciplinas();
                        
                        for (Disciplina ob : disciplinas) {
                         
                         Curso curso = ob.getCurso();

                    %>
                    <tr>
                        <td><%=ob.getCodD()%></td>
                        <td><%=ob.getNome()%></td>
                        <td><%=ob.getCredito()%></td>
                        <td><%=ob.getCh()%></td>
                        <td><%=curso.getCodCurso()%></td>
                        <td>
                            <a href="editarDisciplina.jsp?cod=<%= ob.getCodD()%>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="RemoverDisciplinaServlet?cod=<%= ob.getCodD()%>" class="btn btn-danger btn-sm">Remover</a>
                        </td>
                    </tr>
                    <%
                        }

                    %>


             

                </tbody>
            </table>
        </div>

        <!--curso-->

        <div class="container mt-5">
            <h2>Cursos</h2>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                     <%
                    CursoDao cursoDao = new CursoDao();
                    List<Curso> cursos = cursoDao.getAllCursos();
                    
                    for (Curso curso : cursos) {
                %>
                <tr>
                    <td><%= curso.getCodCurso()%></td>
                    <td><%= curso.getNome()%></td>
                    <td>
                        <a href="editarCurso.jsp?cc=<%=curso.getCodCurso()%>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="RemoverCursoServlet?cc=<%=curso.getCodCurso()%>" class="btn btn-danger btn-sm">Remover</a>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>

        <!--avaliacao-->

        <div class="container mt-5">
            <h2>Avaliações</h2>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Descrição</th>
                        <th>Peso</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
                    List<Avaliacao> avaliacoes = avaliacaoDao.getAllavaliacao();
                    
                    for (Avaliacao avaliacao :  avaliacoes){
                %>
                <tr>
                    <td><%= avaliacao.getCodigoA()%></td>
                    <td><%= avaliacao.getDescricao()%></td>
                    <td><%= avaliacao.getPeso()%></td>
                    <td>
                        <a href="editarAvaliacao.jsp?codigoA=<%=avaliacao.getCodigoA()%>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="RemoverAvaliacaoServlet?codigoA=<%=avaliacao.getCodigoA()%>" class="btn btn-danger btn-sm">Remover</a>
                    </td>
                </tr>
                <%
                    }
                %>

                </tbody>
            </table>
        </div>
                
                <!--avaliacao-->

        <div class="container mt-5">
            <h2>Avaliações</h2>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Código de matricula do studante</th>
                        <th>Codigo da Avalicao</th>
                        <th>Nota</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                   <%
                    RealizaDao realizaDao = new RealizaDao();
                    List<Realiza> realizas = realizaDao.getAllRealiza();
                    
                    for (Realiza realiza : realizas) {
                        Estudante estudante = realiza.getEstudante();
                        Avaliacao avaliacao = realiza.getAvaliacao();
                %>
                <tr>
                    <td><%= estudante.getNrmatricula()%></td>
                    <td><%= avaliacao.getCodigoA()%></td>
                    <td><%= realiza.getNota()%></td>
                    <td>
                        <a href="editarRealiza.jsp?ma=<%=estudante.getNrmatricula()%>&codigoA=<%=avaliacao.getCodigoA() %>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="RemoveRealizaServlet?nrmatricula=<%=estudante.getNrmatricula()%>&codigoA=<%=avaliacao.getCodigoA()%>" class="btn btn-danger btn-sm">Remover</a>
                    </td>
                </tr>
                <%
                    }
                %>
                
                </tbody>
            </table>
        </div>





        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


    </body>
</html>
