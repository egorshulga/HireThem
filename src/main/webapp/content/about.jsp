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

<s:include value="partials/header.jsp"/>

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

<s:include value="partials/footer.jsp"/>

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
