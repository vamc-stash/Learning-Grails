package notes

class Customer {

	String name
	String email
	String password
	static hasMany=[records:Record]

    static constraints = {
    	name(nullable:true, maxSize:255)
    	email(email:true, unique:true)
    	password(password: true, minSize: 8, matches: "^([a-zA-Z]+)([0-9]+)")
    }


}
