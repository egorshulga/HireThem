<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Post a job position or create your online resume by TheJobs!">
    <meta name="keywords" content="">

    <title>Contact us</title>
	
    <!-- Custom CSS -->
    <link href="../assets/css/grayscale.css" rel="stylesheet">
	
    <link href="../assets/css/app.min.css" rel="stylesheet">
    <link href="../assets/css/custom.css" rel="stylesheet">
	
	<!-- Main Style -->
	<link href="../assets/css/main.css" rel="stylesheet">

	<!-- Supersized -->
	<link href="../assets/css/supersized.css" rel="stylesheet">
	<link href="../assets/css/supersized.shutter.css" rel="stylesheet">
 </head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

<!-- Navigation bar -->
<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
    <div class="container">

        <!-- Logo -->
        <div class="pull-left">
            <a class="navbar-toggle" href="/" data-toggle="offcanvas"><i class="ti-menu"></i></a>

            <div class="logo-wrapper">
                <a class="logo" href="/"><img src="../assets/img/logo.png" alt="logo"></a>
            </div>

        </div>
        <!-- END Logo -->

        <!-- User account -->
        <div class="pull-right user-login">
            <a class="btn btn-sm btn-primary" href="<s:url action="loginInquire"/>">Login</a> or <a href="<s:url action="signInInquire"/>">register</a>
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
                    <li><a>Post a job</a></li>
                    <li><a>Manage jobs</a></li>
                </ul>
            </li>
            <li>
                <a href="#">Resume</a>
                <ul>
                    <li><a>Browse resumes</a></li>
                    <li><a>Resume detail</a></li>
                    <li><a>Create a resume</a></li>
                    <li><a>Manage resumes</a></li>
                </ul>
            </li>
            <li>
                <a href="#">Company</a>
                <ul>
                    <li><a>Browse companies</a></li>
                    <li><a>Company detail</a></li>
                    <li><a>Create a company</a></li>
                    <li><a>Manage companies</a></li>
                </ul>
            </li>
            <li>
                <a class="active" href="#">Pages</a>
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


   <!-- Site header -->
    <header class="site-header size-lg text-center" style="background-image: url(../assets/img/bg-banner2.jpg)">
	  <div class="container">
        <div class="col-xs-12">
          <h1>Contact us</h1>
		  <br><br>
          <h5 class="font-alt">Say hi, drop a letter, and follow us in social media websites.</h5>
        </div>
      </div>
    </header>
    <!-- END Site header -->


    <!-- Main container -->
    <main>

      <section>
        <div class="container">
          <div class="row">
            <div class="col-sm-12 col-md-8">
              <h4>Contact form</h4>
              <form>
                <div class="form-group">
                  <input type="text" class="form-control input-lg" placeholder="Name">
                </div>

                <div class="form-group">
                  <input type="email" class="form-control input-lg" placeholder="Email">
                </div>

                <div class="form-group">
                  <textarea class="form-control" rows="5" placeholder="Message"></textarea>
                </div>
                
                <button type="submit" class="btn btn-primary">Send</button>
              </form>
            </div>

            <div class="col-sm-12 col-md-4">
              <h4>Information</h4>
              <div class="highlighted-block">
                <dl class="icon-holder">
                  <dt><i class="fa fa-map-marker"></i></dt>
                  <dd>3652 Seventh Avenue, Los Angeles, CA</dd>

                  <dt><i class="fa fa-phone"></i></dt>
                  <dd>(+1) 987 654 3210</dd>

                  <dt><i class="fa fa-fax"></i></dt>
                  <dd>(+1) 123 456 7890</dd>

                  <dt><i class="fa fa-envelope"></i></dt>
                  <dd>hi@yoursite.com</dd>
                </dl>
              </div>

              <br>

              <ul class="social-icons size-sm text-center">
                <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a class="dribbble" href="#"><i class="fa fa-dribbble"></i></a></li>
                <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
                <li><a class="instagram" href="#"><i class="fa fa-instagram"></i></a></li>
              </ul>

            </div>
          </div>

        </div>
      </section>


    </main>
    <!-- END Main container -->


     <!-- Site footer -->
	<footer class="site-footer">

		<!-- Top section -->
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-6">
					<h6>About</h6>
					<p class="text-justify">An employment website is a web site that deals specifically with employment or careers. Many employment websites are designed to allow employers to post job requirements for a position to be filled and are commonly known as job boards. Other employment sites offer employer reviews, career and job-search advice, and describe different job descriptions or employers. Through a job website a prospective employee can locate and fill out a job application.</p>
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
