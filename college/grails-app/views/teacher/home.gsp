<!doctype html>
<html>
<head>
	<title>Welcome Teacher</title>
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
			<h5>You are assigned to ${course.title}, ${course}</h5>
		</div>
	</div>
	
	
		<g:javascript library="jquery">
		
		</g:javascript>
	<script src="javascripts/bootstrap.min.js"></script>
</body>
</html>