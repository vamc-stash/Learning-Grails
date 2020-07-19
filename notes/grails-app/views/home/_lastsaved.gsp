<div class="input-group mb-3" style="width: 50%;">
    <input type="text" name="notename" class="form-control" placeholder="Notes Name" value="${lastSavedNote?.notename}">
    <textarea name="notes" class="form-control" placeholder="Write here...">${lastSavedNote?.notes}</textarea>
    <button type="submit" class="btn btn-primary">save/update notes</button>
</div>