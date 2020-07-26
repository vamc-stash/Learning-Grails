package college

import grails.gorm.transactions.Transactional

@Transactional
class AuthService {

	private static final String AUTHENTICATED = 'AUTHENTICATED'

 boolean isAuthenticated() {
 	return (getAuthentication()?.isAuth? true: false)
 }

 def getAuthentication(){
 	return AppUtil.getAuthSession()[AUTHENTICATED]
 }

 private def setAuthentication(Person user){
 	if(user){
 		def auth = [isAuth: true, user: user]
 		AppUtil.getAuthSession()[AUTHENTICATED] = auth
 	}else{
 		def auth = [isAuth: false, user: user]
 		AppUtil.getAuthSession()[AUTHENTICATED] = auth
 	}
 }

 def getRole(){
 	return getAuthentication().user.role.toLowerCase()
 }

 def doLogin(String email, String password){
 	password = password.encodeAsBase64()

 	def user = Person.findByEmail(email)
 	if(user?.password && user.password.equals(password)){
 		setAuthentication(user)
 		return true
 	}
 	setAuthentication(null)
 	return false
 }

 def doLogout(){
 	setAuthentication(null)
 }

}
