package models.dao;

import models.Course;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;

public class Sql2oCourseDao implements CourseDao {
  private final Sql2o sql2o;
  public Sql2oCourseDao(Sql2o sql2o) { this.sql2o = sql2o; }

  @Override
  public void add(Course course) {
    String sql = "INSERT INTO courses (major) VALUES (:major)"; //if you change your model, be sure to update here as well!
    try (Connection con = sql2o.open()) {
      int id = (int) con.createQuery(sql, true)
      .addParameter("major", course.getMajor())
      .executeUpdate()
      .getKey();
      course.setId(id);
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

  @Override
  public List<Course> getAll() {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM courses")
              .executeAndFetch(Course.class);
    }
  }

  @Override
  public Course findById(int id) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM courses WHERE id = :id")
      .addParameter("id", id)
      .executeAndFetchFirst(Course.class);
    }
  }

  @Override
  public List<Course> getCourseById(int id) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM courses WHERE id = :id")
              .addParameter("id", id)
              .executeAndFetch(Course.class);
    }
  }


  @Override
  public void deleteById(int id) {
    String sql = "DELETE from courses WHERE id=:id";
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
    String sql = "DELETE from courses";
    try (Connection con = sql2o.open()) {
      con.createQuery(sql).executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }
}
