package college

class TeacherController {

 AuthService authService
 TeacherService teacherService
 CourseService courseService

 def index() {
  redirect(action:'home')
 }

 def home() { 
  def user = authService.getAuthentication().user
  def course = teacherService.getCourse(user)
  render(view:'home', model:[course:course, user:user])
 }

 def register() {
  if(params?.email && params?.password && params?.course){
   def courseInstance = Course.findById(params.course)
   if(teacherService.save(params.email, params.password, courseInstance)) {
    flash.message = [info:'Registration is Success', success:true]
   }
   else{
    flash.message = [info:'teacher with same ID Already Exists', , success:false]
   }
  }
  
  redirect(controller:'admin', action:'home', fragment:"student")
 }
}
