# Creature Keeper Demo Project

### TODO
* set versions in pom file properly
* enforce code style
* enforce unit test coverage (jacoco?)
* micrometer metrics added
* caffeine cache for what comes out of the db
* change user/pass of db to not be root :/ 
* close the db connection?

### If Time Allows
* Undo Flyway Migration files
* Async DB connection (jasync-sql)

### Intetionally Not Addressing
* 

### Security Focus
* Mapping internal error codes as they leave the system

### Resilience Focus
* Logback using SLF4J logging 

### Prerequisites
* Java (v11.0.2)
* Docker (v19.03.13)
* Flyway (v7.5.4)

### Interacting with MariaDB Container
You can open an interactive terminal in the mariadb container by running the following command:

```docker exec -it maria /bin/bash```

Then you can interact with the db by running: 

```mysql -u root -p```

Entering `root` as password when prompted for it. 
