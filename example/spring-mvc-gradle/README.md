spring-mvc-gradle
=================
A minimal Spring MVC example built using Java, Gradle and Jetty.  This is runnable using the embedded Jetty
server in gradle.

Run "gradle jettyRun" to start the web application.

A test page is located at http://localhost:8080/spring-mvc/.  Clicking the person link
will go to http://localhost:8080/spring-mvc/rest/person which returns a simple object as JSON data.
