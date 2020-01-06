package models.dao;

import models.Student;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.Statement;
import java.sql.ResultSet;
import org.json.JSONArray;
import org.json.JSONObject;


public class Sql2oStudentDao implements StudentDao {
  private final Sql2o sql2o;
  public Sql2oStudentDao(Sql2o sql2o) { this.sql2o = sql2o; }


  @Override
  public JSONObject add(Student student) {
    String rejected = "You can cheat the exams but not cheat me";


    try (Connection con = sql2o.open()) {
      int cnt = con.createQuery("SELECT COUNT (*) FROM students WHERE email = :email",true)
        .addParameter("email", student.getEmail())
        .executeScalar(Integer.class);

        if (cnt == 0){
          String sql = "INSERT INTO students (firstname, lastname, email, password) VALUES (:firstname, :lastname, :email, :password)"; //if you change your model, be sure to update here as well!
          try {
            int id = (int) con.createQuery(sql, true)
            .addParameter("firstname", student.getFirstName())
            .addParameter("lastname", student.getLastName())
            .addParameter("email", student.getEmail())
            .addParameter("password", student.getPassword())
            .executeUpdate()
            .getKey();
            student.setId(id);
          } catch (Sql2oException ex) {
            System.out.println(ex);
          }
          JSONObject sampleObject = new JSONObject();
          sampleObject.put("student", student);
          return sampleObject;

        }
        else{
          return null;
        }
      }
    }

      @Override
      public List<Student> getAll() {
        try (Connection con = sql2o.open()) {
          return con.createQuery("SELECT * FROM students")
          .executeAndFetch(Student.class);
        }
      }

      @Override
      public Student findById(int id) {
        try (Connection con = sql2o.open()) {
          return con.createQuery("SELECT * FROM students WHERE id = :id")
          .addParameter("id", id)
          .executeAndFetchFirst(Student.class);
        }
      }

//  @Override
//    public void update(int id, String name, String email, int universityid, int courseid, int staffnumber, String profilepicture, String educationlevel, String gender, String location, Date dateofbirth, String password) {
      //   String sql = "UPDATE teachers SET (name, email, universityid, courseid, staffnumber, profilepicture, educationlevel, gender, location, dateofbirth, password) = (:name, :email, :universityid, :courseid, :staffnumber, :profilepicture, :educationlevel, :gender, :location, :dateofbirth, :password) WHERE id=:id"; //CHECK!!!
      //   try (Connection con = sql2o.open()) {
      //       con.createQuery(sql)
      //               .addParameter("name", name)
      //               .addParameter("email", email)
      //               .addParameter("universityid", universityid)
      //               .addParameter("courseid", courseid)
      //               .addParameter("staffnumber", staffnumber)
      //               .addParameter("educationlevel", educationlevel)
      //               .addParameter("gender", gender)
      //               .addParameter("location", location)
      //               .addParameter("dateofbirth", dateofbirth)
      //               .addParameter("password", password)
      //               .addParameter("id", id)
      //               .executeUpdate();
      //             } catch (Sql2oException ex) {
      //       System.out.println(ex);
      //   }
      // }
      //

  @Override
  public void deleteById(int id) {
    String sql = "DELETE from students WHERE id=:id";
    try (Connection con = sql2o.open()) {
      con.createQuery(sql)
              .addParameter("id", id)
              .executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

  @Override
  public void clearAll() {
    String sql = "DELETE from students";
    try (Connection con = sql2o.open()) {
      con.createQuery(sql).executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

}
