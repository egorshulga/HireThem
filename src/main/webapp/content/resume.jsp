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
                    <li><a href="employee_profile.jsp">Resume detail</a></li>
                    <li><a class="active" href="resume.jsp">Create a resume</a></li>
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

    <form action="#">
	
	 <!-- Page header -->
	  <section class=" bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
	  <br><br>
      <header class="page-header-my">
        <div class="container page-name">
          <h1 class="text-center">Edit your profile</h1>
        </div>

        <div class="container">

            <div class="col-xs-12">
              <div class="form-group">
                <textarea class="form-control" rows="3" placeholder="Summary"></textarea>
              </div>
			  <div class="form-group">
                <textarea class="form-control" rows="3" placeholder="Interests"></textarea>
              </div>
			  <div class="form-group">
                <textarea class="form-control" rows="3" placeholder="References"></textarea>
              </div>
            </div>
          </div>
        </div>
      </header>
	  </section>
      <!-- END Page header -->
	  
      <!-- Main container -->
      <main>

	  <!-- Skills -->
         <section class="bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
          <div class="container">
            <header class="section-header">
              <span>Expertise Areas</span>
              <h2>Skills</h2>
            </header>
            
            <div class="row">

              <div class="col-xs-12">
                <div class="item-block">
                  <div class="item-form">
  
                    <button class="btn btn-danger btn-float btn-remove"><i class="ti-close"></i></button>

                    <div class="row">
                      <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="Skill name, e.g. HTML">
                        </div>
                      </div>

                      <div class="col-xs-12 col-sm-6">

                        <div class="form-group">
                          <div class="input-group">
                            <input type="text" class="form-control" placeholder="Skill proficiency, e.g. 90">
                            <span class="input-group-addon">%</span>
                          </div>
                        </div>

                      </div>
                    </div>

                  </div>
                </div>
              </div>

              <div class="col-xs-12 duplicateable-content">
                <div class="item-block">
                  <div class="item-form">
  
                    <button class="btn btn-danger btn-float btn-remove"><i class="ti-close"></i></button>

                    <div class="row">
                      <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="Skill name, e.g. HTML">
                        </div>
                      </div>

                      <div class="col-xs-12 col-sm-6">

                        <div class="form-group">
                          <div class="input-group">
                            <input type="text" class="form-control" placeholder="Skill proficiency, e.g. 90">
                            <span class="input-group-addon">%</span>
                          </div>
                        </div>

                      </div>
                    </div>

                  </div>
                </div>
              </div>

              <div class="col-xs-12 text-center">
                <br>
                <button class="btn btn-primary btn-duplicator">Add experience</button>
              </div>


            </div>

          </div>
        </section>
        <!-- END Skills -->
	  
        <!-- Education -->
        <section class="bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
          <div class="container">

            <header class="section-header">
              <span>Latest degrees</span>
              <h2>Education</h2>
            </header>
		<header class="page-header-my">
            <div class="row">

              <div class="col-xs-12">
                <div class="item-block">
                  <div class="item-form">
  
                    <button class="btn btn-danger btn-float btn-remove"><i class="ti-close"></i></button>

                    <div class="row">
                      <div class="col-xs-12 col-sm-4">
                        <div class="form-group">
                          <input type="file" class="dropify" data-default-file="../assets/img/logo-default.png">
                          <span class="help-block">Please choose a square logo</span>
                        </div>
                      </div>

                      <div class="col-xs-12 col-sm-8">
                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="Degree, e.g. Bachelor">
                        </div>

                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="Major, e.g. Computer Science">
                        </div>
                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="School name, e.g. Massachusetts Institute of Technology">
                        </div>

                        <div class="form-group">
                          <div class="input-group">
                            <span class="input-group-addon">Date from</span>
                            <input type="text" class="form-control" placeholder="e.g. 2012">
                            <span class="input-group-addon">Date to</span>
                            <input type="text" class="form-control" placeholder="e.g. 2016">
                          </div>
                        </div>

                        <div class="form-group">
                          <textarea class="form-control" rows="3" placeholder="Short description"></textarea>
                        </div>
                      </div>
                    </div>

                  </div>
                </div>
              </div>

              <div class="col-xs-12 duplicateable-content">
                <div class="item-block">
                  <div class="item-form">
  
                    <button class="btn btn-danger btn-float btn-remove"><i class="ti-close"></i></button>

                    <div class="row">
                      <div class="col-xs-12 col-sm-4">
                        <div class="form-group">
                          <input type="file" class="dropify" data-default-file="../assets/img/logo-default.png">
                          <span class="help-block">Please choose a square logo</span>
                        </div>
                      </div>

                      <div class="col-xs-12 col-sm-8">
                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="Degree, e.g. Bachelor">
                        </div>

                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="Major, e.g. Computer Science">
                        </div>
                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="School name, e.g. Massachusetts Institute of Technology">
                        </div>

                        <div class="form-group">
                          <div class="input-group">
                            <span class="input-group-addon">Date from</span>
                            <input type="text" class="form-control" placeholder="e.g. 2012">
                            <span class="input-group-addon">Date to</span>
                            <input type="text" class="form-control" placeholder="e.g. 2016">
                          </div>
                        </div>

                        <div class="form-group">
                          <textarea class="form-control" rows="3" placeholder="Short description"></textarea>
                        </div>
                      </div>
                    </div>

                  </div>
                </div>
              </div>

              <div class="col-xs-12 text-center">
                <br>
                <button class="btn btn-primary btn-duplicator">Add education</button>
              </div>


            </div>
          </div>
		</header>
        </section>
        <!-- END Education -->


        <!-- Work Experience -->
        <section class="bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
          <div class="container">
            <header class="section-header">
              <span>Past positions</span>
              <h2>Work Experience</h2>
            </header>
            
            <div class="row">

              <div class="col-xs-12">
                <div class="item-block">
                  <div class="item-form">
  
                    <button class="btn btn-danger btn-float btn-remove"><i class="ti-close"></i></button>

                    <div class="row">
                      <div class="col-xs-12 col-sm-4">
                        <div class="form-group">
                          <input type="file" class="dropify" data-default-file="../assets/img/logo-default.png">
                          <span class="help-block">Please choose a square logo</span>
                        </div>
                      </div>

                      <div class="col-xs-12 col-sm-8">
                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="Company name">
                        </div>

                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="Position, e.g. UI/UX Researcher">
                        </div>

                        <div class="form-group">
                          <div class="input-group">
                            <span class="input-group-addon">Date from</span>
                            <input type="text" class="form-control" placeholder="e.g. 2012">
                            <span class="input-group-addon">Date to</span>
                            <input type="text" class="form-control" placeholder="e.g. 2016">
                          </div>
                        </div>

                      </div>

                      <div class="col-xs-12">
                        <div class="form-group">
                          <textarea class="form-control" rows="3" placeholder="Short description"></textarea>
                        </div>
                      </div>
                    </div>

                  </div>
                </div>
              </div>

              <div class="col-xs-12 duplicateable-content">
                <div class="item-block">
                  <div class="item-form">
  
                    <button class="btn btn-danger btn-float btn-remove"><i class="ti-close"></i></button>

                    <div class="row">
                      <div class="col-xs-12 col-sm-4">
                        <div class="form-group">
                          <input type="file" class="dropify" data-default-file="../assets/img/logo-default.png">
                          <span class="help-block">Please choose a square logo</span>
                        </div>
                      </div>

                      <div class="col-xs-12 col-sm-8">
                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="Company name">
                        </div>

                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="Position, e.g. UI/UX Researcher">
                        </div>

                        <div class="form-group">
                          <div class="input-group">
                            <span class="input-group-addon">Date from</span>
                            <input type="text" class="form-control" placeholder="e.g. 2012">
                            <span class="input-group-addon">Date to</span>
                            <input type="text" class="form-control" placeholder="e.g. 2016">
                          </div>
                        </div>

                      </div>

                      <div class="col-xs-12">
                        <div class="form-group">
                          <textarea class="summernote-editor"></textarea>
                        </div>
                      </div>
                    </div>

                  </div>
                </div>
              </div>

              <div class="col-xs-12 text-center">
                <br>
                <button class="btn btn-primary btn-duplicator">Add experience</button>
              </div>


            </div>

          </div>
        </section>
        <!-- END Work Experience -->
		
        <!-- Submit -->
        <section class=" bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
          <div class="container">
            <header class="section-header">
              <span>Are you done?</span>
              <h2>Submit resume</h2>
              <p>Please review your information once more and press the below button to put your resume online.</p>
            </header>

            <p class="text-center"><button class="btn btn-success btn-xl btn-round">Submit your resume</button></p>

          </div>
        </section>
        <!-- END Submit -->


      </main>
      <!-- END Main container -->

    </form>

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
