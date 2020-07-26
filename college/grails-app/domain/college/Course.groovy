package college

class Course {

	String cid
	String title
	Long credits

	// static hasMany = [students:Student]
	// static belongsTo = [teacher:Teacher]

 static constraints = {
 	cid unique:true
 }

 @Override
 String toString(){
  return cid
 }
}
