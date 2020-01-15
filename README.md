# Spring JPA & Quarkus

This repository contains the code that shows how to create a Quarkus application using Spring APIs for JPA.

**NOE** There is nothing special you need to do to use this, it's just what you get if you create a Quarkus application with Spring Web and Spring Data JPA and code up the example I did during the demo.

## How to play

- Install the [h2 database](http://h2database.com/html/installation.html) binary on your laptop
- Append an entry to h2 config file
  ```bash
  20=Generic H2 (Embedded)|org.h2.Driver|jdbc\:h2\:tcp\://localhost/mem\:quarkus_test|quarkus_test
  ```
- Open a terminal and launch the h2 server and console
   ```bash
   java -cp bin/h2-1.4.199.jar org.h2.tools.Server -ifNotExists
   TCP server running at tcp://localhost:9092 (only local connections)
   PG server running at pg://localhost:5435 (only local connections)
   Web Console server running at http://localhost:9090 (others can connect)
   ```
- Open the web console and check if you can connect ot the database
- Start the Quarkus application
  ```bash
   mvn clean compile quarkus:dev
   Listening for transport dt_socket at address: 5005
   2020-01-15 17:09:15,860 INFO  [io.agr.pool] (main) Datasource '<default>': Initial size smaller than min. Connections will be created when necessary
   2020-01-15 17:09:16,069 INFO  [io.quarkus] (main) spring-quarkus-demo1 1.0-SNAPSHOT (running on Quarkus 1.1.1.Final) started in 3.346s. Listening on: http://0.0.0.0:8080
   2020-01-15 17:09:16,071 INFO  [io.quarkus] (main) Profile dev activated. Live Coding activated.
   2020-01-15 17:09:16,071 INFO  [io.quarkus] (main) Installed features: [agroal, cdi, hibernate-orm, hibernate-orm-panache, jdbc-h2, narayana-jta, resteasy, resteasy-jackson, spring-data-jpa, spring-di, spring-web]
   ^C2020-01-15 17:11:19,605 INFO  [io.quarkus] (Quarkus Shutdown Thread) Quarkus stopped in 0.006s
  ```
- Execute the following query `SELECT * FROM BOOK BOOK ` using the Web console to get a list of Books or the H2 Shell
  ```bash
  java -cp bin/h2-1.4.199.jar org.h2.tools.Shell
  ...
  sql> SELECT * FROM BOOK;
  BID | NAME              | PUBLICATIONYEAR
  1   | Sapiens           | 2011
  2   | Homo Deus         | 2015
  3   | Enlightenment Now | 2018
  4   | Factfulness       | 2018
  5   | Sleepwalkers      | 2012
  6   | The Silk Roads    | 2015
  (6 rows, 21 ms)
  ```   