<!doctype html>
<html>
<head>
    <title>SignUp</title>
    <meta name="layout" content="main">
    <asset:stylesheet src="bootstrap.css" rel="stylesheet"/>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col align-self-center">
				<g:if test="${flash?.message}">
					<p class="alert alert-danger" role="alert">
						${flash?.message}
					</p>
				</g:if>
			</div>
		</div>

		<div class="row">
			<div class="col align-self-center">
				<g:form controller="customer" action="save" method="post">
					<div class="form-group">
						<label for="name">Full Name:</label>
				        <input type="text" name="name" class="form-control" placeholder="Full Name">
				    </div>
					<div class="form-group">
						<label for="email">Email address:</label>
				        <input type="email" name="email" class="form-control" placeholder="Email">
				    </div>
				    <div class="form-group">
				    	<label for="email">Password:</label>
				         <input type="password" name="password" class="form-control" placeholder="Password">
				    </div>
				    <button type="submit" class="btn btn-primary">submit</button>
				</g:form>
				<g:link url="[controller: 'home', action: 'signin']">Already Registered User</g:link>
			</div>
		</div>
	</div>


 	<g:javascript library="jquery"/>
	<script src="javascripts/bootstrap.min.js"></script>
</body>
</html>