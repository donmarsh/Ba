package dao;

import models.University;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;

public class Sql2oUniversityDao implements UniversityDao {
  private final Sql2o sql2o;
  public Sql2oUniversityDao(Sql2o sql2o) { this.sql2o = sql2o; }

  @Override
  public void add(University university) {
    String sql = "INSERT INTO universities (name, description, location) VALUES (:name, :description, :location)"; //if you change your model, be sure to update here as well!
    try (Connection con = sql2o.open()) {
      int id = (int) con.createQuery(sql, true)
              .bind(university)
              .executeUpdate()
              .getKey();
      university.setId(id);
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

  @Override
  public List<University> getAll() {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM universities")
              .executeAndFetch(University.class);
    }
  }

  @Override
  public University findById(int id) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM universities WHERE id = :id")
      .addParameter("id", id)
      .executeAndFetchFirst(University.class);
    }
  }

  @Override
  public void deleteById(int id) {
    String sql = "DELETE from universities WHERE id=:id";
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
    String sql = "DELETE from universities";
    try (Connection con = sql2o.open()) {
      con.createQuery(sql).executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }
}
