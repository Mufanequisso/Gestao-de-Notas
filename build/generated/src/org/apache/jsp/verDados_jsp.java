package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Realiza;
import dao.RealizaDao;
import dao.CursoDao;
import model.Avaliacao;
import dao.AvaliacaoDao;
import java.util.List;
import model.Curso;
import dao.DisciplinaDao;
import dao.EsduanteDao;
import model.Estudante;
import model.Disciplina;

public final class verDados_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html lang=\"pt\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <title>Visualização de Dados</title>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("\n");
      out.write("                background-color:darkgrey;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container mt-5\">\n");
      out.write("            <h2>Dados Cadastrados</h2>\n");
      out.write("            <a class=\"btn btn-primary\" href=\"index.jsp\">Pagina Inicial</a>\n");
      out.write("\n");
      out.write("            <!-- Exemplo de Tabela para Estudante -->\n");
      out.write("            <h4>Estudantes</h4>\n");
      out.write("            <table class=\"table table-bordered\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Número de Matrícula</th>\n");
      out.write("                        <th>Nome</th>\n");
      out.write("                        <th>Apelido</th>\n");
      out.write("                        <th>Endereço</th>\n");
      out.write("                        <th>Contacto</th>\n");
      out.write("                        <th>Ações</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("\n");
      out.write("                    ");

                        EsduanteDao dao = new EsduanteDao();
                        for (Estudante obj : dao.getAllEstudante()) {

                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(obj.getNrmatricula());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(obj.getNome());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(obj.getApelido());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(obj.getEndereco());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(obj.getContacto());
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("\n");
      out.write("                            <a href=\"editarEstudante.jsp?id=");
      out.print(obj.getNrmatricula());
      out.write("\" class=\"btn btn-warning btn-sm\">Editar</a>\n");
      out.write("\n");
      out.write("                            <a href=\"removerEstudante?id=");
      out.print(obj.getNrmatricula());
      out.write("\" class=\"btn btn-danger btn-sm\">Remover</a>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        }

                    
      out.write("\n");
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <!--disciplinas-->\n");
      out.write("\n");
      out.write("        <div class=\"container mt-5\">\n");
      out.write("            <h2>Disciplinas</h2>\n");
      out.write("\n");
      out.write("            <table class=\"table table-bordered\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Código</th>\n");
      out.write("                        <th>Nome</th>\n");
      out.write("                        <th>Crédito</th>\n");
      out.write("                        <th>Carga Horária</th>\n");
      out.write("                        <th>Código do Curso</th>\n");
      out.write("                        <th>Ações</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");
  DisciplinaDao disciplinaDao =new DisciplinaDao();
                        List<Disciplina> disciplinas =disciplinaDao.getAllDisciplinas();
                        
                        for (Disciplina ob : disciplinas) {
                         
                         Curso curso = ob.getCurso();

                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(ob.getCodD());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(ob.getNome());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(ob.getCredito());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(ob.getCh());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(curso.getCodCurso());
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <a href=\"my.jsp\" class=\"btn btn-warning btn-sm\">Editar</a>\n");
      out.write("                            <a href=\"#\" class=\"btn btn-danger btn-sm\">Remover</a>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        }

                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("             \n");
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--curso-->\n");
      out.write("\n");
      out.write("        <div class=\"container mt-5\">\n");
      out.write("            <h2>Cursos</h2>\n");
      out.write("\n");
      out.write("            <table class=\"table table-bordered\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Código</th>\n");
      out.write("                        <th>Nome</th>\n");
      out.write("                        <th>Ações</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                     ");

                    CursoDao cursoDao = new CursoDao();
                    List<Curso> cursos = cursoDao.getAllCursos();
                    
                    for (Curso curso : cursos) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( curso.getCodCurso());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( curso.getNome());
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"editarCurso.jsp?cc=");
      out.print(curso.getCodCurso());
      out.write("\" class=\"btn btn-warning btn-sm\">Editar</a>\n");
      out.write("                        <a href=\"RemoverCursoServlet?cc=");
      out.print(curso.getCodCurso());
      out.write("\" class=\"btn btn-danger btn-sm\">Remover</a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--avaliacao-->\n");
      out.write("\n");
      out.write("        <div class=\"container mt-5\">\n");
      out.write("            <h2>Avaliações</h2>\n");
      out.write("\n");
      out.write("            <table class=\"table table-bordered\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Código</th>\n");
      out.write("                        <th>Descrição</th>\n");
      out.write("                        <th>Peso</th>\n");
      out.write("                        <th>Ações</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                    AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
                    List<Avaliacao> avaliacoes = avaliacaoDao.getAllavaliacao();
                    
                    for (Avaliacao avaliacao :  avaliacoes){
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( avaliacao.getCodigoA());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( avaliacao.getDescricao());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( avaliacao.getPeso());
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"editarAvaliacao.jsp?codigoA=");
      out.print(avaliacao.getCodigoA());
      out.write("\" class=\"btn btn-warning btn-sm\">Editar</a>\n");
      out.write("                        <a href=\"RemoverAvaliacaoServlet?codigoA=");
      out.print(avaliacao.getCodigoA());
      out.write("\" class=\"btn btn-danger btn-sm\">Remover</a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("                \n");
      out.write("                <!--avaliacao-->\n");
      out.write("\n");
      out.write("        <div class=\"container mt-5\">\n");
      out.write("            <h2>Avaliações</h2>\n");
      out.write("\n");
      out.write("            <table class=\"table table-bordered\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Código de matricula do studante</th>\n");
      out.write("                        <th>Codigo da Avalicao</th>\n");
      out.write("                        <th>Nota</th>\n");
      out.write("                        <th>Ações</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                   ");

                    RealizaDao realizaDao = new RealizaDao();
                    List<Realiza> realizas = realizaDao.getAllRealiza();
                    
                    for (Realiza realiza : realizas) {
                        Estudante estudante = realiza.getEstudante();
                        Avaliacao avaliacao = realiza.getAvaliacao();
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( estudante.getNrmatricula());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( avaliacao.getCodigoA());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( realiza.getNota());
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"editarRealiza.jsp?ma=");
      out.print(estudante.getNrmatricula());
      out.write("&codigoA=");
      out.print(avaliacao.getCodigoA() );
      out.write("\" class=\"btn btn-warning btn-sm\">Editar</a>\n");
      out.write("                        <a href=\"RemoveRealizaServlet?nrmatricula=");
      out.print(estudante.getNrmatricula());
      out.write("&codigoA=");
      out.print(avaliacao.getCodigoA());
      out.write("\" class=\"btn btn-danger btn-sm\">Remover</a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("                \n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
