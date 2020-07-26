<g:form controller="admin" action="register" method="post">
 <App:emailField email="${flash?.user?.email}"/>
 <App:passwordField password="${flash?.user?.password}"/>
 <g:submitButton type="submit" class="btn btn-primary" value="Register Admin" name="register"/>
</g:form>