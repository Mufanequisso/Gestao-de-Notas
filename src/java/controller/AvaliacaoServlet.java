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

/**
 *
 * @author Paulino
 */
@WebServlet(name = "AvaliacaoServlet", urlPatterns = {"/AvaliacaoServlet"})
public class AvaliacaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            // Obter parâmetros do formulário
            String codigoAString = request.getParameter("codigoA");
            String descricao = request.getParameter("descricao");
            String pesoString = request.getParameter("peso");

            // Verificação dos parâmetros
            if (codigoAString == null || codigoAString.isEmpty() ||
                descricao == null || descricao.isEmpty() ||
                pesoString == null || pesoString.isEmpty()) {
                throw new IllegalArgumentException("Todos os campos são obrigatórios.");
            }

            int codigoA = Integer.parseInt(codigoAString);
            int peso = Integer.parseInt(pesoString);

            // Verificar se a avaliação já existe
            AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
            if (avaliacaoDao.existsAvaliacao(codigoA)) {
                throw new IllegalArgumentException("Uma avaliação com esse código já existe.");
            }

            // Criar nova avaliação
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setCodigoA(codigoA);
            avaliacao.setDescricao(descricao);
            avaliacao.setPeso(peso);

            // Salvar avaliação no banco de dados
            avaliacaoDao.addAvaliacao(avaliacao);

            // Redirecionar para a página de sucesso
            response.sendRedirect("detalheAvaliacao.jsp");

        } catch (NumberFormatException e) {
            // Trata exceção de formato de número inválido
            request.setAttribute("errorMessage", "Código ou peso inválido.");
            request.getRequestDispatcher("error.jsp").forward(request, response);

        } catch (IllegalArgumentException e) {
            // Trata exceção de argumentos inválidos
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);

        } catch (Exception e) {
            // Trata outras exceções
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao adicionar a avaliação.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    
        
    }

}
