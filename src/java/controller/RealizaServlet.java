/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AvaliacaoDao;
import dao.EsduanteDao;
import dao.RealizaDao;
import dao.RealizaIdDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Realiza;
import model.RealizaId;

/**
 *
 * @author Paulino
 */
@WebServlet(name = "FormularioServlet", urlPatterns = {"/FormularioServlet"})
public class RealizaServlet extends HttpServlet {
     private static final long serialVersionUID = 1L;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // busca dados vindo do formulario           
            int nrMatriculaRealiza = Integer.parseInt(request.getParameter("nrmatricula"));
            int codigoAvaliacaoRealiza = Integer.parseInt(request.getParameter("codigoAvaliacao"));
            int notaRealiza = Integer.parseInt(request.getParameter("nota"));

            EsduanteDao estudanteDao = new EsduanteDao();
            AvaliacaoDao avaliacaoDao = new AvaliacaoDao();

            // Verificar se o estudante e a avaliação existem na base de dados
            if (!estudanteDao.existsEstudante(nrMatriculaRealiza)) {
                request.setAttribute("errorMessage", "Número de matrícula não existe.");
                request.getRequestDispatcher("formularioRealiza.jsp").forward(request, response);
                return;
            }

            if (!avaliacaoDao.existsAvaliacao(codigoAvaliacaoRealiza)) {
                request.setAttribute("errorMessage", "Código de avaliação não existe.");
                request.getRequestDispatcher("formularioRealiza.jsp").forward(request, response);
                return;
            }

            // Criar a chave composta
            RealizaId realizaId = new RealizaId();
            realizaId.setNrmatricula(nrMatriculaRealiza);
            realizaId.setCodigoA(codigoAvaliacaoRealiza);

            // Verificar se a realização já existe
            RealizaDao realizaDao = new RealizaDao();
            if (realizaDao.existsRealiza(realizaId)) {
                request.setAttribute("errorMessage", "A realização com este número de matrícula e código de avaliação já existe.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }

            // Criar o objeto Realiza
            Realiza realiza = new Realiza();
            realiza.setId(realizaId);
            realiza.setNota(notaRealiza);

            // Adicionar ao banco de dados usando o DAO
            realizaDao.addRealiza(realiza);

            // Redirecionar ou enviar resposta ao cliente
            response.sendRedirect("detalheRealiza.jsp"); // ou qualquer página de sucesso

        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // ou qualquer página de erro
        }
    }
   

}
