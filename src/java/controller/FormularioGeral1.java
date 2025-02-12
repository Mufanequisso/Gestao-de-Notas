/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AvaliacaoDao;
import dao.CursoDao;
import dao.DisciplinaDao;
import dao.EsduanteDao;
import dao.RealizaDao;
import dao.RealizaIdDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Avaliacao;
import model.Curso;
import model.Disciplina;
import model.Estudante;
import model.Realiza;
import model.RealizaId;

/**
 *
 * @author Paulino
 */
@WebServlet(name = "FormularioGeral1", urlPatterns = {"/FormularioGeral1"})
public class FormularioGeral1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
         
    }
        
        
        
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
            // Coletar dados do formulário
            // Curso
            int codCurso = Integer.parseInt(request.getParameter("codCurso"));
            String nomeCurso = request.getParameter("nomeCurso");
            
            Curso curso = new Curso();
            curso.setCodCurso(codCurso);
            curso.setNome(nomeCurso);
            new CursoDao().addCurso(curso);
            
            
              // Disciplina
            int codDisciplina = Integer.parseInt(request.getParameter("codDisciplina"));
            String nomeDisciplina = request.getParameter("nomeDisciplina");
            int credito = Integer.parseInt(request.getParameter("credito"));
            int ch = Integer.parseInt(request.getParameter("ch"));
//            int codCursoDisciplina = Integer.parseInt(request.getParameter("codCursoDisciplina"));
            
            Disciplina discipina = new Disciplina();
            discipina.setCodD(codDisciplina);
            discipina.setNome(nomeDisciplina);
            discipina.setCredito(credito);
            discipina.setCh(ch);
           discipina.setCurso(curso);
            
          new  DisciplinaDao().addDisciplina(discipina);
          
            // Estudante
            int nrMatricula = Integer.parseInt(request.getParameter("nrmatricula"));
            String nomeEstudante = request.getParameter("nomeEstudante");
            String apelido = request.getParameter("apelido");
            String endereco = request.getParameter("endereco");
            String contacto = request.getParameter("contacto");
            Estudante estudante = new Estudante();
            estudante.setNrmatricula(nrMatricula);
            estudante.setNome(nomeEstudante);
            estudante.setApelido(apelido);
            estudante.setContacto(contacto);
            estudante.setEndereco(endereco);
            
            new EsduanteDao().addEstudante(estudante);

            // Avaliação
            int codigoAvaliacao = Integer.parseInt(request.getParameter("codigoAvaliacao"));
            String descricaoAvaliacao = request.getParameter("descricaoAvaliacao");
            int pesoAvaliacao = Integer.parseInt(request.getParameter("pesoAvaliacao"));
            
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setCodigoA(codCurso);
            avaliacao.setDescricao(descricaoAvaliacao);
            avaliacao.setPeso(pesoAvaliacao);
            new AvaliacaoDao().addAvaliacao(avaliacao);

          

          
            // Realiza
            int nrMatriculaRealiza = Integer.parseInt(request.getParameter("nrmatriculaRealiza"));
            int codigoAvaliacaoRealiza = Integer.parseInt(request.getParameter("codigoAvaliacaoRealiza"));
            int notaRealiza = Integer.parseInt(request.getParameter("notaRealiza"));
            
            
            RealizaId realiza = new RealizaId();
            realiza.setCodigoA(codigoAvaliacaoRealiza);
            realiza.setNrmatricula(nrMatricula);
            
            Realiza realiza1 = new Realiza();
            realiza1.setId(realiza);
            realiza1.setNota(notaRealiza);

             new RealizaIdDao().addRealiza(realiza);
             
             new RealizaDao().addRealiza(realiza1);
             response.sendRedirect("verDados.jsp");
             
    }
  

    
}
