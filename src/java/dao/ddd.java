/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Curso;
import dao.CursoDao;
import dao.DisciplinaDao;
import dao.RealizaDao;
import model.Avaliacao;
import model.Disciplina;
import model.Estudante;
import model.Realiza;

/**
 *
 * @author Paulino
 */
public class ddd {
    
    public static void main(String[] args) {
        Curso curso = new Curso();
        Estudante estudante = new Estudante();
        estudante.setNrmatricula(21);
        Avaliacao avalicao = new Avaliacao();
        avalicao.setCodigoA(1);
        
        
      
       
        for (Disciplina di  : new DisciplinaDao().getAllDisciplinas()) {
            
            System.out.println("fff" + di.getCurso().getCodCurso());
            
        }
        Realiza rea = new Realiza();
        rea.setEstudante(estudante);
        rea.setAvaliacao(avalicao);
        rea.setNota(19);
        rea.setId(null);
        new RealizaDao().addRealiza(rea);
    }
    
}
