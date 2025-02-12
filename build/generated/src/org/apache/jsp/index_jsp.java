package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Dashboard de Estudantes</title>\n");
      out.write("\n");
      out.write("        <!--        <link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("                <link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>-->\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                background-color: tomato;\n");
      out.write("                display: flex;\n");
      out.write("                align-items: center;\n");
      out.write("                justify-content: center;\n");
      out.write("                height: 100vh;\n");
      out.write("            }\n");
      out.write("            .btn-group-vertical .btn {\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #imgHeader {\n");
      out.write("                max-width: 100%; \n");
      out.write("                height: auto;    \n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <img src=\"../src/java/iscim.png\" alt=\"\" id=\"imgHeader\">\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container text-center\">\n");
      out.write("            <div class=\"d-flex flex-column align-items-center\">\n");
      out.write("                <div class=\"btn-group-vertical\">\n");
      out.write("                    <!--<a href=\"formularioGeral.jsp\" class=\"btn btn-primary btn-lg\"> Adicionar dados </a>-->\n");
      out.write("                    <hr>\n");
      out.write("                    <a href=\"detalheEstudante.jsp\" class=\"btn btn-primary btn-lg\"> Estudantes </a>\n");
      out.write("                    <a href=\"detalheDisciplina.jsp\" class=\"btn btn-success btn-lg\">Disciplinas</a>\n");
      out.write("                    <a href=\"detalheAvaliacao.jsp\" class=\"btn btn-success btn-lg\">Avaliacoes</a>\n");
      out.write("                    <a href=\"detalheCurso.jsp\" class=\"btn btn-info btn-lg\">Cursos</a>\n");
      out.write("                    <a href=\"detalheRealiza.jsp\" class=\"btn btn-warning btn-lg\">Realizacoes</a>\n");
      out.write("                    <!--<a href=\"verDados.jsp\" class=\"btn btn-info btn-lg\">Ver todos os dados</a>-->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
