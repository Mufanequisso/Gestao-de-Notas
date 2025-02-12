/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EsduanteDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Estudante;
@WebServlet("/EstudanteServlet")
public class EstudanteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperar os parâmetros do formulário
        int nrMatricula = Integer.parseInt(request.getParameter("nrmatricula"));
        String nome = request.getParameter("nomeEstudante");
        String apelido = request.getParameter("apelido");
        String endereco = request.getParameter("endereco");
        String contacto = request.getParameter("contacto");
        
        // Verificar se o estudante já existe
        EsduanteDao estudanteDao = new EsduanteDao ();
        if (estudanteDao.existsEstudante(nrMatricula)) {
            // Redirecionar de volta com uma mensagem de erro
           request.setAttribute("errorMessage", "A matricula ja existe.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
        
        // Criar um objeto Estudante com os dados recebidos
        Estudante estudante = new Estudante();
        estudante.setNrmatricula(nrMatricula);
        estudante.setNome(nome);
        estudante.setContacto(contacto);
        estudante.setEndereco(endereco);
        estudante.setApelido(apelido);
        
        // Adicionar o estudante no banco de dados
        estudanteDao.addEstudante(estudante);
        
        // Redirecionar para a página de sucesso
        response.sendRedirect("detalheEstudante.jsp");
    }
}
