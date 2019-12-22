package models;
import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;
import java.util.Objects;


public class Upload {
  private int id;
  private String filename;

  public Upload(String filename){
    this.filename = filename;
  }


  @Override
  public boolean equals(Object otherUpload){
    if (!(otherUpload instanceof Upload)) {
      return false;
    } else {
      Upload newUpload = (Upload) otherUpload;
      return this.getFileName().equals(newUpload.getFileName()) &&
      this.getId() == newUpload.getId();
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
