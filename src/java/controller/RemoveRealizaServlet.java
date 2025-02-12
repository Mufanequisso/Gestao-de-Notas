/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RealizaDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Realiza;
import model.RealizaId;

@WebServlet("/RemoveRealizaServlet")
public class RemoveRealizaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Captura os parâmetros do request
            int nrmatricula = Integer.parseInt(request.getParameter("nrmatricula"));
            int codigoAvaliacao = Integer.parseInt(request.getParameter("codigoAvaliacao"));

            // Cria uma instância de RealizaId e define os valores
            RealizaId realizaId = new RealizaId();
            realizaId.setNrmatricula(nrmatricula);
            realizaId.setCodigoA(codigoAvaliacao);

            // Verifica se a realização existe no banco de dados
            RealizaDao realizaDao = new RealizaDao();
            Realiza realiza = new Realiza();
            realiza.setId(realizaId);
            if (realiza == null) {
                request.setAttribute("errorMessage", "Realização não encontrada.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }

            // Remove a realização do banco de dados
            realizaDao.removeRealiza(realizaId);

            // Redireciona para a página de sucesso
            response.sendRedirect("detalheRealiza.jsp");

        } catch (NumberFormatException e) {
            // Trata a exceção se o valor de 'nrmatricula' ou 'codigoAvaliacao' não for um número válido
            request.setAttribute("errorMessage", "Número de matrícula ou código de avaliação inválido.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (Exception e) {
            // Trata outras exceções
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao remover a realização.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
