package models;
import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;
import java.util.Objects;


public class Enrolment {
  private int id;
  private int teacherid;
  private int noteid;

  public Enrolment(int teacherid, int noteid){
    this.teacherid = teacherid;
    this.noteid = noteid;
  }
  //lecture
  //description
  //video
  //slide
  //document

  @Override
  public boolean equals(Object otherEnrolment){
    if (!(otherEnrolment instanceof Enrolment)) {
      return false;
    } else {
      Enrolment newEnrolment = (Enrolment) otherEnrolment;
      return this.getTeacherId() == newEnrolment.getTeacherId() &&
      this.getId() == newEnrolment.getId();
    }
  }

   public int getTeacherId() {
     return teacherid;
   }

   public int getNoteId() {
     return noteid;
   }

   public int getId() {
      return id;
   }

   public void setTeacherId(int teacherid) {
     this.teacherid = teacherid;
   }

   public void setNoteId(int noteid) {
     this.noteid = noteid;
   }

   public void setId(int id) {
       this.id = id;
   }

 }
