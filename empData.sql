create database emp_management_system;

use emp_management_system;

create table Employees(id int primary key auto_increment,name varchar(20),email varchar(20),department varchar(20));
desc Employees;
select*from Employees;

drop table Employees;