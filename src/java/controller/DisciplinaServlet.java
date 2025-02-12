/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CursoDao;
import dao.DisciplinaDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;
import model.Disciplina;

/**
 *
 * @author Paulino
 */
@WebServlet(name = "DisciplinaServlet", urlPatterns = {"/DisciplinaServlet"})
public class DisciplinaServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperar os parâmetros do formulário
        int codD = Integer.parseInt(request.getParameter("codDisciplina"));
        String nome = request.getParameter("nomeDisciplina");
        int credito = Integer.parseInt(request.getParameter("credito"));
        int ch = Integer.parseInt(request.getParameter("ch"));
        int codCurso = Integer.parseInt(request.getParameter("codCursoDisciplina"));
        
        // Verificar se o curso existe (você precisa implementar o método existeCurso na sua classe CursoDao)
        CursoDao cursoDao = new CursoDao();
        if (!cursoDao.existsCurso(codCurso)) {
            // Redirecionar de volta com uma mensagem de erro
             request.setAttribute("errorMessage", "codigo nao encontrado.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            
        }
        
        // Criar um objeto Disciplina com os dados recebidos
        Disciplina disciplina = new Disciplina();
        disciplina.setCodD(codD);
        disciplina.setNome(nome);
        disciplina.setCh(ch);
        disciplina.setCredito(credito);
        
        Curso curso = new Curso();
        curso.setCodCurso(codCurso);
        disciplina.setCurso(curso);
        // Adicionar a disciplina no banco de dados
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        disciplinaDao.addDisciplina(disciplina);
        
        // Redirecionar para a página de sucesso
        response.sendRedirect("detalheDisciplina.jsp");
    }
}
