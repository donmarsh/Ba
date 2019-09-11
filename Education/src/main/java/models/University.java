package models;

import java.util.Objects;
import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class University {
  private int id;
  private String name;
  private String description;
  private String location;

  public University(String name, String description, String location){
    this.name = name;
    this.description = description;
    this.location = location;

  }
  @Override
  public boolean equals(Object otherUniversity){
    if (!(otherUniversity instanceof University)) {
      return false;
    } else {
      University newUniversity = (University) otherUniversity;
      return this.getName().equals(newUniversity.getName()) &&
      this.getId() == newUniversity.getId();
    }
  }

   public String getName() {
     return name;
   }

   public String getDescription() {
     return description;
   }

   public String getLocation() {
     return location;
   }

   public int getId() {
       return id;
   }
   public void setName(String name) {
     this.name = name;
   }

   public void setDescription(String description) {
     this.description = description;
   }

   public void setLocation(String location) {
     this.location = location;
   }

   public void setId(int id) {
       this.id = id;
   }
}
