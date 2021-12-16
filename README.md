# Spotippos
Properties on another planet.

The application was built with Java 8 using spring boot framework and for persistence purposes the Postgres SQL was selected as candidate.

This app also implements the Swagger specification for documentation.

The application deploy was built to work with Docker, so you'll need to install Docker Engine and Docker Compose to run the app.
It's possible to run with local environment, but you'll need to install and run a postgres sql and expose the default port 5432 at localhost. 

For docker engine installation, check [here](https://www.docker.com/get-docker).
<br />
For docker compose installation, check [here](https://docs.docker.com/compose/install/).

### Running instructions
1. ```chmod a+x gradlew```
2. ```./gradlew build```
3. ```cd dist/```
4. ```docker-compose up --build -d```

After execute this steps, the app will be ready to be used at ```http://localhost:8080```.
<br />
The app container binds it's port 8080 with the local port 8080, so make sure you have this port free to be allocated.
<br />
The docker compose will start two containers, one with a Postgres SQL (used as database for this app), 
and another with the Java application.

### Testing instructions

If you don't have a HTTP request tool like cURL or Postman, then a UI to test the API is available at ```http://localhost:8080/swagger-ui.html```

The search endpoint is paginated and the default value for page size is 20, if you need more, just indicate it in query string. 
Both example request are valid for search:

GET localhost:8080/properties?ax=0&ay=1000&bx=1400&by=0
<br />
or 
<br />
GET localhost:8080/properties?ax=0&ay=1000&bx=1400&by=0&page=2&size=1000


After test, just stop the containers with ```docker-compose stop```.

#### Swagger resources

1. ```/swagger-ui.html``` - UI to test the application API.
2. ```/swagger-resources``` - Swagger specs and info.
3. ```/v2/api-docs``` - API docs in swagger format.

#### Database specification (in case of running a local postgres)
1. Database: spotippos
2. Username: spotippos
3. Password: spotippos


###### Author: Caio Maia (caaiomaia@gmail.com)
