/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-04-18 13:26:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.content;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005furl_0026_005faction_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005furl_0026_005faction_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005furl_0026_005faction_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("</html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    <!-- Custom CSS -->\r\n");
      out.write("    <link href=\"../assets/css/grayscale.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("    <link href=\"../assets/css/app.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"../assets/css/custom.css\" rel=\"stylesheet\">\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- Main Style -->\r\n");
      out.write("<link href=\"../assets/css/main.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Supersized -->\r\n");
      out.write("<link href=\"../assets/css/supersized.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../assets/css/supersized.shutter.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<title>About</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body id=\"page-top\" data-spy=\"scroll\" data-target=\".navbar-fixed-top\">\r\n");
      out.write("\r\n");
      out.write("<!-- Navigation bar -->\r\n");
      out.write("<nav class=\"navbar navbar-custom navbar-fixed-top\" role=\"navigation\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Logo -->\r\n");
      out.write("        <div class=\"pull-left\">\r\n");
      out.write("            <a class=\"navbar-toggle\" href=\"#\" data-toggle=\"offcanvas\"><i class=\"ti-menu\"></i></a>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"logo-wrapper\">\r\n");
      out.write("                <a class=\"logo\" href=\"/\"><img src=\"../assets/img/logo.png\" alt=\"logo\"></a>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- END Logo -->\r\n");
      out.write("\r\n");
      out.write("        <!-- User account -->\r\n");
      out.write("        <div class=\"pull-right user-login\">\r\n");
      out.write("            <a class=\"btn btn-sm btn-primary\" href=\"");
      if (_jspx_meth_s_005furl_005f0(_jspx_page_context))
        return;
      out.write("\">Login</a> or <a href=\"");
      if (_jspx_meth_s_005furl_005f1(_jspx_page_context))
        return;
      out.write("\">register</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- END User account -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Navigation menu -->\r\n");
      out.write("        <ul class=\"nav-menu\">\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"/\">Home</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"#\">Position</a>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a>Browse jobs</a></li>\r\n");
      out.write("                    <li><a>Job detail</a></li>\r\n");
      out.write("                    <li><a>Post a job</a></li>\r\n");
      out.write("                    <li><a>Manage jobs</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"#\">Resume</a>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a>Browse resumes</a></li>\r\n");
      out.write("                    <li><a>Resume detail</a></li>\r\n");
      out.write("                    <li><a>Create a resume</a></li>\r\n");
      out.write("                    <li><a>Manage resumes</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"#\">Company</a>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a>Browse companies</a></li>\r\n");
      out.write("                    <li><a>Company detail</a></li>\r\n");
      out.write("                    <li><a>Create a company</a></li>\r\n");
      out.write("                    <li><a>Manage companies</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a class=\"active\" href=\"#\">Pages</a>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href=\"about.jsp\">About</a></li>\r\n");
      out.write("                    <li><a href=\"contact.jsp\">Contact</a></li>\r\n");
      out.write("                    <li><a href=\"faq.jsp\">FAQ</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <!-- END Navigation menu -->\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<!-- END Navigation bar -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Site header -->\r\n");
      out.write("    <header class=\"site-header size-lg text-center\" style=\"background-image: url(../assets/img/bg-facts.jpg)\">\r\n");
      out.write("      <div class=\"container>\r\n");
      out.write("\t\t<div class=\"col-xs-12\">\r\n");
      out.write("\t\t\t<br><br>\r\n");
      out.write("\t\t\t<h1 class=\"text-center\">About us</h1>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </header>\r\n");
      out.write("    <!-- END Site header -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Main container -->\r\n");
      out.write("    <main>\r\n");
      out.write("      <!-- Team -->\r\n");
      out.write("      <section class=\"bg-alt\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("          <header class=\"section-header\">\r\n");
      out.write("            <span>Who we are</span>\r\n");
      out.write("            <h2>Our team</h2>\r\n");
      out.write("            <h6>Currently, we're three geek and will grow up soon</h6>\r\n");
      out.write("          </header>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  \r\n");
      out.write("\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("          <!-- Team member -->\r\n");
      out.write("          <div class=\"col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("            <div class=\"span4 profile\">\r\n");
      out.write("              <div class=\"image-wrap\">\r\n");
      out.write("                <div class=\"hover-wrap\">\r\n");
      out.write("                    <span class=\"overlay-img\"></span>\r\n");
      out.write("                    <span class=\"overlay-text-thumb\">Teamlead</span>\r\n");
      out.write("                </div>\r\n");
      out.write("                <img src=\"/assets/img/Egor.jpg\" alt=\"John Doe\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <h3 class=\"profile-name\">Shulga Egor</h3>\r\n");
      out.write("\t\t\t<p class=\"description\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac augue at erat. \r\n");
      out.write("            Praesent porta, purus eget sagittis imperdiet, nulla mi ullamcorper metus, id hendrerit metus diam vitae est. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.</p>\r\n");
      out.write("            <div class=\"social\">\r\n");
      out.write("            \t<ul class=\"social-icons\">\r\n");
      out.write("\t\t\t\t\t<li><a class=\"facebook\" href=\"#\"><i class=\"fa fa-facebook\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a class=\"linkedin\" href=\"#\"><i class=\"fa fa-linkedin\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a class=\"github\" href=\"#\"><i class=\"fa fa-github\"></i></a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- END Team member -->\r\n");
      out.write("\r\n");
      out.write("          <!-- Team member -->\r\n");
      out.write("          <div class=\"col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("            <div class=\"span4 profile\">\r\n");
      out.write("              <div class=\"image-wrap\">\r\n");
      out.write("                <div class=\"hover-wrap\">\r\n");
      out.write("                    <span class=\"overlay-img\"></span>\r\n");
      out.write("                    <span class=\"overlay-text-thumb\">QA Engeneer</span>\r\n");
      out.write("                </div>\r\n");
      out.write("                <img src=\"/assets/img/Luba.jpg\" alt=\"John Doe\">\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("            <h3 class=\"profile-name\">Belousova Lubov</h3>\r\n");
      out.write("\t\t\t<p class=\"description\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac augue at erat. \r\n");
      out.write("            Praesent porta, purus eget sagittis imperdiet, nulla mi ullamcorper metus, id hendrerit metus diam vitae est. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.</p>\r\n");
      out.write("            <div class=\"social\">\r\n");
      out.write("            \t<ul class=\"social-icons\">\r\n");
      out.write("\t\t\t\t\t<li><a class=\"facebook\" href=\"#\"><i class=\"fa fa-facebook\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a class=\"github\" href=\"#\"><i class=\"fa fa-github\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a class=\"instagram\" href=\"#\"><i class=\"fa fa-instagram\"></i></a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- END Team member -->\r\n");
      out.write("\r\n");
      out.write("          <!-- Team member -->\r\n");
      out.write("          <div class=\"col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("            <div class=\"span4 profile\">\r\n");
      out.write("              <div class=\"image-wrap\">\r\n");
      out.write("                <div class=\"hover-wrap\">\r\n");
      out.write("                    <span class=\"overlay-img\"></span>\r\n");
      out.write("                    <span class=\"overlay-text-thumb\">Designer</span>\r\n");
      out.write("                </div>\r\n");
      out.write("                <img src=\"/assets/img/Kirill.jpg\" alt=\"John Doe\">\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("            <h3 class=\"profile-name\">Korolko Kirill</h3>\r\n");
      out.write("\t\t\t  <p class=\"description\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac augue at erat. \r\n");
      out.write("\t\t\t\tPraesent porta, purus eget sagittis imperdiet, nulla mi ullamcorper metus, id hendrerit metus diam vitae est. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.</p>\r\n");
      out.write("\t\t\t\t<div class=\"social\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"social-icons\">\r\n");
      out.write("\t\t\t\t\t<li><a class=\"facebook\" href=\"#\"><i class=\"fa fa-facebook\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a class=\"github\" href=\"#\"><i class=\"fa fa-github\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a class=\"instagram\" href=\"#\"><i class=\"fa fa-instagram\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t </ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- END Team member -->\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("      </section>\r\n");
      out.write("      <!-- END Team -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </main>\r\n");
      out.write("    <!-- END Main container -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <!-- Site footer -->\r\n");
      out.write("\t<footer class=\"site-footer\">\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Top section -->\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-12 col-md-6\">\r\n");
      out.write("\t\t\t\t\t<h6>About</h6>\r\n");
      out.write("\t\t\t\t\t<p class=\"text-justify\">An employment website is a web site that deals specifically with employment or careers. Many employment websites are designed to allow employers to post job requirements for a position to be filled and are commonly known as job boards. Other employment sites offer employer reviews, career and job-search advice, and describe different job descriptions or employers. Through a job website a prospective employee can locate and fill out a job application.</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"col-xs-6 col-md-3\">\r\n");
      out.write("\t\t\t\t\t<h6>Company</h6>\r\n");
      out.write("\t\t\t\t\t<ul class=\"footer-links\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"about.jsp\">About us</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"faq.jsp\">Help center</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"contact.jsp\">Contact us</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<hr>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- END Top section -->\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Bottom section -->\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-md-8 col-sm-6 col-xs-12\">\r\n");
      out.write("\t\t\t\t\t<p class=\"copyright-text\">2016 Belousova Lubov, Korolko Kirill, Shulga Egor.</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"col-md-4 col-sm-6 col-xs-12\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"social-icons\">\r\n");
      out.write("\t\t\t\t\t\t<li><a class=\"facebook\" href=\"#\"><i class=\"fa fa-facebook\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=\"twitter\" href=\"#\"><i class=\"fa fa-twitter\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=\"dribbble\" href=\"#\"><i class=\"fa fa-dribbble\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=\"linkedin\" href=\"#\"><i class=\"fa fa-linkedin\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=\"instagram\" href=\"#\"><i class=\"fa fa-instagram\"></i></a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- END Bottom section -->\r\n");
      out.write("\r\n");
      out.write("</footer>\r\n");
      out.write("<!-- END Site footer -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Back to top button -->\r\n");
      out.write("    <a id=\"scroll-up\" href=\"#\"><i class=\"ti-angle-up\"></i></a>\r\n");
      out.write("    <!-- END Back to top button -->\r\n");
      out.write("\r\n");
      out.write("<!-- Scripts -->\r\n");
      out.write("<script src=\"../assets/js/app.min.js\"></script>\r\n");
      out.write("<script src=\"../assets/js/custom.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Include all compiled plugins (below), or include individual files as needed -->\r\n");
      out.write("<script src=\"../assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom Theme JavaScript -->\r\n");
      out.write("    <script src=\"../assets/js/grayscale.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_s_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f0 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005faction_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f0.setParent(null);
    // /content/about.jsp(51,52) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f0.setAction("loginInquire");
    int _jspx_eval_s_005furl_005f0 = _jspx_th_s_005furl_005f0.doStartTag();
    if (_jspx_th_s_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f1 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005faction_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f1.setParent(null);
    // /content/about.jsp(51,106) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f1.setAction("signInInquire");
    int _jspx_eval_s_005furl_005f1 = _jspx_th_s_005furl_005f1.doStartTag();
    if (_jspx_th_s_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005faction_005fnobody.reuse(_jspx_th_s_005furl_005f1);
    return false;
  }
}
