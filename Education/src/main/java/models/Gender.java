package models;

import java.util.Objects;
import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class Gender {
  private int id;
  private String name;

  public Gender(String name){
    this.name = name;
  }

  @Override
  public boolean equals(Object otherGender){
    if (!(otherGender instanceof Gender)) {
      return false;
    } else {
      Gender newGender = (Gender) otherGender;
      return this.getName().equals(newGender.getName()) &&
      this.getId() == newGender.getId();
    }
  }

   public String getName() {
     return name;
   }

   public int getId() {
       return id;
   }
   public void setName(String name) {
     this.name = name;
   }

   public void setId(int id) {
       this.id = id;
   }
}
