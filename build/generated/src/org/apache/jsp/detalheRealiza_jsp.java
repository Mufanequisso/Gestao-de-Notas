package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import dao.RealizaDao;
import model.Realiza;
import model.Estudante;
import model.Avaliacao;

public final class detalheRealiza_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <title>Tabela Realiza</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container mt-5\">\n");
      out.write("        <h2 class=\"mb-4\">Dados de Realiza</h2>\n");
      out.write("        <table class=\"table table-bordered table-striped\">\n");
      out.write("            <thead class=\"thead-dark\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Número de Matrícula</th>\n");
      out.write("                    <th>Código da Avaliação</th>\n");
      out.write("                    <th>Nota</th>\n");
      out.write("                    <th>Ações</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    RealizaDao realizaDao = new RealizaDao();
                    List<Realiza> realizas = realizaDao.getAllRealiza();
                    
                    for (Realiza realiza : realizas) {
                        Estudante estudante = realiza.getEstudante();
                        Avaliacao avaliacao = realiza.getAvaliacao();
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( estudante.getNrmatricula() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( avaliacao.getCodigoA() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( realiza.getNota() );
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"editarRealiza.jsp?ma=");
      out.print( estudante.getNrmatricula() );
      out.write("&codigoA=");
      out.print( avaliacao.getCodigoA() );
      out.write("\" class=\"btn btn-warning btn-sm\">Editar</a>\n");
      out.write("                        <a href=\"RemoverRealizaServlet.jsp?nrmatricula=");
      out.print( estudante.getNrmatricula() );
      out.write("&codigoA=");
      out.print( avaliacao.getCodigoA() );
      out.write("\" class=\"btn btn-danger btn-sm\">Remover</a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
