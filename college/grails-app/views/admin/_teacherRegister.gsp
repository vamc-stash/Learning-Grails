<g:form controller="teacher" action="register" method="post">
	<App:emailField email="${flash?.user?.email}"/>
	<App:passwordField password="${flash?.user?.password}"/>
	<div class="form-group">
  <label for="course">Select Course:</label>
		<g:select name="course" from="${courses}" value="${courses?.cid}" optionKey="id" class="form-control"/>
	</div>
	<g:submitButton type="submit" class="btn btn-primary" value="Register Teacher" name="register"/>
</g:form> 