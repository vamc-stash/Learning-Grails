<!doctype html>
<html>
<head>
 <title>Welcome Student</title>
 <meta name="layout" content="basic">
 <asset:stylesheet src="bootstrap.css" rel="stylesheet"/>
</head>

<body>
	<content tag="nav">
		<ul class="navbar-nav">
	  <li class="nav-item">
				<g:link url="[controller: 'auth', action: 'logout']">Logout</g:link>
			</li>
	 </ul>
	</content>
	<div class="row">
		<div class="col align-self-center">
			<h3>Welcome, ${user.email}</h3>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<h3>Courses Available:</h3>
			<table class=".table-bordered">
				<thead>
					<tr>
						<th>S.No</th>
						<th>Course ID</th>
						<th>Course Title</th>
						<th>Register</th>
						<th>De-register</th>
					</tr>
				</thead>
				<tbody id="courses-body">
					<g:each in="${courses}">
						<tr>
							<td id="${it.id}" name="courseid">${it.id}</td>
							<td id="${it.cid}" name="courseid">${it.cid}</td>
							<td id="${it.title}" name="courseid">${it.title}</td>
							<td>
									<g:link name="course-reg" controller="student" action="registerCourse" id="${it.id}" >register</g:link>
							</td>
							<td>
									<g:link name="course-de-reg" controller="student" action="deregisterCourse" id="${it.id}" >de-register</g:link>
							</td>
						</tr>
					</g:each>
				</tbody>
			</table>
		</div>
		<div class="col">
			<h3>Your Registered Courses:</h3>
			<table class=".table-bordered">
				<thead>
					<tr>
						<th>Course ID</th>
						<th>Course Title</th>
						<th>Course.credits</th>
					</tr>
				</thead>
				<tbody id="courses-body">
					<g:each in="${ucourses}">
						<tr>
							<td id="${it.cid}" name="courseid">${it.cid}</td>
							<td id="${it.title}" name="courseid">${it.title}</td>
							<td name="courseid">${it.credits}</td>
						</tr>
					</g:each>
				</tbody>
			</table>
		</div>
	</div>
	


 	<g:javascript library="jquery">
 		
 	</g:javascript>
	<script src="javascripts/bootstrap.min.js"></script>
</body>
</html>