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

<!-- Navigation bar -->
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
            <a class="btn btn-sm btn-primary" href="/login"/>Login</a> or <a
                href="/signin"/>register</a>
        </div>
        <!-- END User account -->

        <!-- Navigation menu -->
        <ul class="nav-menu">
            <li>
                <a href="/">Home</a>
            </li>
            <li>
                <a href="#">Position</a>
                <ul>
                    <li><a>Browse jobs</a></li>
                    <li><a>Job detail</a></li>
                    <li><a href="vacancy.jsp">Post a job</a></li>
                    <li><a>Manage jobs</a></li>
                </ul>
            </li>
            <li>
                <a href="#" class="active">Resume</a>
                <ul>
                    <li><a>Browse resumes</a></li>
                    <li><a class="active" href="employee_profile.jsp">Resume detail</a></li>
                    <li><a href="resume.jsp">Create a resume</a></li>
                    <li><a href="employee_edit.jsp">Edit profile</a></li>
                </ul>
            </li>
            <li>
                <a href="#">Company</a>
                <ul>
                    <li><a>Browse companies</a></li>
                    <li><a href="employer_profile.jsp">Company detail</a></li>
                    <li><a href="employer_edit.jsp">Create a company</a></li>
                    <li><a>Manage companies</a></li>
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
        </ul>
        <!-- END Navigation menu -->

    </div>
