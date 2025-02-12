/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;



/**
 *
 * @author Paulino
 */

import dao.CursoDao;
import dao.DisciplinaDao;
    import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;
import model.Disciplina;

@WebServlet("/EditarDisciplinaServlet")
public class EditarDisciplinaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Recebe os dados do formulário de editar Disciplina
            int codD = Integer.parseInt(request.getParameter("codD"));
            String nome = request.getParameter("nome");
            int credito = Integer.parseInt(request.getParameter("credito"));
            int ch = Integer.parseInt(request.getParameter("ch"));
            int codCurso = Integer.parseInt(request.getParameter("codCurso"));

            DisciplinaDao disciplinaDao = new DisciplinaDao();
            CursoDao cursoDao = new CursoDao();
            

            // Verifica se a disciplina existe
            if (!disciplinaDao.existsDisciplina(codD)) {
                request.setAttribute("errorMessage", "Disciplina não encontrada.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }

            // Verifica se o curso existe
            if (!cursoDao.existsCurso(codCurso)) {
                request.setAttribute("errorMessage", "Curso não encontrado.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }
            
            

            // Atualiza a disciplina e o Codigo do curso 
            // NB: o codigo do curso deve existir na base de dados. se manter o mesmo codigo, a disciplina sera actulizada
            // NB: se mudar do codigo sabendo que existe na base de dados, o dados da disciplina serao actualizados
           
            Curso curso = new Curso();
           curso.setCodCurso(codCurso);
            Disciplina disciplina = new Disciplina();
            disciplina.setCodD(codD);
            disciplina.setNome(nome);
            disciplina.setCredito(credito);
            disciplina.setCh(ch);
            disciplina.setCurso(curso);

            disciplinaDao.updateDisciplina(disciplina);

            // Redireciona para a página de sucesso
            response.sendRedirect("detalheDisciplina.jsp");

        } catch (NumberFormatException e) {
            // Trata a exceção se o código ou o crédito não for um número válido
            request.setAttribute("errorMessage", "Código, crédito ou carga horária inválido.");
            request.getRequestDispatcher("error.jsp").forward(request, response);

        } catch (Exception e) {
            // Trata outras exceções
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro ao atualizar a disciplina.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}


   

