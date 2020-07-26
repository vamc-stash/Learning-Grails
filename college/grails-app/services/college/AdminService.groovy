package college

import grails.gorm.transactions.Transactional

@Transactional
class AdminService {

 def save(String email, String password) {
 	def userInstance = Admin.findByEmail(email)
 	if(!userInstance){
 		userInstance = new Admin(email:email, password:password, role:'ADMIN')
 		try{
 			userInstance.save(failOnError:true)
 			return true
 		} catch(Exception e){
 			//deal with exception
 			//render e
 		}
 	}
 	return false
 }
}
