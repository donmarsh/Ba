package models.dao;

import models.Gender;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;
import java.util.ArrayList;

public class Sql2oGenderDao implements GenderDao {
  private final Sql2o sql2o;
  public Sql2oGenderDao(Sql2o sql2o) { this.sql2o = sql2o; }

  @Override
  public void add(Gender gender) {
    String sql = "INSERT INTO genders (name) VALUES (:name)"; //if you change your model, be sure to update here as well!
    try (Connection con = sql2o.open()) {
      int id = (int) con.createQuery(sql, true)
              .addParameter("name", gender.getName())
              .executeUpdate()
              .getKey();
      gender.setId(id);
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

  @Override
  public List<Gender> getAll() {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM genders")
              .executeAndFetch(Gender.class);
    }
  }

  @Override
  public void update(int id, String name) {
    String sql = "UPDATE genders SET (name) = (:name) WHERE id=:id"; //CHECK!!!
    try (Connection con = sql2o.open()) {
      con.createQuery(sql)
      .addParameter("name", name)
      .addParameter("id", id)
      .executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

  @Override
  public Gender findById(int id) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM genders WHERE id = :id")
      .addParameter("id", id)
      .executeAndFetchFirst(Gender.class);
    }
  }

  @Override
  public void deleteById(int id) {
    String sql = "DELETE from genders WHERE id=:id";
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
    String sql = "DELETE from genders";
    try (Connection con = sql2o.open()) {
      con.createQuery(sql).executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }
}
