<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %><!doctype html>
<html lang="en">

<head>
	<meta charset="utf-8"/>
	<title>Admin Panel</title>

	<link rel="stylesheet" href="../assets/css/layout.css" type="text/css" media="screen" />

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

	<script src="../assets/js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="../assets/js/hideshow.js" type="text/javascript"></script>
	<script src="../assets/js/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="../assets/js/jquery.equalHeight.js"></script>
	<script type="text/javascript" src="../assets/js/jquery.toggleattr.min.js"></script>
		<!-- Custom Theme JavaScript -->
	<script type="text/javascript">
	$(document).ready(function()
    	{
      	  $(".tablesorter").tablesorter();
   	 }
	);
	$(document).ready(function() {

	//When page loads...
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content

	//On Click Event
	$("ul.tabs li").click(function() {

		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});

	$("input.edit").click(function() {
		$(this).closest("tr").find(".form-control").toggleAttr('disabled');
	});

	$("input.add").click(function() {
		//$(this).closest("tr").find(".form-control").toggleAttr('disabled');
		var el = document.getElementsByClassName("addNew")[0];
		var tab = document.getElementsByTagName("tbody")[0];
		console.log(el);
		console.log(tab);
		tab.appendChild(el);

		var tempElem = $(this).closest("tbody").find(".addNew");
		var temp = $(this).closest("tbody");
		$(temp).append(tempElem);
		//console.log(temp);
		var S = new Array ();

				S[0] = "<tr class=\"addNew\">                                                                                           ";
				S[1] = "	<td><input type=\"text\" class=\"form-control\"></td>                                                           ";
				S[2] = "	<td><input type=\"text\" class=\"form-control\"></td>                                                            ";
				S[3] = "	<td><input type=\"text\" class=\"form-control\"></td>                                                            ";
				S[4] = "	<td><input type=\"text\" class=\"form-control\"></td>                                                            ";
				S[5] = "	<td><input type=\"image\" class=\"add\" src=\"../assets/images/icn_add_user.png\" title=\"Add\">                     ";
				S[6] = "	<input type=\"image\" class=\"edit\" src=\"../assets/images/icn_edit.png\" title=\"Edit\" hidden=\"hidden\">           ";
				S[7] = "	<input type=\"image\" class=\"delete\" src=\"../assets/images/icn_trash.png\" title=\"Trash\" hidden=\"hidden\"></td>  ";
				S[8] = "</tr>                                                                                                         ";

		//$(temp).append(S.join ('\n'));


		$(this).closest("tr").find(".form-control").attr('disabled', "disabled");
		$(this).attr('hidden', "hidden");
		$(this).closest("tr").removeClass("addNew");
		$(this).closest("tr").find(".delete").attr('hidden', "");
		$(this).closest("tr").find(".edit").attr('hidden', "");


	});

	$('input.delete').click(function() {
		//alert("hi");
		$('#myModal').modal('show');
	});

});
    </script>
    <script type="text/javascript">
    $(function(){
        $('.column').equalHeight();
    });
</script>

</head>

<s:include value="partials/header.jsp"/>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

<div id="myModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h31 class="modal-title">Confirmation</h31>
            </div>
            <div class="modal-body">
                <p class="text-warning">Do you want to delete the element before closing?</p>
                <p class="text-warning"><small>If you delete, your will lost it.</small></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Delete</button>
            </div>
        </div>
    </div>
