<div>
	<div class="form-group">
		<label for="notename">
			<span>
				<b>File Name:</b>
				<g:if test="${flash?.error}">
					<div class="alert alert-danger" role="alert">
						${flash?.error}
					</div>
				</g:if>
			</span>
		</label>
		<input type="text" name="notename" class="form-control" placeholder="Notes Name" value="${lastSavedNote?.notename}">
	</div>
	<div class="form-group">
		<textarea name="notes" class="form-control" rows="15" placeholder="Write here...">${lastSavedNote?.notes}</textarea>
	</div>
    <button type="submit" class="btn btn-primary">save notes</button>
</div>