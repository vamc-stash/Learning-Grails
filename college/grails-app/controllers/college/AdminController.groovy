package college

class AdminController {

 AdminService adminService 
 CourseService courseService

 def index() {
  def courses = courseService.showAvailable()
  render(view:'home', model:[courses:courses])
 }

 def home() { 
  def courses = courseService.showAvailable()
 	render(view:'home', model:[courses:courses])
 }

 def register() {
  if(params?.email && params?.password){
   if(adminService.save(params.email, params.password)){
    flash.message = [info:'Registration is Success', success:true]
   }
   else{
    flash.message = [info:'User Already Exists', , success:false]
   }
  }
  def courses = courseService.showAvailable()
  render(view:'home', model:[courses:courses])
 }
}
