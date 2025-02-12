/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CursoDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Curso;

@WebServlet("/RemoverCursoServlet")
public class RemoverCursoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Captura os parâmetros do request
            int codCurso = Integer.parseInt(request.getParameter("cc"));

            // Verifica se o curso existe no banco de dados
            CursoDao cursoDao = new CursoDao();
            Curso curso = new Curso();
            curso.setCodCurso(codCurso);
            if (curso == null) {
                request.setAttribute("errorMessage", "Curso não encontrado.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }

            // Remove o curso do banco de dados
            cursoDao.removeCurso(codCurso);

            // Redireciona para a página de sucesso
            response.sendRedirect("detalheCurso.jsp");

        } catch (NumberFormatException e) {
            // Trata a exceção se o valor de 'codCurso' não for um número válido
            request.setAttribute("errorMessage", "Código do curso inválido.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (Exception e) {
            // Trata outras exceções
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao remover o curso.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

   
}
