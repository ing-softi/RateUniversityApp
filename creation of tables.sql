CREATE SCHEMA rate_university_app ;
create table user (
	id int not null auto_increment,
    name varchar(30) not null,
    surname varchar(30),
    email varchar(40) UNIQUE,
    password varchar(255) ,
    PRIMARY KEY (id)
);

create table course (
	id int not null auto_increment,
    name varchar(30) not null,
    average_rates float,
    professor varchar(40),
    total_hours float,
    week_day varchar(10),
    start_time varchar(14),
    end_time varchar(14),
    registered_students int,
    PRIMARY KEY (id)
);

create table user_course_relate (
	course_id int, 
    user_id int,
    role_id int
);

create table role (
	id int not null auto_increment,
    role_name varchar(30),
     PRIMARY KEY (id)
);
create table user_role_relate (
    user_id int,
    role_id int
);
SELECT * FROM user;
SELECT * FROM course;
SELECT * FROM user_course_relate;
SELECT * FROM role;
SELECT * FROM user_role_relate;