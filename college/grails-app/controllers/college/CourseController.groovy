package college

class CourseController {

	CourseService courseService 

 def register() {
  if(params?.cid && params?.title && params?.credits){
   if(courseService.save(params.cid, params.title, params.credits)) {
    flash.message = [info:'Registration is Success', success:true]
   }
   else{
    flash.message = [info:'Course with same ID Already Exists', success:false]
   }
  }
  redirect(controller:'admin', action:'home', fragment:"course")
 }
}
