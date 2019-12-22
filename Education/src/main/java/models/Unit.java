package models;
import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;


import java.util.Objects;


public class Unit {
  private int id;
  private String name;
  private int courseid;

  public Unit(String name, int courseid){
    this.name = name;
    this.courseid = courseid;
  }

  @Override
  public boolean equals(Object otherUnit){
    if (!(otherUnit instanceof Unit)) {
      return false;
    } else {
      Unit newUnit = (Unit) otherUnit;
      return this.getName().equals(newUnit.getName()) &&
      this.getId() == newUnit.getId();
    }
  }

   public String getName() {
     return name;
   }

   public int getCourseId() {
     return courseid;
   }

   public int getId() {
       return id;
   }

   public void setName(String name) {
     this.name = name;
   }

   public void setCourseId(int courseid) {
     this.courseid = courseid;
   }

   public void setId(int id) {
       this.id = id;
   }

 }
