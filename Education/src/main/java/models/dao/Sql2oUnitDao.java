package models.dao;

import models.Unit;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;

public class Sql2oUnitDao implements UnitDao {
  private final Sql2o sql2o;
  public Sql2oUnitDao(Sql2o sql2o) { this.sql2o = sql2o; }

  @Override
  public void add(Unit unit) {
    String sql = "INSERT INTO units (name, courseid) VALUES (:name, :courseid)"; //if you change your model, be sure to update here as well!
    try (Connection con = sql2o.open()) {
      int id = (int) con.createQuery(sql, true)
      .addParameter("name", unit.getName())
      .addParameter("courseid", unit.getCourseId())
      .executeUpdate()
      .getKey();
      unit.setId(id);
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

  @Override
  public List<Unit> getAll() {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM units")
              .executeAndFetch(Unit.class);
    }
  }

  @Override
  public Unit findById(int id) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM units WHERE id = :id")
      .addParameter("id", id)
      .executeAndFetchFirst(Unit.class);
    }
  }

  @Override
  public List<Unit> getCourseById(int id) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM units WHERE id = :id")
              .addParameter("id", id)
              .executeAndFetch(Unit.class);
    }
  }


  @Override
  public void deleteById(int id) {
    String sql = "DELETE from units WHERE id=:id";
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
    String sql = "DELETE from units";
    try (Connection con = sql2o.open()) {
      con.createQuery(sql).executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }
}
