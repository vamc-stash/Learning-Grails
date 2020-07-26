<!doctype html>
<html>
<head>
 <title>Welcome Admin</title>
 <meta name="layout" content="basic">
 <asset:stylesheet src="bootstrap.css" rel="stylesheet"/>
</head>

<body>
	<content tag="nav">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a href="#admin">+Admin</a>
			</li>
			<li class="nav-item">
				<a href="#course">+Course</a>
			</li>
			<li class="nav-item">
				<a href="#teacher">+Teacher</a>
			</li>
			<li class="nav-item">
				<a href="#student">+Student</a>
			</li>
	  <li class="nav-item">
				<g:link url="[controller: 'auth', action: 'logout']">Logout</g:link>
			</li>
	 </ul>
	</content>
	<div class="row" id="admin-form">
		<div class="col align-self-center">
			<App:message msg="${flash?.message?.info}" status="${flash?.message?.success}"/>
			<g:render template="adminRegister"/>
		</div>
	</div>
	<div class="row" id="course-form">
		<div class="col align-self-center">
			<App:message msg="${flash?.message?.info}" status="${flash?.message?.success}"/>
			<g:render template="courseRegister"/>
		</div>
	</div>
	<div class="row" id="teacher-form">
		<div class="col align-self-center">
			<App:message msg="${flash?.message?.info}" status="${flash?.message?.success}"/>
			<g:render template="teacherRegister"/>
		</div>
	</div>
	<div class="row" id="student-form">
		<div class="col align-self-center">
			<App:message msg="${flash?.message?.info}" status="${flash?.message?.success}"/>
			<g:render template="studentRegister"/>
		</div>
	</div>
	


 	<g:javascript library="jquery">
 		$(document).ready(function(){
 			$(".row").css("display","none")
 			$("a[href='#admin']").click(function(){
 				$(".row").css("display","none")
 				$("#admin-form").css("display","block")
 			});
 			$("a[href='#course']").click(function(){
 				$(".row").css("display","none")
 				$("#course-form").css("display","block")
 			});
 			$("a[href='#teacher']").click(function(){
 				$(".row").css("display","none")
 				$("#teacher-form").css("display","block")
 			});
 			$("a[href='#student']").click(function(){
 				$(".row").css("display","none")
 				$("#student-form").css("display","block")
 			});
 		})
 	</g:javascript>
	<script src="javascripts/bootstrap.min.js"></script>
</body>
</html>