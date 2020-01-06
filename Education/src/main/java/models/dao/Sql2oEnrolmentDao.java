package models.dao;

import models.Enrolment;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;
import java.util.ArrayList;

public class Sql2oEnrolmentDao implements EnrolmentDao {
  private final Sql2o sql2o;
  public Sql2oEnrolmentDao(Sql2o sql2o) { this.sql2o = sql2o; }

  @Override
  public void add(Enrolment enrolment) {
    String sql = "INSERT INTO enrolments (teacherid, noteid) VALUES (:teacherid, :noteid)"; //if you change your model, be sure to update here as well!
    try (Connection con = sql2o.open()) {
      int id = (int) con.createQuery(sql, true)
      .addParameter("teacherid", enrolment.getTeacherId())
      .addParameter("noteid", enrolment.getNoteId())
       .executeUpdate()
       .getKey();
        enrolment.setId(id);
        //requirements

    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

  @Override
  public List<Enrolment> getAll() {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM enrolments")
              .executeAndFetch(Enrolment.class);
    }
  }

  @Override
  public Enrolment findById(int id) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM enrolments WHERE id = :id")
      .addParameter("id", id)
      .executeAndFetchFirst(Enrolment.class);
    }
  }

  @Override
  public void update(int id, int teacherid, int noteid) {
    String sql = "UPDATE enrolments SET (teacherid, noteid) = (:teacherid, :noteid) WHERE id=:id"; //CHECK!!!
    try (Connection con = sql2o.open()) {
      con.createQuery(sql)
      .addParameter("teacherid", teacherid)
      .addParameter("noteid", noteid)
      .addParameter("id", id)
      .executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }


  @Override
  public void deleteById(int id) {
    String sql = "DELETE from enrolments WHERE id=:id";
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
    String sql = "DELETE from enrolments";
    try (Connection con = sql2o.open()) {
      con.createQuery(sql).executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }
}
