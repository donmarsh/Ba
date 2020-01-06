package models.dao;

import models.Upload;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;
import java.util.ArrayList;

public class Sql2oUploadDao implements UploadDao {
  private final Sql2o sql2o;
  public Sql2oUploadDao(Sql2o sql2o) { this.sql2o = sql2o; }

  @Override
  public void add(Upload upload) {
    String sql = "INSERT INTO uploads (filename) VALUES (:filename)";
    try (Connection con = sql2o.open()) {
      int id = (int) con.createQuery(sql, true)
      .addParameter("filename", upload.getFileName())
      .executeUpdate()
      .getKey();
      upload.setId(id);
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

  @Override
  public List<Upload> getAll() {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM uploads")
              .executeAndFetch(Upload.class);
    }
  }

  @Override
  public Upload findById(int id) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM uploads WHERE id = :id")
      .addParameter("id", id)
      .executeAndFetchFirst(Upload.class);
    }
  }

  @Override
    public void update(int id, String filename) {
        String sql = "UPDATE uploads SET (filename) = (:filename) WHERE id=:id"; //CHECK!!!
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
    String sql = "DELETE from uploads WHERE id=:id";
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
    String sql = "DELETE from uploads";
    try (Connection con = sql2o.open()) {
      con.createQuery(sql).executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }
}
