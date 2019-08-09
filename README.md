# pokeapi

# Project Architecture
![Project Architecture Diagram](https://user-images.githubusercontent.com/22007575/62767266-33dfbf00-ba8c-11e9-9003-490be8bdff42.PNG)

# MicroServices
### Mongo DB
The mongo database contains the search history for the application. Documents are persisted through the AuditConsumer. This service is availabl over port *27017*.
### AuditConsumer
The AuditConsumer service listens for messages on activeMQ queue and then persists the received message to a mongo database. The messages are search history entries descrbing who was searching, what was queried and when the query occured. This service communicates over port *8081*.
