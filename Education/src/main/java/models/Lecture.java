package models;

import java.util.Objects;
import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class Lecture {
  private int id;
  private String name;
  private int contentid;
  private int noteid;

  public Lecture(String name, int contentid, int noteid){
    this.name = name;
    this.contentid = contentid;
    this.noteid = noteid;
  }

  @Override
  public boolean equals(Object otherLecture){
    if (!(otherLecture instanceof Lecture)) {
      return false;
    } else {
      Lecture newLecture = (Lecture) otherLecture;
      return this.getName().equals(newLecture.getName()) &&
      this.getId() == newLecture.getId() &&
      this.getContentId() == newLecture.getContentId()&&
      this.getNoteId() == newLecture.getNoteId();
    }
  }

   public String getName() {
     return name;
   }

   public int getId() {
       return id;
   }

   public int getContentId() {
     return contentid;
   }

   public int getNoteId() {
     return noteid;
   }

   public void setName(String name) {
     this.name = name;
   }

   public void setId(int id) {
       this.id = id;
   }

   public void setContentId(int contentid) {
     this.contentid = contentid;
   }
   public void setNoteId(int noteid) {
     this.noteid = noteid;
   }
}
