package models;
import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;


import java.util.Objects;


public class Course {
  private int id;
  private String major;

  public Course(String major){
    this.major = major;
  }

  @Override
  public boolean equals(Object otherCourse){
    if (!(otherCourse instanceof Course)) {
      return false;
    } else {
      Course newCourse = (Course) otherCourse;
      return this.getMajor().equals(newCourse.getMajor()) &&
      this.getId() == newCourse.getId();
    }
  }

   public String getMajor() {
     return major;
   }


   public int getId() {
       return id;
   }

   public void setMajor(String major) {
     this.major = major;
   }


   public void setId(int id) {
       this.id = id;
   }

 }
