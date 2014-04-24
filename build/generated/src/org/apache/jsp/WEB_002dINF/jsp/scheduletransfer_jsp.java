package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class scheduletransfer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "stdhead.jsp", out, false);
      out.write("    \n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Titan Bank - Schedule Transfer</title>\n");
      out.write("</head>\n");
      out.write("<body class=\"contentBody\">\n");
      out.write("<div id=\"contentWrapper\">\n");
      out.write("<div class=\"content_2col_heading\">\n");
      out.write("    <h2>Schedule Transfer</h2>\n");
      out.write("</div>   \n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"transferBoxes\">\n");
      out.write("\n");
      out.write("<form action=\"updateTransfer\" methos=post\">\n");
      out.write("    \n");
      out.write("<div class=\"transferBox\">\n");
      out.write("    <div class=\"transferBoxTitle\">\n");
      out.write("        <span>Transfer From</span>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"transferBoxDetail\">\n");
      out.write("        <div id=\"transferBoxDetail_r1\">\n");
      out.write("            <div class=\"content_form_2col_r1\">\n");
      out.write("                <div class=\"content_form_2col_r1_c1\">\t\t\n");
      out.write("                    <label class=\"content_form_label\" for=\"userid\">Account: </label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"content_form_2col_r1_c2\" >\n");
      out.write("\t            <input type=\"text\" size=\"30\" name=\"account\" id=\"account\" />\n");
      out.write("\t        </div>\n");
      out.write("            </div>\n");
      out.write("         </div>\n");
      out.write("        <div id=\"transferBoxDetail_r2\">\n");
      out.write("            <div class=\"content_form_2col_r1\">\n");
      out.write("                <div class=\"content_form_2col_r1_c1\">\t\t\n");
      out.write("                    <label class=\"content_form_label\" for=\"userid\">Amount: </label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"content_form_2col_r1_c2\" >\n");
      out.write("\t            <input type=\"text\" size=\"30\" name=\"amount\" id=\"amount\" />\n");
      out.write("\t        </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"transferBox\">\n");
      out.write("    <div class=\"transferBoxTitle\">\n");
      out.write("        <span>Transfer To</span>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"transferBoxDetail\">\n");
      out.write("        <div id=\"transferBoxDetail_r1\">\n");
      out.write("            <div class=\"content_form_2col_r1\">\n");
      out.write("                <div class=\"content_form_2col_r1_c1\">\t\t\n");
      out.write("                    <label class=\"content_form_label\" for=\"userid\">Account: </label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"content_form_2col_r1_c2\" >\n");
      out.write("\t            <input type=\"text\" size=\"30\" name=\"account\" id=\"account\" />\n");
      out.write("\t        </div>\n");
      out.write("            </div>\n");
      out.write("         </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</div> <!-- End transferBoxes --> \n");
      out.write("\n");
      out.write("<div class=\"transferBox\">\n");
      out.write("    <div class=\"transferBoxTitle\">\n");
      out.write("        <span>Transfer Date</span>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"transferBoxDetail\">\n");
      out.write("        <div>\n");
      out.write("            <input type=\"checkbox\" name=\"transferimmediately\" value=\"transferimmediately\">Transfer Immediately \n");
      out.write("        </div>\n");
      out.write("        <div id=\"transferBoxDetail_r1\">\n");
      out.write("            <div class=\"content_form_2col_r1\">\n");
      out.write("                <div class=\"content_form_2col_r1_c1\">\t\t\n");
      out.write("                    <label class=\"content_form_label\" for=\"userid\">Date: </label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"content_form_2col_r1_c2\" >\n");
      out.write("\t            <input type=\"text\" size=\"30\" name=\"account\" id=\"account\" />\n");
      out.write("\t        </div>\n");
      out.write("            </div>\n");
      out.write("         </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<input name=\"transfer\" value=\"Transfer\" type=\"submit\" class=\"content_2col_submit\"/>\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("    \n");
      out.write("</div> <!-- End wrapper -->\n");
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
