package models.dao;

import models.Studentenrolment;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;
import java.util.ArrayList;

public class Sql2oStudentenrolmentDao implements StudentenrolmentDao {
  private final Sql2o sql2o;
  public Sql2oStudentenrolmentDao(Sql2o sql2o) { this.sql2o = sql2o; }

  // @Override
  // public void add(Note note) {
  //   String sql = "INSERT INTO notes (heading, description, universityid, courseid, notepicture, teacherid, requirement, lectureid) VALUES (:heading, :description, :universityid, :courseid, :notepicture, :teacherid, :requirement, :lectureid)"; //if you change your model, be sure to update here as well!
  //   try (Connection con = sql2o.open()) {
  //     int id = (int) con.createQuery(sql, true)
  //     .addParameter("heading", note.getHeading())
  //       .addParameter("description", note.getDescription())
  //       .addParameter("universityid", note.getUniversityId())
  //       .addParameter("courseid", note.getCourseId())
  //       .addParameter("notepicture", note.getNotePicture())
  //       .addParameter("teacherid", note.getTeacherId())
  //       .addParameter("requirement", note.getRequirement())
  //       .addParameter("lectureid", note.getLectureId())
  //      .executeUpdate()
  //      .getKey();
  //       note.setId(id);
  //       //requirements
  //
  //   } catch (Sql2oException ex) {
  //     System.out.println(ex);
  //   }
  // }
  //
  // @Override
  // public List<Note> getAll() {
  //   try (Connection con = sql2o.open()) {
  //     return con.createQuery("SELECT * FROM notes")
  //             .executeAndFetch(Note.class);
  //   }
  // }

  @Override
  public Studentenrolment findUnitsByStudentId(int studentid){
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT unitid FROM studentenrolments WHERE studentid = :studentid")
      .addParameter("studentid", studentid)
      .executeAndFetchFirst(Studentenrolment.class);
    }
  }
  //
  // @Override
  // public void update(int id, String heading, String description, int universityid, int courseid, String notepicture, int teacherid, String requirement, int lectureid) {
  //   String sql = "UPDATE teachers SET (heading, description, universityid, courseid, notepicture, teacherid, requirement, lectureid) = (:heading, :description, :universityid, :courseid, :notepicture, :teacherid, :requirement, :lectureid) WHERE id=:id"; //CHECK!!!
  //   try (Connection con = sql2o.open()) {
  //     con.createQuery(sql)
  //     .addParameter("heading", heading)
  //     .addParameter("description", description)
  //     .addParameter("universityid", universityid)
  //     .addParameter("courseid", courseid)
  //     .addParameter("notepicture", notepicture)
  //     .addParameter("teacherid", teacherid)
  //     .addParameter("requirement", requirement)
  //     .addParameter("lectureid", lectureid)
  //     .addParameter("id", id)
  //     .executeUpdate();
  //   } catch (Sql2oException ex) {
  //     System.out.println(ex);
  //   }
  // }
  //
  //   @Override
  //   public List<Note> getAllNotesByTeacher(int teacherid) {
  //     try (Connection con = sql2o.open()) {
  //       return con.createQuery("SELECT * FROM notes WHERE teacherid = :teacherid")
  //       .addParameter("teacherid", teacherid)
  //       .executeAndFetch(Note.class);
  //     }
  //   }
  //
  //   @Override
  //   public List<Note> getAllNotesByUniversity(int universityid) {
  //     try (Connection con = sql2o.open()) {
  //       return con.createQuery("SELECT * FROM notes WHERE universityid = :universityid")
  //       .addParameter("universityid", universityid)
  //       .executeAndFetch(Note.class);
  //     }
  //   }
  //
  // @Override
  // public List<Note> getAllNotesByCourse(int courseid) {
  //   try (Connection con = sql2o.open()) {
  //     return con.createQuery("SELECT * FROM notes WHERE courseid = :courseid")
  //             .addParameter("courseid", courseid)
  //             .executeAndFetch(Note.class);
  //   }
  // }
  //
  // @Override
  // public List<Note> getAllNotesByHeading(String heading) {
  //   try (Connection con = sql2o.open()) {
  //     return con.createQuery("SELECT * FROM notes WHERE heading LIKE :heading")
  //             .addParameter("heading", "%"+heading+"%")
  //             .executeAndFetch(Note.class);
  //   }
  // }
  //
  // @Override
  // public void deleteById(int id) {
  //   String sql = "DELETE from notes WHERE id=:id";
  //   try (Connection con = sql2o.open()) {
  //     con.createQuery(sql)
  //             .addParameter("id", id)
  //             .executeUpdate();
  //   } catch (Sql2oException ex) {
  //     System.out.println(ex);
  //   }
  // }
  //
  // @Override
  // public void clearAll() {
  //   String sql = "DELETE from notes";
  //   try (Connection con = sql2o.open()) {
  //     con.createQuery(sql).executeUpdate();
  //   } catch (Sql2oException ex) {
  //     System.out.println(ex);
  //   }
  // }
}
