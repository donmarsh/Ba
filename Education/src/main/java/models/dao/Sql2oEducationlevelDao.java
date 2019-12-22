package dao;

import models.Educationlevel;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;
import java.util.ArrayList;

public class Sql2oEducationlevelDao implements EducationlevelDao {
  private final Sql2o sql2o;
  public Sql2oEducationlevelDao(Sql2o sql2o) { this.sql2o = sql2o; }

  @Override
  public void add(Educationlevel educationlevel) {
    String sql = "INSERT INTO educationlevels (name) VALUES (:name)"; //if you change your model, be sure to update here as well!
    try (Connection con = sql2o.open()) {
      int id = (int) con.createQuery(sql, true)
      .addParameter("name", educationlevel.getName())
      .executeUpdate()
      .getKey();
      educationlevel.setId(id);
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

  @Override
  public List<Educationlevel> getAll() {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM educationlevels")
              .executeAndFetch(Educationlevel.class);
    }
  }

  @Override
  public void update(int id, String name) {
    String sql = "UPDATE educationlevels SET (name) = (:name) WHERE id=:id"; //CHECK!!!
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
  public Educationlevel findById(int id) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM educationlevels WHERE id = :id")
      .addParameter("id", id)
      .executeAndFetchFirst(Educationlevel.class);
    }
  }

  @Override
  public void deleteById(int id) {
    String sql = "DELETE from educationlevels WHERE id=:id";
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
    String sql = "DELETE from educationlevels";
    try (Connection con = sql2o.open()) {
      con.createQuery(sql).executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }
}
