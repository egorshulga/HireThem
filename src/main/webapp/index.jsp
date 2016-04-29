<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Custom CSS -->
    <link href="assets/css/grayscale.css" rel="stylesheet">


    <link href="assets/css/app.min.css" rel="stylesheet">
    <link href="assets/css/custom.css" rel="stylesheet">

    <title>HireThem</title>

</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

<!-- Navigation bar -->
<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
    <div class="container">

        <!-- Logo -->
        <div class="pull-left">
            <a class="navbar-toggle" href="#" data-toggle="offcanvas"><i class="ti-menu"></i></a>

            <div class="logo-wrapper">
                <a class="logo" href="/"><img src="assets/img/logo.png" alt="logo"></a>
            </div>

        </div>
        <!-- END Logo -->

        <!-- User account -->
        <div class="pull-right user-login">
            <a class="btn btn-sm btn-primary" href="<s:url action="login"/>">Login</a> or <a
                href="<s:url action="signin"/>">register</a>
        </div>
        <!-- END User account -->

        <!-- Navigation menu -->
        <ul class="nav-menu">
            <li>
                <a class="active" href="/">Home</a>
            </li>
            <li>
                <a href="#">Position</a>
                <ul>
                    <li><a>Browse jobs</a></li>
                    <li><a>Job detail</a></li>
                    <li><a href="content/vacancy.jsp">Post a job</a></li>
                    <li><a>Manage jobs</a></li>
                </ul>
            </li>
            <li>
                <a href="#">Resume</a>
                <ul>
                    <li><a>Browse resumes</a></li>
                    <li><a href="content/employee_profile.jsp">Resume detail</a></li>
                    <li><a href="content/resume.jsp">Create a resume</a></li>
                    <li><a href="content/employee_edit.jsp">Edit profile</a></li>
                </ul>
            </li>
            <li>
                <a href="#">Company</a>
                <ul>
                    <li><a>Browse companies</a></li>
                    <li><a href="content/employer_profile.jsp">Company detail</a></li>
                    <li><a href="content/employer_edit.jsp">Create a company</a></li>
                    <li><a>Manage companies</a></li>
                </ul>
            </li>
            <li>
                <a href="#">Pages</a>
                <ul>
                    <li><a href="content/about.jsp">About</a></li>
                    <li><a href="content/contact.jsp">Contact</a></li>
                    <li><a href="content/faq.jsp">FAQ</a></li>
                </ul>
            </li>
        </ul>
        <!-- END Navigation menu -->

    </div>
</nav>
<!-- END Navigation bar -->

<!-- Site header -->
<header class="site-header size-lg text-center" style="background-image: url(assets/img/bg-banner1.jpg)">
    <div class="container">
        <div class="col-xs-12">
            <br><br>
            <h2>We offer
                <mark>1,259</mark>
                job vacancies right now!
            </h2>
            <h5 class="font-alt">Find your desire one in a minute</h5>
            <br><br><br>
            <form class="header-job-search">
                <div class="input-keyword">
                    <input type="text" class="form-control" placeholder="Job title, skills, or company">
                </div>

                <div class="input-location">
                    <input type="text" class="form-control" placeholder="City, state or zip">
                </div>

                <div class="btn-search">
                    <button class="btn btn-primary" type="submit">Find jobs</button>
                </div>
            </form>
        </div>

    </div>
</header>


<!-- Categories -->
<section class="bg-alt">
    <div class="container">
        <header class="section-header">
            <span>Categories</span>
            <h2>Popular categories</h2>
            <p>Here's the most popular categories</p>
        </header>

        <div class="category-grid">
            <a>
                <i class="fa fa-laptop"></i>
                <h6>Technology</h6>
                <p>Designer, Developer, IT Service, Front-end developer, Project management</p>
            </a>

            <a>
                <i class="fa fa-line-chart"></i>
                <h6>Accounting</h6>
                <p>Finance, Tax service, Payroll manager, Book keeper, Human resource</p>
            </a>

            <a>
                <i class="fa fa-medkit"></i>
                <h6>Medical</h6>
                <p>Doctor, Nurse, Hospotal, Dental service, Massagist</p>
            </a>

            <a>
                <i class="fa fa-cutlery"></i>
                <h6>Food</h6>
                <p>Restaurant, Food service, Coffe shop, Cashier, Waitress</p>
            </a>

            <a>
                <i class="fa fa-newspaper-o"></i>
                <h6>Media</h6>
                <p>Journalism, Newspaper, Reporter, Writer, Cameraman</p>
            </a>

            <a>
                <i class="fa fa-institution"></i>
                <h6>Government</h6>
                <p>Federal, Law, Human resource, Manager, Biologist</p>
            </a>
        </div>

    </div>
</section>
<!-- END Categories -->

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
                    <li><a href="content/about.jsp">About us</a></li>
                    <li><a href="content/faq.jsp">Help center</a></li>
                    <li><a href="content/contact.jsp">Contact us</a></li>
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
<script src="assets/js/app.min.js"></script>
<script src="assets/js/custom.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="assets/js/bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="assets/js/grayscale.js"></script>
</body>
</html>