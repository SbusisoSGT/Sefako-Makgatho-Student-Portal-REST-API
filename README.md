# Sefako-Makgatho-Student-Portal-REST-API
This repository contains a Spring Boot REST API for Sefako Makgatho registered student portal

## Steps to Setup the server-side app
1. **Clone the application**

	```bash
	git clone https://github.com/SbusisoSGT/Sefako-Makgatho-Student-Portal-REST-API.git
	cd Sefako-Makgatho-Student-Portal-REST-API
	```
  
2. **Create MySQL database**

	```bash
	create database sefako_makgatho
	```

3. **Change MySQL username and password as per your MySQL installation**

	+ open `src/main/resources/application.properties` file.

	+ change `spring.datasource.username` and `spring.datasource.password` properties as per your mysql installation
  
4. **Run the app**

	You can run the spring boot app by typing the following command -

	```bash
	mvn spring-boot:run
	```

	The server will start on port 8000.
  After running the app, spring will create database tables for all entities in the app

5. **Run Migrations**
    + open `src/main/resources/application.properties` file.
    + change the property `spring.flyway.enabled` to true. 
  
  Now re-run the application and spring boot will run all migrations in the folder `src/main/resources/db/migration` 

  #### The REST API is now ready to be consumed.
  
  
