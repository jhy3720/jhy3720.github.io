CREATE TABLE badge(
stud_id varchar(20) NOT NULL,
stud_passwd varchar(20),
stud_name varchar(30),
stud_email varchar(30),
stud_gender varchar(10),
stud_hobby varchar(30),
stud_regdate varchar(30),
CONSTRAINT badge_pkey PRIMARY KEY (stud_id)
);

SELECT column_name, data_type, character_maximum_length from
INFORMATION_SCHEMA.COLUMNS WHERE table_name='badge';

ALTER TABLE badge ADD stud_phone character varying(20);

INSERT INTO badge(stud_id,stud_passwd,sutd_name,sutd_email,stud_gender) 
VALUES ('kdhong','1234','홍길동','kdhong@abc.com','남자');

INSERT INTO badge(stud_id,stud_passwd,sutd_name,sutd_email,stud_gender) 
VALUES ('chsung','1234','성춘향','chsung@abc.com','여자');

SELECT count(distinct(stud_id)) FROM badge;
SELECT stud_passwd FROM badge WHERE stud_id='kdhong';
SELECT * FROM badge;

UPDATE badge SET stud_passwd='123456' WHERE stud_id='kdhong';

DELETE FROM badge WHERE stud_id='hdbyun';

ALTER TABLE badge RENAME COLUMN sutd_email TO stud_email;

SELECT * FROM studuser;

DELETE FROM studuser WHERE stud_name='대덕대';


create table studuser ( 
stud_id varchar(20) primary key not null,
stud_passwd varchar(20), 
stud_name varchar(20), 
stud_email varchar(20), 
stud_phone varchar(20), 
stud_gender varchar(20), 
stud_hobby1 varchar(20), 
stud_hobby2 varchar(20), 
stud_hobby3 varchar(20), 
stud_regdate varchar(20) );



