<!doctype html>
<html>
<head>
    <title>Home</title>
    <meta name="layout" content="main">
    <asset:stylesheet src="bootstrap.css" rel="stylesheet"/>
    <asset:stylesheet src="home.css"/>
</head>

<body>
	<content tag="nav">
		<li>
			<g:link url="[controller: 'home', action: 'signup']">SignUp</g:link>
		</li>
		<li>
			<g:link url="[controller: 'home', action: 'signin']">SignIn</g:link>
		</li>
	</content>


 	<g:javascript library="jquery"/>
	<script src="javascripts/bootstrap.min.js"></script>
</body>
</html>