</div>

	<section id="main-my" class="column-my">

	<br><br>
		<br><br>
		<article class="module width_full">
		<header><h3 class="tabs_involved">Content Manager</h3>
		<ul class="tabs">
   			<li><a href="#tab1">Users</a></li>
    		<li><a href="#tab2">Resumes</a></li>
			<li><a href="#tab3">Vacancies</a></li>
		</ul>
		</header>

		<div class="tab_container">
			<div id="tab1" class="tab_content">
			<table class="tablesorter" cellspacing="0">
			<thead>
				<tr>
    				<th>E-mail</th>
    				<th>Name</th>
    				<th>Surname</th>
    				<th>Is Admin</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<tr>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
					<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="image" class="edit" src="../assets/images/icn_edit.png" title="Edit">
					<input type="image" data-toggle="modal" data-target="#basicModal" class="delete" src="../assets/images/icn_trash.png" title="Trash"></td>
				</tr>
				<tr>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
					<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="image" class="edit" src="../assets/images/icn_edit.png" title="Edit">
					<input type="image" class="delete" src="../assets/images/icn_trash.png" title="Trash"></td>
				</tr>
				<tr>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
					<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="image" class="edit" src="../assets/images/icn_edit.png" title="Edit">
					<input type="image" class="delete" src="../assets/images/icn_trash.png" title="Trash"></td>
				</tr>
				<tr>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
					<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="image" class="edit" src="../assets/images/icn_edit.png" title="Edit">
					<input type="image" class="delete" src="../assets/images/icn_trash.png" title="Trash"></td>
				</tr>
				<tr>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
					<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="image" class="edit" src="../assets/images/icn_edit.png" title="Edit">
					<input type="image" class="delete" src="../assets/images/icn_trash.png" title="Trash"></td>
				</tr>

				<tr class="addNew">
					<td><input type="text" class="form-control"></td>
					<td><input type="text" class="form-control"></td>
					<td><input type="text" class="form-control"></td>
					<td><input type="text" class="form-control"></td>
					<td><input type="image" class="add" src="../assets/images/icn_add_user.png" title="Add">
					<input type="image" class="edit" src="../assets/images/icn_edit.png" title="Edit" hidden="hidden">
					<input type="image" class="delete" src="../assets/images/icn_trash.png" title="Trash" hidden="hidden"></td>
				</tr>

			</tbody>
			</table>
			</div><!-- end of #tab1 -->

			<div id="tab2" class="tab_content">
			<table class="tablesorter" cellspacing="0">
			<thead>
				<tr>
    				<th>Summary</th>
    				<th>Description</th>
    				<th>Skills</th>
					<th>Contact info</th>
    				<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<tr>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
					<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="image" class="edit" src="../assets/images/icn_edit.png" title="Edit">
					<input type="image" class="delete" src="../assets/images/icn_trash.png" title="Trash"></td>
				</tr>
				<tr>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
					<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="image" class="edit" src="../assets/images/icn_edit.png" title="Edit">
					<input type="image" class="delete" src="../assets/images/icn_trash.png" title="Trash"></td>
				</tr>
				<tr>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
					<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="image" class="edit" src="../assets/images/icn_edit.png" title="Edit">
					<input type="image" class="delete" src="../assets/images/icn_trash.png" title="Trash"></td>
				</tr>
				<tr>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
					<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="image" class="edit" src="../assets/images/icn_edit.png" title="Edit">
					<input type="image" class="delete" src="../assets/images/icn_trash.png" title="Trash"></td>
				</tr>
				<tr>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
					<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="image" class="edit" src="../assets/images/icn_edit.png" title="Edit">
					<input type="image" class="delete" src="../assets/images/icn_trash.png" title="Trash"></td>
				</tr>
			</tbody>
			</table>

			</div><!-- end of #tab2 -->

			<div class="tab_container">
			<div id="tab3" class="tab_content">
			<table class="tablesorter" cellspacing="0">
			<thead>
				<tr>
    				<th>Title</th>
    				<th>Summary</th>
    				<th>Description</th>
					<th>Contact info</th>
    				<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<tr>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
					<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="image" class="edit" src="../assets/images/icn_edit.png" title="Edit">
					<input type="image" class="delete" src="../assets/images/icn_trash.png" title="Trash"></td>
				</tr>
				<tr>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
					<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="image" class="edit" src="../assets/images/icn_edit.png" title="Edit">
					<input type="image" class="delete" src="../assets/images/icn_trash.png" title="Trash"></td>
				</tr>
				<tr>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
					<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="image" class="edit" src="../assets/images/icn_edit.png" title="Edit">
					<input type="image" class="delete" src="../assets/images/icn_trash.png" title="Trash"></td>
				</tr>
				<tr>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
					<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="image" class="edit" src="../assets/images/icn_edit.png" title="Edit">
					<input type="image" class="delete" src="../assets/images/icn_trash.png" title="Trash"></td>
				</tr>
				<tr>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
					<td><input type="text" class="form-control" value="cena@gmail.com" disabled=""></td>
    				<td><input type="image" class="edit" src="../assets/images/icn_edit.png" title="Edit">
					<input type="image" class="delete" src="../assets/images/icn_trash.png" title="Trash"></td>
				</tr>

			</tbody>
			</table>
			</div><!-- end of #tab3 -->

            </div><!-- end of .tab_container -->
        </div><!-- end of .tab_container -->

		</article><!-- end of content manager article -->

	</section>

</div>

<s:include value="partials/footer.jsp"/>

<!-- Back to top button -->
	<a id="scroll-up" href="#"><i class="ti-angle-up"></i></a>
	<!-- END Back to top button -->

	<script src="../assets/js/grayscale.js"></script>

</body>

</html>