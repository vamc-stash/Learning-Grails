<g:form controller="course" action="register" method="post">
 <div class="form-group">
 	<label for="cid">Course ID:</label>
 	<g:textField name="cid" placeholder="Course ID" value="" class="form-control" required="true" />
 </div>
 <div class="form-group">
 	<label for="title">Course Title:</label>
 	<g:textField name="title" placeholder="Course Title" value="" class="form-control" required="true"/>
 </div>
 <div class="form-group">
 	<label for="credits">Course Credits:</label>
 	<input type="number" name="credits" placeholder="Course Credits" value="" class="form-control" required="true"/>
 </div>
 <g:submitButton type="submit" class="btn btn-primary" value="Register Course" name="register"/>
</g:form>