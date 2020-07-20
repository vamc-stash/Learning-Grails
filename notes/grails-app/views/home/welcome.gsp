<!doctype html>
<html>
<head>
    <title>Welcome</title>
     <meta name="layout" content="main">
    <asset:stylesheet src="bootstrap.css" rel="stylesheet"/>
    <asset:javascript src="application.js"/>
</head>

<body>
	<content tag="nav">
		<li>
			<g:link url="[controller: 'home', action: 'signout']">Logout</g:link>
		</li>
	</content>
	<div class="container-fluid">
		<div class="row">
			<div class="col align-self-center">
				<h4>Welcome ${user.email}</h4>
			</div>
		</div>
		<div class="row">
			<h1></h1>
		</div>
		<div class="row">
			<div class="col-sm-10">
				<div id="lastsaved-container">
					<g:if test="${lastSavedNote?.notename == null || flash?.error}">
						<g:form controller="home" action="save" method="post">
					    	<g:render template="lastsaved"/>
				        </g:form> 
				    </g:if>
				    <g:else>
						<g:form class="form-group" controller="home" action="update" id="${lastSavedNote.id}" method="post">
						   <g:render template="lastsaved"/>
						</g:form> 
					</g:else>
				</div>
				<div id="newnote-container">
					<g:form controller="home" action="save" method="post">
				    	<g:render template="newnote"/>
			        </g:form> 
				</div>
				<p></p>
				<button id="newnote" class="btn btn-secondary" type="submit" name="createnote" >Create New Note</button>
			</div>

			<div class="col-sm-2">
				<div class="row">
					<h1></h1>
				</div>
				<div class="row no-gutters" >
					<h3>NOTES BIN</h3>
				</div>
				<div class="row no-gutters">
					<div class="table-responsive">
						<table class=".table-bordered">
							<tbody id="note-bin">
								<g:each in="${records}">
									<tr>
										<td id="${it.id}" name="mynote">${it.id}. ${it.notename}</td>
										<td>
											<div id="viewnote-container">
												<g:form name="view-note" controller="home" action="edit" id="${it.id}" method="post">
										        </g:form> 
											</div>
										</td>
									</tr>
								</g:each>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	</div>
	


 	<g:javascript library="jquery">
 	$(document).ready(function(){
 		$("#newnote-container, #viewnote-container").css("display","none")
 		$("#newnote").click(function(){
 			$("#newnote-container").css("display","block")
 			$("#lastsaved-container").css("display","none")
 		})


 		$("#note-bin").on("click", "tr", function(){

 			console.log($(this).children("td:first").attr('id'))
 			console.log($(this).children("td:nth-child(2)").find("div").find("form").attr('name'))
 			var thisnote = $(this).children("td:nth-child(2)").find("div").find("form")
 			$(thisnote).submit()
 		})

 	})
		
 	</g:javascript>
	<script src="javascripts/bootstrap.min.js"></script>
</body>
</html>