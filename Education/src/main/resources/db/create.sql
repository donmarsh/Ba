SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS contents (
 id int PRIMARY KEY auto_increment,
 notes_id int,
 word_link VARCHAR,
 powerpoint_link VARCHAR,
 pdf_link VARCHAR,
);

CREATE TABLE IF NOT EXISTS courses (
 id int PRIMARY KEY auto_increment,
 major VARCHAR,
 speciality VARCHAR,
);

CREATE TABLE IF NOT EXISTS notes (
 id int PRIMARY KEY auto_increment,
 heading VARCHAR,
 description VARCHAR,
 universityid int,
 notepicture VARCHAR,
 teacherid int,
 contentid int,
 courseid int,
);

CREATE TABLE IF NOT EXISTS teachers (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 email VARCHAR,
 universityid int,
 courseid int,
 staffnumber int,
 profilepicture VARCHAR,
 educationlevel VARCHAR,
 location VARCHAR,
 gender VARCHAR,
 dateofbirth DATE,
);

CREATE TABLE IF NOT EXISTS universities (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 location VARCHAR,
 description VARCHAR,
);
