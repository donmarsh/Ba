package models;
import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;


import java.util.Objects;


public class Note {
  private int id;
  private String heading;
  private String description;
  private int universityid;
  private int courseid;
  private String notepicture;
  private int teacherid;
  private int contentid;

  public Note(String heading, String description, int universityid, int courseid, String notepicture, int teacherid, int contentid){
    this.heading = heading;
    this.description = description;
    this.universityid = universityid;
    this.courseid = courseid;
    this.notepicture = notepicture;
    this.teacherid = teacherid;
    this.contentid = contentid;
  }

  @Override
  public boolean equals(Object otherNote){
    if (!(otherNote instanceof Note)) {
      return false;
    } else {
      Note newNote = (Note) otherNote;
      return this.getHeading().equals(newNote.getHeading()) &&
      this.getId() == newNote.getId() &&
      this.getUniversityId() == newNote.getUniversityId()&&
      this.getTeacherId() == newNote.getTeacherId() &&
      this.getContentId() == newNote.getContentId();
    }
  }

   public String getHeading() {
     return heading;
   }

   public String getDescription() {
     return description;
   }

   public int getUniversityId() {
     return universityid;
   }

   public int getCourseId() {
     return courseid;
   }

   public String getNotePicture() {
     return notepicture;
   }

   public int getTeacherId() {
     return teacherid;
   }

   public int getContentId() {
     return contentid;
   }

   public int getId() {
     return id;
   }

   public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUniversityId(int universityid) {
        this.universityid = universityid;
    }

    public void setNotePicture(String notepicture) {
        this.notepicture = notepicture;
    }

    public void setTeacherId(int teacherid) {
        this.teacherid = teacherid;
    }

    public void setContentId(int contentid) {
        this.contentid = contentid;
    }

    public void setId(int id) {
        this.id = id;
    }
 }
//find by university
//find by teacher
//find by category ****
//find by heading **

//link one to many*******
//additional methods**
//compare equals**
//import**
