# Installation and Running Instructions

## DATABASE SETUP

##### Connect with the MySQL/MariaDB server
~~~
sudo mysql -u root -p
~~~

##### Create DB user
~~~
create user 'listedcompanies'@'localhost' identified by 'tere';
~~~

##### Create DB
~~~
CREATE DATABASE listedcompanies CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
~~~

##### Grant privileges to the DB user
~~~
grant all privileges on listedcompanies.* to 'listedcompanies'@'localhost';
~~~

## BUILD
Navigate to the project root folder and then...
~~~
./gradlew clean build (Linux)
~~~
...or...
~~~
gradlew clean build (Windows)
~~~


## RUN APPLICATION

Navigate to the project root folder and then...
~~~
./gradlew bootRun (Linux)
~~~
...or...
~~~
gradlew bootRun (Windows)
~~~
...or...
~~~
java -jar build/libs/listed-companies-api.jar
~~~
