package models.dao;

import models.Teacher;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.Statement;
import java.sql.ResultSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.mindrot.jbcrypt.BCrypt;
import org.sql2o.Query;
import org.sql2o.data.Table;
import org.sql2o.data.Row;
import org.json.JSONArray;
import org.json.JSONObject;



public class Sql2oTeacherDao implements TeacherDao {
  private final Sql2o sql2o;
  public Sql2oTeacherDao(Sql2o sql2o) { this.sql2o = sql2o; }

  Map DB = new HashMap();
	public static final String SALT = "my-salt-text";



  @Override
  public JSONObject add(Teacher teacher) {
    String rejected = "You can cheat the exams but not cheat me";


    try (Connection con = sql2o.open()) {
      int cnt = con.createQuery("SELECT COUNT (*) FROM teachers WHERE email = :email AND staffnumber = :staffnumber",true)
        .addParameter("email", teacher.getEmail())
        .addParameter("staffnumber", teacher.getStaffNumber())
        .executeScalar(Integer.class);

        if (cnt == 0){
        //  String saltedPassword = SALT password;
        //  String hashedPassword = generateHash(saltedPassword);
          String sql = "INSERT INTO teachers (firstname, lastname, email, password, staffnumber, courseid, universityid, educationlevelid, genderid) VALUES (:firstname, :lastname, :email, :password, :staffnumber, :courseid, :universityid, :educationlevelid, :genderid)"; //if you change your model, be sure to update here as well!
          try {
            int id = (int) con.createQuery(sql, true)
            .addParameter("firstname", teacher.getFirstName())
            .addParameter("lastname", teacher.getLastName())
            .addParameter("email", teacher.getEmail())
            .addParameter("password", BCrypt.hashpw(teacher.getPassword(), BCrypt.gensalt()))
            .addParameter("staffnumber", teacher.getStaffNumber())
            .addParameter("courseid", teacher.getCourseId())
            .addParameter("universityid", teacher.getUniversityId())
            .addParameter("educationlevelid", teacher.getEducationLevelId())
            .addParameter("genderid", teacher.getGenderId())
            .executeUpdate()
            .getKey();
            teacher.setId(id);
          } catch (Sql2oException ex) {
            System.out.println(ex);
          }
          JSONObject sampleObject = new JSONObject();
          sampleObject.put("teacher", teacher);
          return sampleObject;

        }
        else{
          return null;
        }
      }
    }

    @Override
    public String login(String email, String password) {
      //String Email = request.getParameter("email");

      try (Connection con = sql2o.open()) {
        Query query = con.createQuery("SELECT * FROM teachers WHERE email = :email")
        .addParameter("email", email);
        Table table = query.executeAndFetchTable();
        System.out.println(email);

        List<Map<String, Object>> list = table.asList();
        List<Row> rows = table.rows();
        if (rows.size()== 0) {
          return "invalid credentials";
        }
        System.out.println(rows.size());
  //      assertEquals("password", list.get(0).get("password"));
        if(BCrypt.checkpw(password, rows.get(0).getString("password"))){
          // Map<String, String> details = new Map();
          // details.put("firstname", rows.getString("firstname"));
          // details.put("lastname", rows.getString("lastname"));
          // details.put("email", rows.getString("email"));
          // details.put("universityid", rows.getString("universityid"));
          // details.put("courseid", rows.getString("courseid"));
          // details.put("staffnumber", rows.getString("staffnumber"));
          // details.put("profilepicture", rows.getString("profilepicture"));
          // details.put("educationlevelid", rows.getString("educationlevelid"));
          // details.put("genderid", rows.getString("genderid"));
          //
          // JSONObject sampleObject = new JSONObject();
          // sampleObject.put("details", details);
          // return details;
          return "Request was successful";
        }
        else{
          return "Invalid user credentials"; // Just returning appropriate message otherwise
        }

      }

    }


      //    .addParameter("password", BCrypt.checkpw(teacher.getPassword(), BCrypt.gensalt()))

      @Override
      public List<Teacher> getAll() {
        try (Connection con = sql2o.open()) {
          return con.createQuery("SELECT * FROM teachers")
          .executeAndFetch(Teacher.class);
        }
      }

      @Override
      public Teacher findById(int id) {
        try (Connection con = sql2o.open()) {
          return con.createQuery("SELECT * FROM teachers WHERE id = :id")
          .addParameter("id", id)
          .executeAndFetchFirst(Teacher.class);
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
    String sql = "DELETE from teachers WHERE id=:id";
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
    String sql = "DELETE from teachers";
    try (Connection con = sql2o.open()) {
      con.createQuery(sql).executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

}
