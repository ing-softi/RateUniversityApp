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
INSERT INTO role (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO role (role_name) VALUES ('ROLE_USER');

create table user_role_relate (
    user_id int,
    role_id int
);
INSERT INTO course (name, average_rates,professor, total_hours, week_day, start_time, end_time, registered_students) 
VALUES ('Computer Science',0.0,'John John',30,'Monday','08:00','12:00',0);
INSERT INTO course (name, average_rates,professor, total_hours, week_day, start_time, end_time, registered_students) 
VALUES ('Digital Logic Design',0.0,'John John',30,'Monday','14:00','17:00',0);

INSERT INTO course (name, average_rates,professor, total_hours, week_day, start_time, end_time, registered_students) 
VALUES ('Computer Organization',0.0,'John John',30,'Tuesday','08:00','12:00',0);
INSERT INTO course (name, average_rates,professor, total_hours, week_day, start_time, end_time, registered_students) 
VALUES ('Operating Systems',0.0,'John John',30,'Tuesday','14:00','17:00',0);

INSERT INTO course (name, average_rates,professor, total_hours, week_day, start_time, end_time, registered_students) VALUES ('Computer Networks',0.0,'John John',30,'Wednesday','08:00','12:00',0);
INSERT INTO course (name, average_rates,professor, total_hours, week_day, start_time, end_time, registered_students) VALUES ('Software Engineering',0.0,'John John',30,'Wednesday','14:00','17:00',0);

INSERT INTO course (name, average_rates,professor, total_hours, week_day, start_time, end_time, registered_students) VALUES ('Microprocessor Systems',0.0,'John John',30,'Thursday','08:00','12:00',0);
INSERT INTO course (name, average_rates,professor, total_hours, week_day, start_time, end_time, registered_students) VALUES ('Computer Graphics',0.0,'John John',30,'Thursday','14:00','17:00',0);

INSERT INTO course (name, average_rates,professor, total_hours, week_day, start_time, end_time, registered_students) VALUES ('Database',0.0,'John John',30,'Friday','08:00','12:00',0);
INSERT INTO course (name, average_rates,professor, total_hours, week_day, start_time, end_time, registered_students) VALUES ('Data Structures',0.0,'John John',30,'Friday','14:00','17:00',0);

INSERT INTO course (name, average_rates,professor, total_hours, week_day, start_time, end_time, registered_students) VALUES ('Artificial Intelligence',0.0,'John John',30,'Saturday','08:00','12:00',0);
INSERT INTO course (name, average_rates,professor, total_hours, week_day, start_time, end_time, registered_students) VALUES ('Cybersecurity',0.0,'John John',30,'Saturday','14:00','17:00',0);
SELECT * FROM course;
SELECT * FROM user;
SELECT * FROM user_course_relate;
SELECT * FROM role;
SELECT * FROM user_role_relate;