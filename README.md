# hypersign-auth-java-sdk
Java SDK to intergrate Hypersign passwordless authentication with Node js backend


# Developer setup

Downlaod and install Java 1.8 and above

- Clone the repo and import as a Gradle project into Intellj or Eclipse.
- Build the project - `Gradle clean build`
- Before publishing jar to maven local repo, go to gradle.properties and increment version
- Publish the snapshot version of the jar to local maven - `Gradle clean publishToMavenLocal`

# How to run demo application with hypersign java sdk ?
- Install tomcat 8.5 in your system https://tomcat.apache.org/download-80.cgi
- go to demo/spring-mvc-gradle
- change the hypersign jar with the latest published jar.
  compile "id.hypersign:hypersign:{REPALCE_ME}-SNAPSHOT"
- Build the war of demo application  - `gradle war`
- You should see buid/libs/spring-mvc.war
- Copy the war to tomcat/webapps/ folder and start the tomcat
- Access demo application on http://localhost:8080/spring-mvc/
