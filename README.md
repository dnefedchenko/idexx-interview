# idexx-interview
IDEXX Interview Task

## Build Sequence

 Hence project uses Maven as a build tool it could be built using command below:
 
 `mvn clean package`
 
  Entire project consists of two modules: backend and frontend. Backend represents Spring Boot application. 
 Frontend is Angular CLI application. Final build artifact is excecutable self-containing jar file. It contains
 both backend and frontend parts. If build command above was successful issue next command to run the application:
 
  `java -jar backend/target/Backend-1.0-SNAPSHOT.jar`
  
  If there's an output similar to one below - application is up and running:
  
  > 2018-11-04 21:45:13.425  INFO 45806 --- [main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
  > 2018-11-04 21:45:13.430  INFO 45806 --- [main] com.idexx.AlbumsBooksApplication         : Started AlbumsBooksApplication in 3.186 seconds (JVM running for 3.693) 
  
  As could be seen from the output application is accessible by url **http://localhost:8080**
  
## Actuator

 Application exposes two public endpoints for a health-check and info which are accessible by urls *http://localhost:8080/actuator/health* and 
 *http://localhost:8080/actuator/info* respectively. There are much more metrics application could provide but for the purposes 
 of this interview task bare minimum were configured.
 
 ## Justification & Architecture
 
   Since this is a small web application there was a decision took to pick Spring Boot with embedded 
  Tomcat container. It's just the job for the serving required content and fulfill performance requirements. As for the frontend
  part Angular 5 + Prime Faces(CSS templating) were chosen. The framework provides all necessary functionality out of box to 
  build search form and render search results in tabular view.
   Backend and frontend functionality of the project splitted up onto two maven modules. First module is built as a regular 
  java application. Packaging type is **jar**. Second module(frontend) utilizes maven-frontend-plugin to build typescript 
  sources. It actually does following things:
  
   - installs node and npm if necessary
   - installs project dependencies
   - runs frontend part(useful during development phase - hot reload etc.)
  
   This plugin does one more additional important thing. During entire project build it copies transpiled and minified 
  typescript files into **backend/src/main/resources/static** folder. This step is necessary to include client side code into 
  the excecutable jar file. So, once application is up and running UI part is already included into it. As the result, when 
  browser is opened on **http://localhost:8080/** user is presented with search field and button to trigger this search.
