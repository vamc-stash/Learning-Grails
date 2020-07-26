package college

import grails.gorm.transactions.Transactional

@Transactional
class TeacherService {

 def save(String email, String password, Course course) {
 	def teacherInstance = Teacher.findByEmail(email)
 	if(!teacherInstance){
 		teacherInstance = new Teacher(email:email, password:password, role:'TEACHER', course:course)
 		try{
 			teacherInstance.save(failOnError:true)
 			return true
 		} catch(Exception e){
 			//deal with exception
 			render e
 		}
 	}
 	return false
 }

 def getCourse(Teacher teacherInstance){
 	return Course.find("select C from Course C, Teacher T where T.id = :tid and C.id = T.course.id",[tid:teacherInstance.id])
 }
}
