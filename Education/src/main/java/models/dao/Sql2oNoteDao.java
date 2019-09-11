package dao;

import models.Teacher;
import models.Content;
import models.Course;
import models.University;
import models.Note;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;

public class Sql2oNoteDao implements NoteDao {
  private final Sql2o sql2o;
  public Sql2oNoteDao(Sql2o sql2o) { this.sql2o = sql2o; }

  @Override
  public void add(Note note) {
    String sql = "INSERT INTO notes (heading, description, universityid, courseid, notepicture, teacherid, contentid) VALUES (:heading, :description, :universityid, :courseid, :notepicture, :teacherid, :contentid)"; //if you change your model, be sure to update here as well!
    try (Connection con = sql2o.open()) {
      int id = (int) con.createQuery(sql, true)
      .bind(note)
       .executeUpdate()
       .getKey();
        note.setId(id);
      
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

  @Override
  public List<Note> getAll() {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM notes")
              .executeAndFetch(Note.class);
    }
  }

  @Override
  public Note findById(int id) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM notes WHERE id = :id")
      .addParameter("id", id)
      .executeAndFetchFirst(Note.class);
    }
  }

  @Override
  public List<Note> getAllNotesByTeacher(int teacherId) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM notes WHERE teacherId = :teacherId")
              .addParameter("teacherId", teacherId)
              .executeAndFetch(Note.class);
    }
  }

  @Override
  public List<Note> getAllNotesByUniversity(int universityId) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM notes WHERE universityId = :universityId")
              .addParameter("universityId", universityId)
              .executeAndFetch(Note.class);
    }
  }

  @Override
  public List<Note> getAllNotesByCourse(int courseId) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM notes WHERE courseId = :courseId")
              .addParameter("courseId", courseId)
              .executeAndFetch(Note.class);
    }
  }

  @Override
  public void deleteById(int id) {
    String sql = "DELETE from notes WHERE id=:id";
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
    String sql = "DELETE from notes";
    try (Connection con = sql2o.open()) {
      con.createQuery(sql).executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }
}
