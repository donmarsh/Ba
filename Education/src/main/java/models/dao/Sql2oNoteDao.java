package dao;

import models.Note;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;
import java.util.ArrayList;

public class Sql2oNoteDao implements NoteDao {
  private final Sql2o sql2o;
  public Sql2oNoteDao(Sql2o sql2o) { this.sql2o = sql2o; }

  @Override
  public void add(Note note) {
    String sql = "INSERT INTO notes (heading, description, universityid, courseid, notepicture, teacherid, requirement, lectureid, unitid) VALUES (:heading, :description, :universityid, :courseid, :notepicture, :teacherid, :requirement, :lectureid, :unitid)"; //if you change your model, be sure to update here as well!
    try (Connection con = sql2o.open()) {
      int id = (int) con.createQuery(sql, true)
      .addParameter("heading", note.getHeading())
        .addParameter("description", note.getDescription())
        .addParameter("universityid", note.getUniversityId())
        .addParameter("courseid", note.getCourseId())
        .addParameter("notepicture", note.getNotePicture())
        .addParameter("teacherid", note.getTeacherId())
        .addParameter("requirement", note.getRequirement())
        .addParameter("lectureid", note.getLectureId())
        .addParameter("unitid", note.getUnitId())
       .executeUpdate()
       .getKey();
        note.setId(id);
        //requirements

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
  public List<Note> getFirstThreeNotes() {
    try (Connection con = sql2o.open()) {
      return con.createQuery("select notes.heading, courses.major from notes,courses where notes.courseid  = courses.id")
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
  public Note findStudentNotesByUnitId(int unitid){
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM notes WHERE unitid = :unitid")
      .addParameter("unitid", unitid)
      .executeAndFetchFirst(Note.class);
    }
  }

  @Override
  public void update(int id, String heading, String description, int universityid, int courseid, String notepicture, int teacherid, String requirement, int lectureid, int unitid) {
    String sql = "UPDATE teachers SET (heading, description, universityid, courseid, notepicture, teacherid, requirement, lectureid, unitid) = (:heading, :description, :universityid, :courseid, :notepicture, :teacherid, :requirement, :lectureid, :unitid) WHERE id=:id"; //CHECK!!!
    try (Connection con = sql2o.open()) {
      con.createQuery(sql)
      .addParameter("heading", heading)
      .addParameter("description", description)
      .addParameter("universityid", universityid)
      .addParameter("courseid", courseid)
      .addParameter("notepicture", notepicture)
      .addParameter("teacherid", teacherid)
      .addParameter("requirement", requirement)
      .addParameter("lectureid", lectureid)
      .addParameter("unitid", unitid)
      .addParameter("id", id)
      .executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

    @Override
    public List<Note> getAllNotesByTeacher(int teacherid) {
      try (Connection con = sql2o.open()) {
        return con.createQuery("SELECT * FROM notes WHERE teacherid = :teacherid")
        .addParameter("teacherid", teacherid)
        .executeAndFetch(Note.class);
      }
    }

    @Override
    public List<Note> getAllNotesByUniversity(int universityid) {
      try (Connection con = sql2o.open()) {
        return con.createQuery("SELECT * FROM notes WHERE universityid = :universityid")
        .addParameter("universityid", universityid)
        .executeAndFetch(Note.class);
      }
    }

  @Override
  public List<Note> getAllNotesByCourse(int courseid) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM notes WHERE courseid = :courseid")
              .addParameter("courseid", courseid)
              .executeAndFetch(Note.class);
    }
  }

  @Override
  public List<Note> getAllNotesByHeading(String heading) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM notes WHERE heading LIKE :heading")
              .addParameter("heading", "%"+heading+"%")
              .executeAndFetch(Note.class);
    }
  }

  @Override
  public List<Note>getAllNotesByHeadingAndUniversityId(String heading, int universityid) {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM notes WHERE (heading LIKE :heading) AND universityid = :universityid")
              .addParameter("heading", "%"+heading+"%")
              .addParameter("universityid", universityid)
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
