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

    <form action="#">
	
	 <!-- Page header -->
	  <section class=" bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
	  <br><br>
      <header class="page-header-my">
        <div class="container page-name">
          <h1 class="text-center">Edit your resume</h1>
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
			  <div class="form-group">
                <textarea class="form-control" rows="3" placeholder="Skills"></textarea>
              </div>
            </div>
          </div>
        </div>
      </header>
	  </section>
      <!-- END Page header -->
	  
      <!-- Main container -->
      <main>

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
  
                  <!--  <button class="btn btn-danger btn-float btn-remove" onclick="deleteEducation()"><i class="ti-close"></i></button> -->

                    <div class="row">
                      
                      <div class="col-xs-12">
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

              <div id="duplicator" class="col-xs-12 duplicateable-content">
                <div class="item-block">
                  <div class="item-form">
  
                    <button id="duplicator-button" class="btn btn-danger btn-float btn-remove" onclick="deleteEducation()"><i class="ti-close"></i></button>

                    <div class="row">
                      
                      <div class="col-xs-12">
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

                      <div class="col-xs-12">
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

                      <div class="col-xs-12">
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
