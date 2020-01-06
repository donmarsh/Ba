package models.dao;

import models.Lecture;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.ArrayList;
import java.util.List;

public class Sql2oLectureDao implements LectureDao {
  private final Sql2o sql2o;
  public Sql2oLectureDao(Sql2o sql2o) { this.sql2o = sql2o; }

  @Override
  public void add(Lecture lecture) {
    String sql = "INSERT INTO lectures (name, contentid, noteid) VALUES (:name, :contentid, :noteid)"; //if you change your model, be sure to update here as well!
    try (Connection con = sql2o.open()) {
      int id = (int) con.createQuery(sql, true)
      .addParameter("name", lecture.getName())
      .addParameter("contentid", lecture.getContentId())
      .addParameter("noteid", lecture.getNoteId())
      .executeUpdate()
      .getKey();
      lecture.setId(id);
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

  @Override
  public List<Lecture> getAll() {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM lectures")
              .executeAndFetch(Lecture.class);
    }
  }

  @Override
  public Lecture findById(int id) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM lectures WHERE id = :id")
      .addParameter("id", id)
      .executeAndFetchFirst(Lecture.class);
    }
  }

  @Override
  public List<Lecture> getLectureByNoteId(int noteid) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM lectures WHERE noteid =" +noteid)
      .executeAndFetch(Lecture.class);
    }
  }

  @Override
  public void update(int id, String name, int contentid, int noteid) {
    String sql = "UPDATE lectures SET (name, contentid, noteid) = (:name, :contentid, :noteid) WHERE id=:id"; //CHECK!!!
    try (Connection con = sql2o.open()) {
      con.createQuery(sql)
      .addParameter("name", name)
      .addParameter("contentid", contentid)
      .addParameter("noteid", noteid)
      .addParameter("id", id)
      .executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

  @Override
  public List<Lecture> getLectureById(int id) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM lectures WHERE id = :id")
              .addParameter("id", id)
              .executeAndFetch(Lecture.class);
    }
  }


  @Override
  public void deleteById(int id) {
    String sql = "DELETE from lectures WHERE id=:id";
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
    String sql = "DELETE from lectures";
    try (Connection con = sql2o.open()) {
      con.createQuery(sql).executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

}
