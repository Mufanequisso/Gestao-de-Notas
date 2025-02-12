/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DisciplinaDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Disciplina;

@WebServlet("/RemoverDisciplinaServlet")
public class RemoverDisciplinaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Captura os parâmetros do request
            int codD = Integer.parseInt(request.getParameter("cod"));

            // Verifica se a disciplina existe no banco de dados
            DisciplinaDao disciplinaDao = new DisciplinaDao();
            Disciplina disciplina = disciplinaDao.getDisciplina(codD);
            if (disciplina == null) {
                request.setAttribute("errorMessage", "Disciplina não encontrada.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }

            // Remove a disciplina do banco de dados
            disciplinaDao.removeDisciplina(codD);

            // Redireciona para a página de sucesso
            response.sendRedirect("detalheDisciplina.jsp");

        } catch (NumberFormatException e) {
            // Trata a exceção se o valor de 'codD' não for um número válido
            request.setAttribute("errorMessage", "Código da disciplina inválido.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (Exception e) {
            // Trata outras exceções
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao remover a disciplina.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

   
}

 