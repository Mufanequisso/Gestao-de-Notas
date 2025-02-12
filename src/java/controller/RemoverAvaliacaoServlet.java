/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AvaliacaoDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Avaliacao;

@WebServlet("/RemoverAvaliacaoServlet")
public class RemoverAvaliacaoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Captura os parâmetros do request
            int codigoAvaliacao = Integer.parseInt(request.getParameter("codigoA"));

            // Verifica se a avaliação existe no banco de dados
            AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setCodigoA(codigoAvaliacao);
            if (avaliacao == null) {
                request.setAttribute("errorMessage", "Avaliação não encontrada.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }

            // Remove a avaliação do banco de dados
            avaliacaoDao.removeAvaliacao(codigoAvaliacao);

            // Redireciona para a página de sucesso
            response.sendRedirect("detalheAvaliacao.jsp");

        } catch (NumberFormatException e) {
            // Trata a exceção se o valor de 'codigoAvaliacao' não for um número válido
            request.setAttribute("errorMessage", "Código de avaliação inválido.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (Exception e) {
            // Trata outras exceções
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao remover a avaliação.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