</nav>
<!-- END Navigation bar -->


    <!-- Page header -->
    <header class="page-header">
	  <br><br>
      <div class="container">
        <div class="row">
          <div class="col-xs-12 col-sm-4">
            <img src="../assets/img/avatar.jpg" alt="">
          </div>

          <div class="col-xs-12 col-sm-8 header-detail">
            <div class="hgroup">
              <h11>John Doe</h11><br>
              <h31>Front-end developer</h31>
            </div>
            <hr>
            <p class="lead">The front end  is the part that users see and interact with, includes the User Interface, the animations, and usually a bunch of logic to talk to the backend. It is the visual bit that the user interacts with. This includes the design, images, colours, buttons, forms, typography, animations and content. It’s basically everything that you as a user of the website can see.</p>

            <ul class="details cols-2">
              <li>
                <i class="fa fa-map-marker"></i>
                <span>Mountain view, CA</span>
              </li>

              <li>
                <i class="fa fa-globe"></i>
                <a href="#">mywebsite.me</a>
              </li>

              <li>
                <i class="fa fa-money"></i>
                <span>$85 / hour</span>
              </li>

              <li>
                <i class="fa fa-birthday-cake"></i>
                <span>27 years-old</span>
              </li>

              <li>
                <i class="fa fa-phone"></i>
                <span>(+1) 123 456 7890</span>
              </li>

              <li>
                <i class="fa fa-envelope"></i>
                <a href="#">hi@mywebsite.me</a>
              </li>
            </ul>

            <div class="tag-list">
              <span>HTML5</span>
              <span>CSS3</span>
              <span>Bootstrap</span>
              <span>ReactJS</span>
              <span>SASS / LESS</span>
              <span>Grunt / Gulp</span>
              <span>Wordpress</span>
            </div>
          </div>
        </div>

        <div class="button-group">
          <ul class="social-icons">
            <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
            <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
            <li><a class="dribbble" href="#"><i class="fa fa-dribbble"></i></a></li>
            <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
            <li><a class="instagram" href="#"><i class="fa fa-instagram"></i></a></li>
          </ul>

          <div class="action-buttons">
            <a class="btn btn-gray" href="#">Download CV</a>
            <a class="btn btn-success" href="#">Contact me</a>
          </div>
        </div>
      </div>
    </header>
    <!-- END Page header -->


    <!-- Main container -->
    <main>


      <!-- Education -->
      <section class="page-header">
        <div class="container">

          <header class="section-header">
            <span>Latest degrees</span>
            <h2>Education</h2>
          </header>
          
          <div class="row">
            <div class="col-xs-12">
              <div class="item-block">
                <header>
                  <img src="../assets/img/logo-mit.png" alt="">
                  <div class="hgroup">
                    <h4>Master <small>Computer Science</small></h4>
                    <h5>Massachusetts Institute of Technology</h5>
                  </div>
                  <h6 class="time">2012 - 2014</h6>
                </header>
                <div class="item-body">
                  <p>The Massachusetts Institute of Technology (MIT) is a private research university in Cambridge, Massachusetts. Founded in 1861 in response to the increasing industrialization of the United States, MIT adopted a European polytechnic university model and stressed laboratory instruction in applied science and engineering.</p>
                </div>
              </div>
            </div>

            <div class="col-xs-12">
              <div class="item-block">
                <header>
                  <img src="../assets/img/logo-berkeley.png" alt="">
                  <div class="hgroup">
                    <h4>Bachelor <small>Computer Science</small></h4>
                    <h5>University of California, Berkeley</h5>
                  </div>
                  <h6 class="time">2008 - 2012</h6>
                </header>
                <div class="item-body">
                  <p>The University of California, Berkeley is a public research university located in Berkeley, California. It is the flagship campus of the University of California system, one of three parts in the state's public higher education plan, which also includes the California State University system and the California Community Colleges System.</p>
                </div>
              </div>
            </div>
          </div>
		<br><br><br>
        </div>
      </section>
      <!-- END Education -->


      <!-- Work Experience -->
      <section class="page-header-myclass">
        <div class="container">
          <header class="section-header">
            <span>Past positions</span>
            <h2>Work Experience</h2>
          </header>
          
          <div class="row">

            <!-- Work item -->
            <div class="col-xs-12">
              <div class="item-block">
                <header>
                  <img src="../assets/img/logo-google.jpg" alt="">
                  <div class="hgroup">
                    <h4>Google</h4>
                    <h5>Senior front-end developer</h5>
                  </div>
                  <h6 class="time">Jan 2016 - Present</h6>
                </header>
                <div class="item-body">
                  <p>Responsibilities:</p>
                  <ul>
                    <li>Developed front-end for world-class online social viewing video and chat platform using xHTML, CSS, ActionScript 2-3, Javascript, and XML.</li>
                    <li>Developed built-in chat application into Flash video player in ActionScript 3.</li>
                    <li>Built and developed sites for ABC Family properties such as Gilmore Girls, The Middleman, Secret Life of an American Teenager, Greek, and Kyle XY. </li>
                    <li>Translate designs into responsive web interfaces </li>
                    <li>Collaboration with the graphic designer on the front-end aspect of development. </li>
                    <li>Cross-platform cross-browser development. </li>
                    <li>Some back-end development in collaboration with senior developer.</li>
                  </ul>
                </div>
              </div>
            </div>
            <!-- END Work item -->


            <!-- Work item -->
            <div class="col-xs-12">
              <div class="item-block">
                <header>
                  <img src="../assets/img/logo-facebook.png" alt="">
                  <div class="hgroup">
                    <h4>Facebook</h4>
                    <h5>Interface developer</h5>
                  </div>
                  <h6 class="time">Aug 2014 - Jan 2016</h6>
                </header>
                <div class="item-body">
                  <p>Responsibilities:</p>
                  <ul>
                    <li>Work as a part of a large team on a major corporate project</li>
                    <li>Responsible for all aspects of presentation layer development including developing templates using HTML, DHTML, Javascript, XML, and XSL.</li>
                    <li>Rapid-prototyping for usability studies and new business development.</li>
                    <li>Collaboration with the graphic designer on the front-end aspect of development.</li>
                    <li>Some back-end development in collaboration with senior developer.</li>
                  </ul>
                </div>
              </div>
            </div>
            <!-- END Work item -->


            <!-- Work item -->
            <div class="col-xs-12">
              <div class="item-block">
                <header>
                  <img src="../assets/img/logo-envato.png" alt="">
                  <div class="hgroup">
                    <h4>Envato</h4>
                    <h5>Quality assurance engineer</h5>
                  </div>
                  <h6 class="time">Mar 2012 - Jun 2014</h6>
                </header>
                <div class="item-body">
                  <p>Responsibilities:</p>
                  <ul>
                    <li>Software testing in a Web Applications/Mobile environment.</li>
                    <li>Software Test Plans from Business Requirement Specifications for test engineering group.</li>
                    <li>Run production tests as part of software implementation; Create, deliver and support test plans for testing group to execute.</li>
                    <li>Software testing in a Web Applications environment.</li>
                  </ul>
                </div>
              </div>
            </div>
            <!-- END Work item -->

          </div>

        </div>
      </section>
      <!-- END Work Experience -->
    </main>
    <!-- END Main container -->


    <!-- Site footer -->
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
                    <li><a href="about.jsp">About us</a></li>
                    <li><a href="faq.jsp">Help center</a></li>
                    <li><a href="contact.jsp">Contact us</a></li>
                </ul>
            </div>
        </div>

        <hr>
    </div>
    <!-- END Top section -->

    <!-- Bottom section -->
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
    <!-- END Bottom section -->

</footer>
<!-- END Site footer -->


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
