<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <!-- Custom CSS -->
    <link href="../assets/css/grayscale.css" rel="stylesheet">


    <link href="../assets/css/app.min.css" rel="stylesheet">
    <link href="../assets/css/custom.css" rel="stylesheet">


    <!-- Main Style -->
    <link href="../assets/css/main.css" rel="stylesheet">

    <!-- Supersized -->
    <link href="../assets/css/supersized.css" rel="stylesheet">
    <link href="../assets/css/supersized.shutter.css" rel="stylesheet">
	
	<title>Profile</title>
	
  </head>

  <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">                            				
	 <div class="container">                                                                       					
	                                                                                               					
	     <!-- Logo -->                                                                             					
	     <div class="pull-left">                                                                   					
	         <a class="navbar-toggle" href="#" data-toggle="offcanvas"><i class="ti-menu"></i></a> 					
	                                                                                               					
	         <div class="logo-wrapper">                                                            					
	             <a class="logo" href="/"><img src="../assets/img/logo.png" alt="logo"></a>        					
	          </div>                                                                               					
	                                                                                               					
	      </div>                                                                                   					
	      <!-- END Logo -->                                                                        					
	                                                                                               					
	      <!-- User account -->                                                                    					
          <div class="pull-right user-login">                                                      					
              <a class="btn btn-sm btn-primary" href="/login"/>Login</a> or <a href="/signin"/>register</a>          
          </div>                                                                                  					
          <!-- END User account -->                                                               					
                                                                                                  					
          <!-- Navigation menu -->                                                                					
          <ul id="nav-menu-id" class="nav-menu">                                                  					
              <li>                                                                                					
                  <a href="/">Home</a>                                              									
              </li>                                                                               					
              <li>                                                                                					
                  <a href="#">Profile</a>                                                         					
                  <ul>                                                                            					
                      <li><a href="profile.jsp">My profile</a></li>                     								
                      <li><a href="employee-edit.jsp">Edit profile</a></li>             	         					
                      <li><a>Log out</a></li>                                                     					
                  </ul>                                                                           					
              </li>                                                                               					
              <li>                                                                                					
                  <a href="#">Resume</a>                                                          					
                  <ul>                                                                            					
                      <li><a href="resume-list.jsp">Browse resumes</a></li>                       					
                      <li><a href="employee-profile.jsp">Resume detail</a></li>                 						
                      <li><a href="resume.jsp">Create a resume</a></li>                         						
                      <li><a href="resume-manage.jsp">Manage resumes</a></li>                     					
                  </ul>                                                                           					
              </li>                                                                               					
              <li>                                                                                					
                  <a href="#">Vacancy</a>                                                         					
                  <ul>                                                                            					
                      <li><a href="vacancy-list.jsp">Browse vacancies</a></li>                    					
                      <li><a href="vacancy-manage.jsp">Manage vacancies</a></li>                  					
                  </ul>                                                                           					
              </li>                                                                               					
              <li>                                                                                					
                  <a href="#">Pages</a>                                                           					
                  <ul>                                                                            					
                      <li><a href="about.jsp">About</a></li>                          								
                      <li><a href="contact.jsp">Contact</a></li>                      								
                      <li><a href="faq.jsp">FAQ</a></li>                              								
                  </ul>                                                                           					
              </li>                                                                               					
    		<li>                                                                                 					
                  <a href="admin.jsp">Admin</a>                                                   					
                  <ul>                                                                          						
                      <li><a>Manage users</a></li>                                                					
                      <li><a>Manage resumes</a></li>                                              					
                      <li><a>Manage vacancies</a></li>                                            					
                  </ul>                                                                           					
             </li>                                                                                					
          </ul>                                                                                   					
          <!-- END Navigation menu -->                                                            					
                                                                                                  					
      </div>                                                                                      					
    </nav>                                                                                          					
    <!-- END Navigation bar -->                                                                     					
  
    <!-- Page header -->
	<section class="bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
    <header class="page-header-my">
	  <br><br>
      <div class="container">
        <div class="row">

          <div class="col-xs-10 col-sm-12 header-detail">
            <div class="hgroup">
              <h11><s:property value="name"/> <s:property value="surname"/></h11><br>
              <h31><s:property value="userType"/></h31>
            </div>
            <hr>
			<p class="lead-my">About</p>
            <p class="lead"><s:property value="about"/></p>
			
			<p class="lead-my">Contact info</p>
            <p class="lead"><s:property value="contactInfo"/></p>
			
			<p class="lead-my">E-mail</p>
			<div class="col-sm-10">				
				<p class="lead"><s:property value="email"/></p>
            </div>
			<a class="btn btn-success" href="<s:property value="mailtoLink"/>">Contact me</a>
            
          </div>
        </div>

      </div>
    </header>
    <!-- END Page header -->
	</section>

    <!-- Main container -->
    <main>
	  
    </main>
    <!-- END Main container -->



<footer class="site-footer">                                                                                            
   <!-- Top section -->                                                                                                
   <div class="container">                                                                                             
       <div class="row">                                                                                               
           <div class="col-sm-12 col-md-6">                                                                            
               <h6>About</h6>                                                                                          
               <p class="text-justify">An employment website is a web site that deals specifically with employment or  
                   careers. Many employment websites are designed to allow employers to post job requirements for a    
                   position to be filled and are commonly known as job boards. Other employment sites offer employer   
                   reviews, career and job-search advice, and describe different job descriptions or employers. Through
                    a job website a prospective employee can locate and fill out a job application.</p>                 
            </div>                                                                                                      
            <div class="col-xs-6 col-md-3">                                                                             
                <h6>Company</h6>                                                                                        
                <ul class="footer-links">                                                                               
                    <li><a href="content/about.jsp">About us</a></li>                                                   
                    <li><a href="content/faq.jsp">Help center</a></li>                                                  
                    <li><a href="content/contact.jsp">Contact us</a></li>                                               
                </ul>                                                                                                   
            </div>                                                                                                      
        </div>                                                                                                          
        <hr>                                                                                                            
    </div>                                                                                                              
    <div class="container">                                                                                             
        <div class="row">                                                                                               
            <div class="col-md-8 col-sm-6 col-xs-12">                                                                   
                <p class="copyright-text">2016 Belousova Lubov, Korolko Kirill, Shulga Egor.</p>                        
            </div>                                                                                                      
                                                                                                                        
            <div class="col-md-4 col-sm-6 col-xs-12">                                                                   
                <ul class="social-icons">                                                                               
                    <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>                            
                    <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>                              
                    <li><a class="dribbble" href="#"><i class="fa fa-dribbble"></i></a></li>                            
                    <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>                            
                    <li><a class="instagram" href="#"><i class="fa fa-instagram"></i></a></li>                          
                </ul>                                                                                                   
            </div>                                                                                                      
        </div>                                                                                                          
    </div>                                                                                                              
 </footer>                                                                                                              

<!-- Back to top button -->
<a id="scroll-up" href="#"><i class="ti-angle-up"></i></a>
<!-- END Back to top button -->

<!-- Scripts -->
<script src="../assets/js/app.min.js"></script>
<script src="../assets/js/custom.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../assets/js/bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../assets/js/grayscale.js"></script>

</body>
</html>
