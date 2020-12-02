docker container run -d --name mysqldb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password mysql:latest
docker exec -it mysqldb bash
mysql -u root -ppassword
create database altr;
CREATE TABLE Persons (Personid int NOT NULL AUTO_INCREMENT, LastName varchar(60) NOT NULL, FirstName varchar(60) NOT NULL, PRIMARY KEY (Personid));
INSERT INTO Person (FirstName,LastName) Values ("Steven","Cheswick");
select * from Persons;
