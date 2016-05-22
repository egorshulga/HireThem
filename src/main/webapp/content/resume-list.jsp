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

   <s:include value="partials/header.jsp"/>

    <section class=" bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
	<br><br>
    <!-- Page header -->
    <header class="page-header-my">
      <div class="container page-name">
        <h1 class="text-center">Browse resumes</h1>
        <p class="lead text-center">Use following search box to find resumes that fits your position better</p>
      </div>

      <div class="container">
        <form>

          <div class="row">
            <div class="form-group col-xs-12 col-sm-4">
              <input type="text" class="form-control" placeholder="Summary">
			  <button class="btn btn-primary" href="browseResumesBySummary">Apply filter</button>
            </div>
			
			<div class="form-group col-xs-12 col-sm-4">
              <input type="text" class="form-control" placeholder="Skills">
			  <button class="btn btn-primary" href="browseResumesBySkills">Apply filter</button>
            </div>
			
			<div class="form-group col-xs-12 col-sm-4">
              <input type="text" class="form-control" placeholder="Education">
			  <button class="btn btn-primary" href="browseResumesByEducation">Apply filter</button>
            </div>
			
			<div class="form-group col-xs-12 col-sm-4">
              <input type="text" class="form-control" placeholder="Experience">
			  <button class="btn btn-primary" href="browseResumesByExperience">Apply filter</button>
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

			<!-- Resume detail -->
		   <s:iterator value="resumes" var="resume">
		   <s:hidden value="id"/>
            <div class="col-xs-12">
              <a class="item-block">
                <header>
                  <div class="hgroup">
                    <h4><s:property value="currentUser.name"/> <s:property value="currentUser.surname"/></h4>
                    <h5><s:property value="summary"/></h5>
                  </div>
                </header>

                <div class="item-body">
                  <p><s:property value="skills"/></p>
				  <p><s:property value="contactInfo"/></p>
                </div>
              </a><br><br>
            </div>

            <!-- END Resume detail -->
			</s:iterator>

          </div>
        </div>
      </section>
    </main>
    <!-- END Main container -->
	</section>

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
