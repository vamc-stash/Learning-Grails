package college

class StudentController {

 AuthService authService
 StudentService studentService
 CourseService courseService

 def index() {
  redirect(action:'home')
 }

 def home() { 
  def user = authService.getAuthentication().user
  def courses = courseService.show()
  def usercourses = studentService.getCourses(user)
  render(view:'home', model:[courses:courses, user:user, ucourses:usercourses])
 }

 def register() {
  if(params?.email && params?.password){
   if(studentService.save(params.email, params.password)) {
    flash.message = [info:'Registration is Success', success:true]
   }
   else{
    flash.message = [info:'Student with same ID Already Exists', , success:false]
   }
  }
  
  redirect(controller:'admin', action:'home', fragment:"student")
 }

 def registerCourse() {

  if(params?.id){
   def courseInstance = Course.get(params.id)
   def user = authService.getAuthentication().user
   if(studentService.doRegisterCourse(user, courseInstance)){
    flash.message = [info:'Registration is Success', success:true]
   }
   else{
    flash.message = [info:'Already Registered', , success:false]
   }
  }
    redirect(action: 'home')
 }

 def deregisterCourse() {

  if(params?.id){
   def courseInstance = Course.get(params.id)
   def user = authService.getAuthentication().user
   if(studentService.doDeregisterCourse(user, courseInstance)){
    flash.message = [info:'De registration is Success', success:true]
   }
   else{
    flash.message = [info:'Already De-Registered', , success:false]
   }
  }
    redirect(action: 'home')
 }
}
