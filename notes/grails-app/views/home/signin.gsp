<!doctype html>
<html>
<head>
    <title>SignIn</title>
    <asset:stylesheet src="bootstrap.css" rel="stylesheet"/>
</head>

<body>
	<g:link url="[controller: 'home', action: 'signup']">New User?</g:link>
	<g:form controller="home" action="welcome" method="post">
	    <div class="input-group mb-3" style="width: 50%;">
	        <input type="text" name="email" class="form-control" placeholder="Email">
	        <input type="password" name="password" class="form-control" placeholder="Password">
	        <button type="submit" class="btn btn-primary">submit</button>
	    </div>
	</g:form>


 	<g:javascript library="jquery"/>
	<script src="javascripts/bootstrap.min.js"></script>
</body>
</html>