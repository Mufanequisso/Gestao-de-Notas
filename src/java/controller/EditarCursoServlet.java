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
@WebServlet(name = "EditarCursoServlet", urlPatterns = {"/EditarCursoServlet"})
public class EditarCursoServlet extends HttpServlet {

     private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
   

  
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
     try {
            // Obter parâmetros do formulário
            int codCurso = Integer.parseInt(request.getParameter("cc"));
            String nomeCurso = request.getParameter("nome");

          
            // Verificar se o curso existe
            CursoDao cursoDao = new CursoDao();
            if (!cursoDao.existsCurso(codCurso)) {
                throw new IllegalArgumentException("Curso não encontrado.");
            }

            // Obter o curso a ser editado
            
            Curso curso = new Curso();
            curso.setCodCurso(codCurso);
            curso.setNome(nomeCurso);

            // Atualizar o curso no banco de dados
            cursoDao.updateCurso(curso);

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
            request.setAttribute("errorMessage", "Ocorreu um erro ao editar o curso.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
  
}
