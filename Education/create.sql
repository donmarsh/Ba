SET MODE PostgreSQL;

//create table called lectures(id SERIAL PRIMARY KEY, name INTEGER, contentid INTEGER REFERENCES contents(id));
//add contentid, remove noteid
CREATE TABLE contents (id SERIAL PRIMARY KEY, notes_id INTEGER, word_link VARCHAR, powerpoint_link VARCHAR, pdf_link VARCHAR);
//left with id, filename
CREATE TABLE courses (id SERIAL PRIMARY KEY, major VARCHAR, speciality VARCHAR);

CREATE TABLE notes (id SERIAL PRIMARY KEY, heading VARCHAR, description VARCHAR, universityid INTEGER REFERENCES universities(id), notepicture VARCHAR, teacherid INTEGER REFERENCES teachers(id), courseid INTEGER REFERENCES courses(id), unitid INTEGER REFERENCES units(id), lectureid INTEGER REFERENCES lectures(id)));
//add lectureid
CREATE TABLE teachers ( id SERIAL PRIMARY KEY, name VARCHAR, email VARCHAR, universityid INTEGER REFERENCES universities(id), courseid INTEGER REFERENCES courses(id), staffnumber INTEGER, profilepicture VARCHAR, educationlevelid INTEGER REFERENCES educationlevels(id) , location VARCHAR, genderid INTEGER REFERENCES genders(id), dateofbirth DATE);

CREATE TABLE universities (id SERIAL PRIMARY KEY, name VARCHAR, location VARCHAR, description VARCHAR);
add logo
CREATE TABLE reviews (id SERIAL PRIMARY KEY, writtenby VARCHAR, content VARCHAR, rating VARCHAR, noteid INTEGER, createdat BIGINT );

CREATE TABLE genders (id SERIAL PRIMARY KEY, name VARCHAR);

CREATE TABLE educationlevels (id SERIAL PRIMARY KEY, name VARCHAR);

CREATE TABLE enrolments (id serial PRIMARY KEY, teacherid INTEGER REFERENCES teachers(id), noteid INTEGER REFERENCES notes(id));

//notes id, heading, description, universityid, notepicture, teacherid, courseid
//lecture id, name, courseId
//content id, lectureId, filename

Students

CREATE TABLE students (id SERIAL PRIMARY KEY, firstname VARCHAR, lastname VARCHAR, email VARCHAR, password VARCHAR, profilepicture VARCHARlocation VARCHAR, genderid INTEGER REFERENCES genders(id), dateofbirth DATE);

///

CREATE TABLE universityStudents (id SERIAL PRIMARY KEY, firstname VARCHAR, lastname VARCHAR, email VARCHAR, password VARCHAR, studentnumber INTEGER, universityid INTEGER REFERENCES universities(id), courseid INTEGER REFERENCES courses(id), yearid INTEGER REFERENCES years(id), profilepicture VARCHAR, genderid INTEGER REFERENCES genders(id), dateofbirth DATE);

CREATE TABLE years (id SERIAL PRIMARY KEY, year INTEGER);

CREATE TABLE studentCourses (id SERIAL PRIMARY KEY, name VARCHAR, unitid INTEGER REFERENCES units(id));

CREATE TABLE units (id SERIAL PRIMARY KEY, name VARCHAR, courseid INTEGER REFERENCES courses(id));

CREATE TABLE studentEnrolments (id SERIAL PRIMARY KEY, studentid INTEGER REFERENCES students(id), unitid INTEGER REFERENCES units(id));
