package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.RealizaDao;
import model.Realiza;

public final class editarRealiza_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Editar Realização</title>\n");
      out.write("    <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container-sm\">\n");
      out.write("        <form action=\"EditarRealizaServlet\" method=\"post\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                ");

                int nrmatricula = Integer.parseInt(request.getParameter("ma"));
                int codigoAvaliacao = Integer.parseInt(request.getParameter("codigoA"));
                RealizaDao dao = new RealizaDao();
                Realiza realiza = dao.getRealiza(nrmatricula);
                
      out.write("\n");
      out.write("                <label for=\"nrmatricula\">Número de Matrícula</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"nrmatricula\" name=\"nrmatricula\" required value=\"");
      out.print( realiza.getEstudante().getNrmatricula());
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"codigoAvaliacao\">Código da Avaliação</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"codigoAvaliacao\" name=\"codigoAvaliacao\" required value=\"");
      out.print( realiza.getAvaliacao().getCodigoA() );
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"nota\">Nota</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"nota\" name=\"nota\" required value=\"");
      out.print( realiza.getNota() );
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary\">Atualizar</button>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
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
