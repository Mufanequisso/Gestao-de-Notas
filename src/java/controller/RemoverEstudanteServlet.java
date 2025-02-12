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

/**
 *
 * @author Paulino
 */
@WebServlet(name = "RemoverEstudante", urlPatterns = {"/RemoverEstudante"})
public class RemoverEstudanteServlet extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
           
//        int id = Integer.parseInt(request.getParameter("id"));
//        
//       new  EsduanteDao().removeEstudante(id);
//       
//       response.sendRedirect("verDados.jsp");
//    }
//
////   
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
////        
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            EsduanteDao estudanteDao = new EsduanteDao();
            
            // Verifica se o estudante existe
            if (!estudanteDao.existsEstudante(id)) {
                request.setAttribute("errorMessage", "Estudante não encontrado.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }

            // Remove o estudante
            estudanteDao.removeEstudante(id);

            // Redireciona para a página de sucesso
            response.sendRedirect("detalheEstudante.jsp");

        } catch (NumberFormatException e) {
            // Trata a exceção se o ID não for um número válido
            request.setAttribute("errorMessage", "ID inválido.");
            request.getRequestDispatcher("error.jsp").forward(request, response);

        } catch (Exception e) {
            // Trata outras exceções
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao remover o estudante.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
        
    }

   