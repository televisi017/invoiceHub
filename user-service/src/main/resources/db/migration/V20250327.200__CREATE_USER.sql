create table user (
user_id varchar(200) not null,
name varchar(200) not null,
age integer not null,
gender char(1) check (gender IN ('M','F')),
created_time timestamp not null,
updated_time timestamp not null,
constraint user_id_pk primary key (user_id)
);