# Implementing JWT based Authentication
 
To complete milestone 1, you'll need to implement the TODO comments found in:

    * java/com/manning/simplysend/services/impl/UserServiceImpl.java 
  
### Run the project

You can run the project by executing the docker-compose file (you'll need Docker Compose installed), which will bring both the database and app up, by running

    $ docker-compose up
    
Don't forget to clean everything up afterwards by calling

    $ docker-compose down
    
If running through gradle is desired, execute the following command on the current project directory (make sure to have a Postgres database running on port 5432 and update the file "resources/application.properties" by making "spring.datasource.url" point to your local machine instead of simplysenddb:5432): 

    $ gradle bootRun