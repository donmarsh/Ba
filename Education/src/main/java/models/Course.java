package models;
import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;


import java.util.Objects;


public class Course {
  private int id;
  private String major;
  private String speciality;

  public Course(String major, String speciality){
    this.major = major;
    this.speciality = speciality;
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

   public String getSpeciality() {
     return speciality;
   }

   public int getId() {
       return id;
   }

   public void setMajor(String major) {
     this.major = major;
   }

   public void setSpeciality(String speciality) {
     this.speciality = speciality;
   }

   public void setId(int id) {
       this.id = id;
   }

 }
