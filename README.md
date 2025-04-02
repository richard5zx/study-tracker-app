# Full Stack Study Tracker Web App

## Motivation
Started this project to help me upskill in the area of Java Web Development to land a job in the IT field in Australia. The purpose of the app is to track the time that is used for studying and study the habits of an individual.

## Tech used
Backend: Java, JPA
Frontend: Node.js, Vue.js, JavaScript, HTML, CSS

## Backend

### Database setup
Open up MySQL\
Create a database in MySQL
```script
mysql> CREATE DATABASE study_tracker;
```

Check if database is created using
```script
mysql> show databases;
```

Enter todolist database
```script
mysql> USE study_tracker;
```

Create "user" table in the database
```script
mysql> CREATE TABLE user (
    user_id int NOT NULL AUTO_INCREMENT,
    firstname varchar(255) NOT NULL,
    firstname varchar(255) NOT NULL,
    username varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    date_joined TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id)
);
```

Create "study_history" table in the database
```script
mysql> CREATE TABLE study_history (
    history_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    start_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    end_time TIMESTAMP,
    total_time int,
    PRIMARY KEY (history_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);
```
Check details of table
```script
mysql> DESCRIBE user;
mysql> DESCRIBE study_history;
```

## Frontend
