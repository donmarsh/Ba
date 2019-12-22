package models;
import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;
import java.util.Objects;


public class Content {
  private int id;
  private String filename;

  public Content(String filename){
    this.filename = filename;
  }
  //lecture
  //description
  //video
  //slide
  //document

  @Override
  public boolean equals(Object otherContent){
    if (!(otherContent instanceof Content)) {
      return false;
    } else {
      Content newContent = (Content) otherContent;
      return this.getFileName().equals(newContent.getFileName()) &&
      this.getId() == newContent.getId();
    }
  }

   public String getFileName() {
     return filename;
   }

   public int getId() {
      return id;
   }

   public void setFileName(String filename) {
     this.filename = filename;
   }

   public void setId(int id) {
       this.id = id;
   }

 }
