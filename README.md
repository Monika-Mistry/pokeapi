# pokeapi

# Project Architecture
![Project Architecture Diagram](https://user-images.githubusercontent.com/22007575/62773974-79f04f00-ba9b-11e9-804e-3155b092ccee.PNG)

# MicroServices
### Mongo DB
The mongo database contains the search history for the application. Documents are persisted through the AuditConsumer. This service is availabl over port *27017*.
### AuditConsumer
The AuditConsumer service listens for messages on activeMQ queue and then persists the received message to a mongo database. The messages are search history entries descrbing who was searching, what was queried and when the query occured. This service communicates over port *8081*.
