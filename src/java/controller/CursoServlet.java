/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CursoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;

/**
 *
 * @author Paulino
 */
@WebServlet(name = "CursoServlet", urlPatterns = {"/CursoServlet"})
public class CursoServlet extends HttpServlet {

  
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            // Obter parâmetros do formulário
            String codCursoString = request.getParameter("codCurso");
            String nomeCurso = request.getParameter("nomeCurso");

            // Verificação dos parâmetros
            if (codCursoString == null || codCursoString.isEmpty() ||
                nomeCurso == null || nomeCurso.isEmpty()) {
                throw new IllegalArgumentException("Todos os campos são obrigatórios.");
            }

            int codCurso = Integer.parseInt(codCursoString);

            // Verificar se o curso já existe
            CursoDao cursoDao = new CursoDao();
            if (cursoDao.existsCurso(codCurso)) {
                throw new IllegalArgumentException("Um curso com esse código já existe.");
            }

            // Criar novo curso
            Curso curso = new Curso();
            curso.setCodCurso(codCurso);
            curso.setNome(nomeCurso);

            // Salvar curso no banco de dados
            cursoDao.addCurso(curso);

            // Redirecionar para a página de sucesso
            response.sendRedirect("detalheCurso.jsp");

        } catch (NumberFormatException e) {
            // Trata exceção de formato de número inválido
            request.setAttribute("errorMessage", "Código do curso inválido.");
            request.getRequestDispatcher("error.jsp").forward(request, response);

        } catch (IllegalArgumentException e) {
            // Trata exceção de argumentos inválidos
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);

        } catch (Exception e) {
            // Trata outras exceções
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao adicionar o curso.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
      
    }

