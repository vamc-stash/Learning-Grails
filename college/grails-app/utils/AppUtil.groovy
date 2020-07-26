package college

import org.grails.web.util.WebUtils

public class AppUtil{

 static def getAuthSession(){
  WebUtils.retrieveGrailsWebRequest().session
 }
}