package college


class AuthInterceptor {

	AuthService authService

	AuthInterceptor(){
		matchAll()
		.excludes(controller:'auth', action:'login')
	}

 boolean before() {

 	if(!authService.isAuthenticated()){
 		redirect(controller:'auth', action:'login')
 		return false
 	} 

 	return true 
 }

 boolean after() { true }

 void afterView() {
     // no-op
 }
}
