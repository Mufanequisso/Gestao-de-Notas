/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AvaliacaoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Avaliacao;
import model.Estudante;

/**
 *
 * @author Paulino
 */
@WebServlet(name = "EditarAvaliacaoServlet", urlPatterns = {"/EditarAvaliacaoServlet"})
public class EditarAvaliacaoServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;
   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    
        try {
            int codigoA = Integer.parseInt(request.getParameter("codigoA"));
            String descricao = request.getParameter("descricao");
            int peso = Integer.parseInt(request.getParameter("peso"));

            AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
 // Verifica se o estudante existe
            if (!avaliacaoDao.existsAvaliacao(codigoA)) {
                request.setAttribute("errorMessage", "Avaliacao não encontrado.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }

            // Atualiza os dados do Avaliacao
            
            Avaliacao avaliacao = new Avaliacao();
            
            avaliacao.setCodigoA(codigoA);
            avaliacao.setDescricao(descricao);
            avaliacao.setPeso(peso);
            avaliacaoDao.updateAvaliacao(avaliacao);
            // Redireciona para a página de sucesso
            response.sendRedirect("detalheAvaliacao.jsp");

        } catch (NumberFormatException e) {
            // Trata a exceção se o ID não for um número válido
            request.setAttribute("errorMessage", "codigo inválido.");
            request.getRequestDispatcher("error.jsp").forward(request, response);

        } catch (Exception e) {
            // Trata outras exceções
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao atualizar a avaliacao.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

   

}
