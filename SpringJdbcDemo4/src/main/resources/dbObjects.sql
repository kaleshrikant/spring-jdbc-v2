$ sudo mysql
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 27
Server version: 8.0.36-0ubuntu0.22.04.1 (Ubuntu)

Copyright (c) 2000, 2024, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.


mysql> CREATE DATABASE register;
Query OK, 1 row affected (0.01 sec)

mysql> show tables;
+--------------------+
| Tables_in_register |
+--------------------+
| Persons            |
+--------------------+
1 row in set (0.00 sec)

mysql> use register;
Database changed

mysql> CREATE TABLE Persons (
    ->     PersonID int,
    ->     LastName varchar(255),
    ->     FirstName varchar(255),
    ->     Address varchar(255),
    ->     City varchar(255)
    -> );
Query OK, 0 rows affected (0.04 sec)

mysql> desc Persons;
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| PersonID  | int          | YES  |     | NULL    |       |
| LastName  | varchar(255) | YES  |     | NULL    |       |
| FirstName | varchar(255) | YES  |     | NULL    |       |
| Address   | varchar(255) | YES  |     | NULL    |       |
| City      | varchar(255) | YES  |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
5 rows in set (0.00 sec)

mysql> CREATE USER 'shrikant'@'localhost' IDENTIFIED BY 'Kale@333';
Query OK, 0 rows affected (0.02 sec)

mysql> GRANT ALL ON *.* TO 'shrikant'@'localhost';
Query OK, 0 rows affected (0.02 sec)

mysql> FLUSH PRIVILEGES;
Query OK, 0 rows affected (0.02 sec)

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| register           |
| sys                |
+--------------------+
5 rows in set (0.00 sec)

mysql> use register;
Database changed
mysql> show tables;
+--------------------+
| Tables_in_register |
+--------------------+
| Persons            |
+--------------------+
1 row in set (0.00 sec)

mysql> select * from Persons;
+----------+----------+-----------+------------+----------+
| PersonID | LastName | FirstName | Address    | City     |
+----------+----------+-----------+------------+----------+
|      101 | KALE     | SHRIKANT  | MAHARASTRA | AMRAVATI |
|      101 | KALE     | PRASHANT  | MAHARASTRA | AMRAVATI |
|      102 | Kale     | Pratibha  | Maharastra | Tiosa    |
+----------+----------+-----------+------------+----------+
3 rows in set (0.00 sec)

Enter PersonID | FirstName | LastName | Address  | City :

103
Sanjay
Pradhan
Maharastra
SambhajiNagar
1 Record inserted successfully.!

mysql> select * from Persons;
+----------+----------+-----------+------------+---------------+
| PersonID | LastName | FirstName | Address    | City          |
+----------+----------+-----------+------------+---------------+
|      101 | KALE     | SHRIKANT  | MAHARASTRA | AMRAVATI      |
|      101 | KALE     | PRASHANT  | MAHARASTRA | AMRAVATI      |
|      102 | Kale     | Pratibha  | Maharastra | Tiosa         |
|      103 | Pradhan  | Sanjay    | Maharastra | SambhajiNagar |
+----------+----------+-----------+------------+---------------+
4 rows in set (0.00 sec)
