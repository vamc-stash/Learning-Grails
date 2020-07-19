<!doctype html>
<html>
<head>
    <title>Welcome</title>
    <asset:stylesheet src="bootstrap.css" rel="stylesheet"/>
    <asset:javascript src="application.js"/>
</head>

<body>
	<!-- <g:link url="[controller: 'home', action: 'signin']">Go to SignIn Page</g:link> -->
	<div>
		<h4>welcome ${user.email}</h4>
	</div>
	<div>
		<div id="lastsaved-container">
			<g:if test="${lastSavedNote?.notename == null}">
				<g:form controller="record" action="save" method="post">
			    	<g:render template="lastsaved"/>
		        </g:form> 
		    </g:if>
		    <g:else>
				<g:form controller="record" action="update" id="${lastSavedNote.id}" method="post">
				   <g:render template="lastsaved"/>
				</g:form> 
			</g:else>
		</div>
		<button id="newnote" class="btn btn-primary" type="submit" name="createnote" >New Note</button> 
		<div id="newnote-container">
			<g:form controller="record" action="save" method="post">
		    	<g:render template="newnote"/>
	        </g:form> 
		</div>
		<div>
			<p>Saved Notes:</p>
			<g:each in="${records}">
				<p>${it.notename}</p>
			</g:each>
		</div>
		
	</div>



 	<g:javascript library="jquery">
 	$(document).ready(function(){
 		$("#newnote-container").hide()
 		$("#newnote").click(function(){
 			$("#newnote-container").show()
 			$("#lastsaved-container").hide()
 		})
 	})
		
 	</g:javascript>
	<script src="javascripts/bootstrap.min.js"></script>
</body>
</html>