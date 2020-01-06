package models.dao;

import models.Content;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;
import java.util.ArrayList;

public class Sql2oContentDao implements ContentDao {
  private final Sql2o sql2o;
  public Sql2oContentDao(Sql2o sql2o) { this.sql2o = sql2o; }

  @Override
  public void add(Content content) {
    String sql = "INSERT INTO contents (filename) VALUES (:filename)";
    try (Connection con = sql2o.open()) {
      int id = (int) con.createQuery(sql, true)
      .addParameter("filename", content.getFileName())
      .executeUpdate()
      .getKey();
      content.setId(id);
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

  @Override
  public List<Content> getAll() {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM contents")
              .executeAndFetch(Content.class);
    }
  }

  @Override
  public Content findById(int id) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM contents WHERE id = :id")
      .addParameter("id", id)
      .executeAndFetchFirst(Content.class);
    }
  }

  @Override
    public void update(int id, String filename) {
        String sql = "UPDATE contents SET (filename) = (:filename) WHERE id=:id"; //CHECK!!!
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("filename", filename)
                    .addParameter("id", id)
                    .executeUpdate();
                  } catch (Sql2oException ex) {
            System.out.println(ex);
        }
      }

  @Override
  public void deleteById(int id) {
    String sql = "DELETE from contents WHERE id=:id";
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
    String sql = "DELETE from contents";
    try (Connection con = sql2o.open()) {
      con.createQuery(sql).executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }
}
