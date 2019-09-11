package dao;

import models.Teacher;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.ArrayList;
import java.util.List;

public class Sql2oTeacherDao implements TeacherDao {
  private final Sql2o sql2o;
  public Sql2oTeacherDao(Sql2o sql2o) { this.sql2o = sql2o; }


  @Override
  public void add(Teacher teacher) {
    String sql = "INSERT INTO teachers (name, email, universityid, courseid, staffnumber, profilepicture, educationlevel, location, gender, dateofbirth) VALUES (:name, :email, :universityid, :course, :staffnumber, :profilepicture, :educationlevel, :location, :gender, :dateofbirth)"; //if you change your model, be sure to update here as well!
    try (Connection con = sql2o.open()) {
      int id = (int) con.createQuery(sql, true)
      .bind(teacher)
      .executeUpdate()
      .getKey();
      teacher.setId(id);
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

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
      return con.createQuery("SELECT * FROM techers WHERE id = :id")
      .addParameter("id", id)
      .executeAndFetchFirst(Teacher.class);
    }
  }

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
