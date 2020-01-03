SET MODE PostgreSQL;

CREATE TABLE lectures(id SERIAL PRIMARY KEY, name INTEGER, contentid INTEGER REFERENCES contents(id), noteid INTEGER REFERENCES notes(id));

CREATE TABLE contents (id SERIAL PRIMARY KEY filename VARCHAR);

CREATE TABLE courses (id SERIAL PRIMARY KEY, major VARCHAR);

CREATE TABLE notes (id SERIAL PRIMARY KEY, heading VARCHAR, description VARCHAR, universityid INTEGER REFERENCES universities(id), notepicture VARCHAR, teacherid INTEGER REFERENCES teachers(id), courseid INTEGER REFERENCES courses(id), unitid INTEGER REFERENCES units(id), lectureid INTEGER REFERENCES lectures(id), requirement VARCHAR);

CREATE TABLE teachers ( id SERIAL PRIMARY KEY, firstname VARCHAR, lastname VARCHAR, email VARCHAR, universityid INTEGER REFERENCES universities(id), courseid INTEGER REFERENCES courses(id), staffnumber INTEGER, profilepicture VARCHAR, educationlevelid INTEGER REFERENCES educationlevels(id), location VARCHAR, genderid INTEGER REFERENCES genders(id), dateofbirth DATE);

CREATE TABLE universities (id SERIAL PRIMARY KEY, name VARCHAR, location VARCHAR, description VARCHAR, logo VARCHAR);

CREATE TABLE reviews (id SERIAL PRIMARY KEY, writtenby VARCHAR, content VARCHAR, rating VARCHAR, noteid INTEGER, createdat BIGINT);

CREATE TABLE genders (id SERIAL PRIMARY KEY, name VARCHAR);

CREATE TABLE educationlevels (id SERIAL PRIMARY KEY, name VARCHAR);

CREATE TABLE enrolments (id serial PRIMARY KEY, teacherid INTEGER REFERENCES teachers(id), noteid INTEGER REFERENCES notes(id));

CREATE TABLE students (id SERIAL PRIMARY KEY, firstname VARCHAR, lastname VARCHAR, email VARCHAR, password VARCHAR, profilepicture VARCHAR, location VARCHAR, genderid INTEGER REFERENCES genders(id), dateofbirth DATE);

CREATE TABLE universitystudents (id SERIAL PRIMARY KEY, firstname VARCHAR, lastname VARCHAR, email VARCHAR, password VARCHAR, studentnumber INTEGER, universityid INTEGER REFERENCES universities(id), courseid INTEGER REFERENCES courses(id), yearid INTEGER REFERENCES years(id), profilepicture VARCHAR, genderid INTEGER REFERENCES genders(id), dateofbirth DATE);

CREATE TABLE years (id SERIAL PRIMARY KEY, year INTEGER);

CREATE TABLE studentCourses (id SERIAL PRIMARY KEY, name VARCHAR, unitid INTEGER REFERENCES units(id));

CREATE TABLE units (id SERIAL PRIMARY KEY, name VARCHAR, courseid INTEGER REFERENCES courses(id));

CREATE TABLE studentenrolments (id SERIAL PRIMARY KEY, studentid INTEGER REFERENCES students(id), unitid INTEGER REFERENCES units(id));

CREATE TABLE uploads (id SERIAL PRIMARY KEY, filename VARCHAR);
