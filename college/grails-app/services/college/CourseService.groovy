package college

import grails.gorm.transactions.Transactional

@Transactional
class CourseService {

 def save(String cid, String title, String credits) {
 	def courseInstance = Course.findByCid(cid)
 	if(!courseInstance){
 		credits = Long.parseLong(credits)
 		courseInstance = new Course(cid:cid, title:title, credits:credits)
 		try{
 			courseInstance.save(failOnError:true)
 			return true
 		} catch(Exception e){
 			//deal with exception
 			render e
 		}
 	}
 	return false
 }

 def show() {
 	return Course.findAll()
 }

 def showAvailable() {
 	if(Teacher.count()>0)
 		return Course.findAll("select c from Course as c WHERE c.id NOT  IN (select p.course.id from Person as p WHERE p.role='TEACHER')")
 	return Course.findAll()
 }

}
