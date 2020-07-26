<!doctype html>
<html>
<head>
    <title>Login</title>
    <meta name="layout" content="basic">
    <asset:stylesheet src="bootstrap.css" rel="stylesheet"/>
</head>

<body>
	<div class="container">
  <div class="row">
   <App:message msg="${flash?.message?.info}" status="${flash?.message?.success}"/>
  </div>
		<div class="row">
			<div class="col align-self-center">
    <g:form controller="auth" action="login" method="post">
     <App:emailField email="${flash?.user?.email}"/>
     <App:passwordField password="${flash?.user?.password}"/>
     <g:submitButton type="submit" class="btn btn-primary" value="Login" name="login"/>
    </g:form>
   </div>
		</div>
	</div>
	
	


 	<g:javascript library="jquery">
 	</g:javascript>
	<script src="javascripts/bootstrap.min.js"></script>
</body>
</html>