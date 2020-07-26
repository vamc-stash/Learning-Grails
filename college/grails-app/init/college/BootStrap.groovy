package college

class BootStrap {

    def init = { servletContext ->

    	new college.Admin(name:"ADMIN1", email:"admin1@mail.com", password:"admin1", role:"ADMIN").save()
    	new college.Admin(name:"ADMIN2", email:"admin2@mail.com", password:"admin2", role:"ADMIN").save()

    }
    def destroy = {
    }
}
