package college

class AppTagLib {
 //static defaultEncodeAs = [taglib:'html']
 //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
 static namespace = "App"

 def emailField = {attr, body ->
 	out << '<div class="form-group">'
  out << '<label for="email">Email Address:</label>'
  out << g.textField(name: "email", placeholder: "Email", value: attr.email, class: "form-control", required: "true", id: attr.id)
  out << '</div>'
 }

 def passwordField = {attr, body ->
  out << '<div class="form-group">'
  out << '<label for="password">Password:</label>'
  out << g.passwordField(name: "password", placeholder: "Password", value: attr.password, class: "form-control", required: "true", id: attr.id)
  out << '</div>'
 }

 def message = {attr, body ->
  if(attr.status == true) {
   out << '<div class="alert alert-success">'
   out << '<strong>'
   out << attr.msg 
   out << '</strong>'
   out << '</div>'
  }
  if(attr.status == false) {
   out << '<div class="alert alert-danger">'
   out << '<strong>'
   out << attr.msg 
   out << '</strong>'
   out << '</div>'
  }
 }
}
