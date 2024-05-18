create database hotelmanagementsystem;
show databases;
use hotelmanagementsystem;
create table login(username varchar(25), password varchar(25));
insert into login values('farzana', '12345');
select * from login;
create table customer(document varchar(20), number varchar(30), name varchar(30), gender varchar(15), country varchar(20),room varchar(10), checkintime varchar(80), deposit varchar(20));
create table room(roomnumber varchar(10), availability varchar(20), cleaning_status varchar(20), price varchar(20), bed_type varchar(20));
select * from room;
select * from customer;
create table department(department varchar(30), budget varchar(30));
insert into department values('Front Office','500000');
insert into department values('Housekeeping','40000');
insert into department values('Food and Bevarage','300000');
insert into department values('Food Production','590000');
insert into department values('Security','32000');
select * from department;


create table employee(name varchar(25), age varchar(10), gender varchar(15), job varchar(30), salary varchar(15), phone varchar(15), email varchar(40), NID varchar(20));
select * from  employee;
create table manager(name varchar(25), age varchar(10), gender varchar(15), designation varchar(30), salary varchar(15), phone varchar(15), email varchar(40), NID varchar(20));
select * from manager;


create table securityguard(name varchar(25), age varchar(10), gender varchar(15), dutytime varchar(30),gate varchar(10), salary varchar(15), phone varchar(15), email varchar(40), NID varchar(20));
create table chef(name varchar(25), age varchar(10), gender varchar(15), designation varchar(30), salary varchar(15), phone varchar(15), email varchar(40), NID varchar(20));
create table waiter(name varchar(25), age varchar(10), gender varchar(15), dutytime varchar(30),assignedtable varchar(10), salary varchar(15), phone varchar(15), email varchar(40), NID varchar(20));
create table housekeeper(name varchar(25), age varchar(10), gender varchar(15), dutytime varchar(30), salary varchar(15), phone varchar(15), email varchar(40), NID varchar(20));
create table allfood(id varchar(10), name varchar(25), price varchar(10), cartegory varchar(25));


select * from allfood;

create table accountant(name varchar(25), age varchar(10), gender varchar(15), degree varchar(30), designation varchar(30), salary varchar(15), phone varchar(15), email varchar(40), NID varchar(20));
create table receptionist(name varchar(25), age varchar(10), gender varchar(15), degree varchar(30),skill varchar(50), salary varchar(15), phone varchar(15), email varchar(40), NID varchar(20));
