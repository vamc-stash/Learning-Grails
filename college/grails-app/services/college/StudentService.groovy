package college

import grails.gorm.transactions.Transactional

@Transactional
class StudentService {

	def save(String email, String password) {
 	def studentInstance = Student.findByEmail(email)
 	if(!studentInstance){
 		studentInstance = new Student(email:email, password:password, role:'STUDENT')
 		try{
 			studentInstance.save(failOnError:true)
 			return true
 		} catch(Exception e){
 			//deal with exception
 			render e
 		}
 	}
 	return false
 }

 def doRegisterCourse(Student student, Course course) {

  if(!Student.findById(student.id).courses.contains(course.id)){
   def studentInstance = Student.findById(student.id)
   studentInstance.addToCourses(course)
   try{
    studentInstance.save(failOnError:true)
    return true
   } catch(Exception e){
     //deal with exception
     render e
   }
  }
 	
  return false
 }

 def doDeregisterCourse(Student student, Course course) {

  if(!Student.findById(student.id).courses.contains(course.id)){
   def studentInstance = Student.findById(student.id)
   studentInstance.removeFromCourses(course)
   try{
    studentInstance.save(failOnError:true)
    return true
   } catch(Exception e){
     //deal with exception
     render e
   }
  }
  
  return false
 }


 def getCourses(Student student){
  return Student.findById(student.id).courses.findAll()
 }
}
