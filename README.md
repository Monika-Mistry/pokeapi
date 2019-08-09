# pokeapi

# Project Architecture
![Project Architecture Diagram](https://user-images.githubusercontent.com/22007575/62773974-79f04f00-ba9b-11e9-804e-3155b092ccee.PNG)

# MicroServices
### Mongo DB
The mongo database contains the search history for the application. Documents are persisted through the AuditConsumer. This service is available over port *27017*.
### AuditConsumer
The AuditConsumer service listens for messages on activeMQ queue and then persists the received message to a mongo database. The messages are search history entries descrbing who was searching, what was queried and when the query occured. This service communicates over port *8081*.
### ActiveMQ
The ActiveMQ Service is the broker (queue) between AuditConsumer and HistoryProducer. Internally (between microservices), this service communicates over port *61616*. The user interface for this service is available over port *8161*.
### HistoryProducer
The HistoryProducer service sends messages to the activeMQ queue whenever a successful search occurs (the user exists in the database and a performs a search to the pokeapi). The messages descrbe who was searching, what was queried and when the query occured. This service is available over port *[PORT]*
### Search
The Search service is responsible for sending HTTP Requests to the [pokeapi](https://pokeapi.co/). It offers two functionalities to query pokemon via the pokeapi, *findById* and *findByName*. This service is available over port *[PORT]*.
### User
The User service is responsible for persisting users to a H2 database and validating that a user exists in the system. If a user exists in the system, they are then allowed to perform a query to the pokeapi. This service is available over port *[PORT]*.
### Core
The core service is responsible for handling the requests directly from the user. This service is available over port *[PORT]*
