package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class formularioRealiza_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <title>Formulário de Realização</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container mt-5\">\n");
      out.write("         <div class=\"container mt-5\">\n");
      out.write("        <div class=\"alert alert-danger\" role=\"alert\">\n");
      out.write("            ");
      out.print( request.getAttribute("errorMessage") );
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <a href=\"formulario.jsp\" class=\"btn btn-primary\">Voltar</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("        <h2>Adicionar Realização</h2>\n");
      out.write("        <form action=\"FormularioServlet\" method=\"post\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"nrmatricula\">Número de Matrícula</label>\n");
      out.write("                <input type=\"number\" class=\"form-control\" id=\"nrmatricula\" name=\"nrmatricula\" required>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"codigoAvaliacao\">Código da Avaliação</label>\n");
      out.write("                <input type=\"number\" class=\"form-control\" id=\"codigoAvaliacao\" name=\"codigoAvaliacao\" required>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"nota\">Nota</label>\n");
      out.write("                <input type=\"number\" class=\"form-control\" id=\"nota\" name=\"nota\" required>\n");
      out.write("            </div>\n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary\">Adicionar</button>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("</body>\n");
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
