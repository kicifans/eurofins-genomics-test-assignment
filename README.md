--------------------
SETTING UP & RUNNING APPLICATION AND MYSQL USING DOCKER
--------------------
1. Setting up mysql:  
1.1. pull mysql docker image with this command:  
>docker pull mysql 

1.2. run mysql docker image with prepared enviroment variables, creating schema :  
>docker run -p 3307:3306 --name=homework_db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=eurofins_homework mysql

2. making of docker network and connecting to it  
2.1. creating new docker network:   
>docker network create eurofins-homework-net  

2.2 run this command to connect db to new network:  
>docker network connect eurofins-homework-net homework_db

3. Pull application from GitHub  
>git clone https://github.com/kicifans/eurofins-genomics-test-assignment.git  

4. building and running rest api, connecting to network  
4.1. build application from application directory using command:  
>mvn clean install  

4.2. build docker image using command:  
>docker build -t eurofins-genomics-rest-app .  

4.3. run this command to run rest api:  
>docker run -p 9090:8080 --name eurofins-genomics-rest-app --net eurofins-homework-net -e MYSQL_HOST=homework_db -e MYSQL_PORT=3306 eurofins-genomics-rest-app  
--------------------
Available endpoints:
--------------------
Search country by IP. Additionaly saves information about country and searched ip in database  
http://localhost:9090/country-by-ip/{ip}  

Search universities by country  
http://localhost:9090/universities/{country}  

Get all audit records for searched IP/Countries  
http://localhost:9090/audit/  
 
--------------------
Additional info:  
--------------------

Tech used:  
Java11  
MYSQL  
Docker  
Maven  
Lombok  
SpringBoot  
Jackson  
---------------------
Additional things added, but would need some more work of:  
1.Exception added only to see if input IP address pattern id right. Should add more feedback from service, if responses or values inserted aren't as expected 
2.Added few basic tests to see if endpoints return same value as using services manualy.  
3.README formatting could use some work. 

