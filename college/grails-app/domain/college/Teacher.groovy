package college

class Teacher extends Person{

 static belongsTo = [course:Course]

 static constraints = {
 }
}
