package models;

import java.util.Objects;
import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class Educationlevel {
  private int id;
  private String name;

  public Educationlevel(String name){
    this.name = name;
  }

  @Override
  public boolean equals(Object otherEducationlevel){
    if (!(otherEducationlevel instanceof Educationlevel)) {
      return false;
    } else {
      Educationlevel newEducationlevel = (Educationlevel) otherEducationlevel;
      return this.getName().equals(newEducationlevel.getName()) &&
      this.getId() == newEducationlevel.getId();
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
