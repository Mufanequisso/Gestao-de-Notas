<%-- 
    Document   : EditarEstudante
    Created on : Jun 4, 2024, 1:46:07 AM
    Author     : Paulino
--%>

<%@page import="dao.EsduanteDao"%>
<%@page import="model.Estudante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container-sm">
        <form action="EditarEstudanteServlet" method="post">
            <div class="form-group">
                <%
             int matricula= Integer.parseInt(request.getParameter("id"));
             EsduanteDao dao = new EsduanteDao();
             
             Estudante s =dao.getEstudante(matricula);
                
                
                %>
                    <label for="nrmatricula" >Número de Matrícula </label>
                    <input type="text" class="form-control" id="nrmatricula" name="nrmatricula" required value="<%=s.getNrmatricula()%>" >
                </div>
                <div class="form-group">
                    <label for="nomeEstudante">Nome</label>
                    <input type="text" class="form-control" id="nomeEstudante" name="nomeEstudante" required value="<%=s.getNome()%>">
                </div>
                <div class="form-group">
                    <label for="apelido">Apelido</label>
                    <input type="text" class="form-control" id="apelido" name="apelido" value="<%=s.getApelido()%>">
                </div>
                <div class="form-group">
                    <label for="endereco">Endereço</label>
                    <input type="text" class="form-control" id="endereco" name="endereco" value="<%=s.getEndereco()%>">
                </div>
                <div class="form-group">
                    <label for="contacto">Contacto</label>
                    <input type="text" class="form-control" id="contacto" name="contacto" value="<%=s.getContacto()%>">
                </div>
            <div>
               <button type="submit" class="btn btn-primary">Actualizar</button>
                
            </div>
           
            
        </form>
           </div>     
    </body>
</html>
