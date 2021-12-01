Steps to Run Metadata API


Step 1: Pulling the Redis image from Docker hub and start it on port 6379. Execute the following commands on docker terminal –
## Docker commands
## Pulling redis image from docker hub
docker pull redis
 
## Running the container
docker run -d -p 6379:6379 --name my-redis redis

Step 2: Unzip the folder and import project into IntelliJ or any other IDE as maven project.

Step 3: Set up the maven lifecycle for clean and install and set up the application as springboot application (should be configured by default). 

Step 4: Run the maven install and once successful, run the application by clicking on the green button on the top right corner.
 
Step 5: Hit the below url to see the swagger open api documentation about the metadata api –
http://localhost:8080/swagger-ui.html

Step 6: Here are the url’s for testing different api’s :

Http Method		Uri			Description
GET		/v1/metadata			Get all metadata resources
GET		/v1/metadata/{title}		Get the specific resource
POST		/v1/metadata			Add the metadata in redis
PUT		/v1/metadata			Updates the existing resource
DELETE		/v1/metadata/{title}		Marks the specified resource for deletion







