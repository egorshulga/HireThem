<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
</html>
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

    <title>About</title>

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
            <a class="btn btn-sm btn-primary" href="<s:url action="login"/>">Login</a> or <a
                href="<s:url action="signin"/>">register</a>
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
<header class="site-header size-lg text-center" style="background-image: url(../assets/img/bg-facts.jpg)">
    <div class="container>
		<div class=" col-xs-12">
            <br><br>
            <h1 class="text-center">About us</h1>
        </div>
    </div>
</header>
<!-- END Site header -->


<!-- Main container -->
<main>
    <!-- Team -->
    <section class="bg-alt">
        <div class="container">
            <header class="section-header">
                <span>Who we are</span>
                <h2>Our team</h2>
                <h6>Currently, we're three geek and will grow up soon</h6>
            </header>


            <div class="row">

                <!-- Team member -->
                <div class="col-xs-12 col-sm-6 col-md-4">
                    <div class="span4 profile">
                        <div class="image-wrap">
                            <div class="hover-wrap">
                                <span class="overlay-img"></span>
                                <span class="overlay-text-thumb">Teamlead</span>
                            </div>
                            <img src="/assets/img/Egor.jpg" alt="John Doe">
                        </div>
                        <h3 class="profile-name">Shulga Egor</h3>
                        <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac
                            augue at erat.
                            Praesent porta, purus eget sagittis imperdiet, nulla mi ullamcorper metus, id hendrerit
                            metus diam vitae est. Class aptent taciti sociosqu ad litora torquent per conubia nostra,
                            per inceptos himenaeos.</p>
                        <div class="social">
                            <ul class="social-icons">
                                <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
                                <li><a class="github" href="#"><i class="fa fa-github"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- END Team member -->

                <!-- Team member -->
                <div class="col-xs-12 col-sm-6 col-md-4">
                    <div class="span4 profile">
                        <div class="image-wrap">
                            <div class="hover-wrap">
                                <span class="overlay-img"></span>
                                <span class="overlay-text-thumb">QA Engeneer</span>
                            </div>
                            <img src="/assets/img/Luba.jpg" alt="John Doe">
                        </div>
                        <h3 class="profile-name">Belousova Lubov</h3>
                        <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac
                            augue at erat.
                            Praesent porta, purus eget sagittis imperdiet, nulla mi ullamcorper metus, id hendrerit
                            metus diam vitae est. Class aptent taciti sociosqu ad litora torquent per conubia nostra,
                            per inceptos himenaeos.</p>
                        <div class="social">
                            <ul class="social-icons">
                                <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a class="github" href="#"><i class="fa fa-github"></i></a></li>
                                <li><a class="instagram" href="#"><i class="fa fa-instagram"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- END Team member -->

                <!-- Team member -->
                <div class="col-xs-12 col-sm-6 col-md-4">
                    <div class="span4 profile">
                        <div class="image-wrap">
                            <div class="hover-wrap">
                                <span class="overlay-img"></span>
                                <span class="overlay-text-thumb">Designer</span>
                            </div>
                            <img src="/assets/img/Kirill.jpg" alt="John Doe">
                        </div>
                        <h3 class="profile-name">Korolko Kirill</h3>
                        <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac
                            augue at erat.
                            Praesent porta, purus eget sagittis imperdiet, nulla mi ullamcorper metus, id hendrerit
                            metus diam vitae est. Class aptent taciti sociosqu ad litora torquent per conubia nostra,
                            per inceptos himenaeos.</p>
                        <div class="social">
                            <ul class="social-icons">
                                <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a class="github" href="#"><i class="fa fa-github"></i></a></li>
                                <li><a class="instagram" href="#"><i class="fa fa-instagram"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- END Team member -->

            </div>

        </div>
    </section>
    <!-- END Team -->


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
