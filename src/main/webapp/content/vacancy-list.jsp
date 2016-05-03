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
</head>

   <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

    <section class=" bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
	<br><br>
    <!-- Page header -->
    <header class="page-header-my">
      <div class="container page-name">
        <h1 class="text-center">Browse jobs</h1>
        <p class="lead text-center">Use following search box to find jobs that fits you better</p>
      </div>

      <div class="container">
        <form action="#">

          <div class="row">
            <div class="form-group col-xs-12 col-sm-4">
              <input type="text" class="form-control" placeholder="Title">
			  <button class="btn btn-primary">Apply filter</button>
            </div>

            <div class="form-group col-xs-12 col-sm-4">
              <input type="text" class="form-control" placeholder="Summary">
			  <button class="btn btn-primary">Apply filter</button>
            </div>
			
			<div class="form-group col-xs-12 col-sm-4">
              <input type="text" class="form-control" placeholder="Working day">
			  <button class="btn btn-primary">Apply filter</button>
            </div>
			
			<div class="form-group col-xs-12 col-sm-4">
              <input type="text" class="form-control" placeholder="Salary">
			  <button class="btn btn-primary">Apply filter</button>
            </div>
			
			<div class="form-group col-xs-12 col-sm-4">
              <input type="text" class="form-control" placeholder="Experience">
			  <button class="btn btn-primary">Apply filter</button>
            </div>
          </div>
        </form>
      </div>
    </header>
    <!-- END Page header -->


    <!-- Main container -->
    <main>
       <section class=" bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
        <div class="container">
          <div class="row">

            <!-- Job item -->
            <div class="col-xs-12">
              <a class="item-block" href="vacancy-detail.jsp">
                <header>
                  <img src="../assets/img/logo-google.jpg" alt="">
                  <div class="hgroup">
                    <h4>Senior front-end developer</h4>
                    <h5>Google <span class="label label-success">Full-time</span></h5>
                  </div>
                  <time datetime="2016-03-10 20:00">34 min ago</time>
                </header>

                <div class="item-body">
                  <p>A rapidly growing, well established marketing firm is looking for an experienced web developer for a full-time position. In this role, you will develop websites, apps, emails and other forms of digital electronic media, all while maintaining brand standards across design projects and other marketing communication materials.</p>
                </div>
				
                </footer>
              </a>
            </div>
            <!-- END Job item -->
          </div>

        </div>
      </section>
    </main>
    <!-- END Main container -->
	</section>

    <script src="footer.js"></script>
	<script src="header.js"></script>

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
