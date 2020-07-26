package college

class Person {

	String name
	String email
	String password
	String role

	static constraints = {

		name(nullable:true)
		email(email:true, unique:true)
		password(password:true)
		role(inList:['ADMIN','TEACHER','STUDENT'])
	}

	static mapping = {
		version false
	}

	def beforeInsert (){
		this.password = this.password.encodeAsBase64()
	}


	def beforeUpdate(){
		this.password = this.password.encodeAsBase64()
	}
}
