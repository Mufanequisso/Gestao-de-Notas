/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EsduanteDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Estudante;

/**
 *
 * @author Paulino
 */
@WebServlet(name = "EditarEstudanteServlet", urlPatterns = {"/EditarEstudanteServlet"})
public class EditarEstudanteServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//           throws ServletException, IOException {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("nrmatricula"));
            String nome = request.getParameter("nomeEstudante");
            String apelido = request.getParameter("apelido");
            String endereco = request.getParameter("endereco");
            String contacto = request.getParameter("contacto");

            EsduanteDao estudanteDao = new EsduanteDao();

            // Verifica se o estudante existe
            if (!estudanteDao.existsEstudante(id)) {
                request.setAttribute("errorMessage", "Estudante não encontrado.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }

            // Atualiza os dados do estudante
            
            Estudante estudante = new Estudante();
            estudante.setNrmatricula(id);
            estudante.setNome(nome);
            estudante.setApelido(apelido);
            estudante.setEndereco(endereco);
            estudante.setContacto(contacto);

            estudanteDao.updateEstudante(estudante);

            // Redireciona para a página de sucesso
            response.sendRedirect("detalheEstudante.jsp");

        } catch (NumberFormatException e) {
            // Trata a exceção se o ID não for um número válido
            request.setAttribute("errorMessage", "Matrícula inválida.");
            request.getRequestDispatcher("error.jsp").forward(request, response);

        } catch (Exception e) {
            // Trata outras exceções
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao atualizar o estudante.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

}
