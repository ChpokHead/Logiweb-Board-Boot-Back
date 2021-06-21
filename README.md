# Logiweb Board Back
This is the Back-end part of the Logiweb Board application.
##How to use
There is only one endpoint "/orders" that you can use to recieve 10 latest orders in current month. App also has a Kafka consumer, that recieves Logiweb app
producer's messages and update database;
## Tech stack
App was built using Java and Spring Boot. PostgreSQL was used as a database server.
