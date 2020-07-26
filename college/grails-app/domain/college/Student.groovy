package college

class Student extends Person{

	static hasMany = [courses:Course]

 static constraints = {
 	courses nullable:true
 }
}
