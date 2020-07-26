package college

class AuthController {

	AuthService authService

 def index() { 
 	render(view:'login')
 }

 def login(){
  if(authService.isAuthenticated()){
  	redirect(controller: authService.getRole(), action: 'home')
  	return 
  }

  if(params?.email && params?.password){
  	if(authService.doLogin(params.email, params.password)){
  		flash.message = [info: g.message(code:'Login Successful'), success: true]
  		redirect(controller: authService.getRole(), action: 'home')
  	} else {
    flash.message = [info: 'Login Failure', success: false]
    flash.user = [email: params.email, password: params.password]
    redirect(view:'login')
  	}
  }
 }

 def logout(){
 	authService.doLogout()
 	flash.message = [info: g.message(code:'Log out Successful'), success: true]
 	redirect(controller:'auth', view:'login')
 	return
 }
}
