package models;

import java.util.Objects;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.sql2o.*;


public class Teacher {
  private int id;
  private String name;
  private String email;
  private int universityid;
  private int courseid;
  private int staffnumber;
  private String profilepicture;
  private String educationlevel;
  private String location;
  private String gender ;
  private Date dateofbirth;

  public Teacher(String name, String email, int universityid, int courseid, int staffnumber, String profilepicture, String educationlevel, String location, String gender, Date dateofbirth){
    this.name = name;
    this.email = email;
    this.universityid = universityid;
    this.courseid = courseid;
    this.staffnumber = staffnumber;
    this.profilepicture = profilepicture;
    this.educationlevel = educationlevel;
    this.location = location;
    this.gender = gender;
    this.dateofbirth = dateofbirth;
  }

  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id &&
                Objects.equals(name, teacher.name);
    }

   public String getName() {
     return name;
   }

   public String getEmail() {
     return email;
   }

   public int getUniversityId() {
     return universityid;
   }

   public int getCourseid() {
     return courseid;
   }

   public int getStaffNumber() {
     return staffnumber;
   }

   public String getProfilePicture() {
     return profilepicture;
   }

   public String getEducationLevel() {
     return educationlevel;
   }

   public String getLocation() {
     return location;
   }

   public String getGender() {
     return gender;
   }

    public Date getDateOfBirth() {
        return dateofbirth;
    }

    public int getId() {
        return id;
    }
    public void setName(String name) {
      this.name = name;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public void setUniversityId(int universityid) {
      this.universityid = universityid;
    }

    public void setCourseId(int courseid) {
      this.courseid = courseid;
    }

    public void setStaffNumber(int staffnumber) {
      this.staffnumber = staffnumber;
    }

    public void setProfilePicture(String profilepicture) {
      this.profilepicture = profilepicture;
    }

    public void setEducationLevel(String educationlevel) {
      this.educationlevel = educationlevel;
    }

    public void setLocation(String location) {
      this.location = location;
    }

    public void setGender(String gender) {
      this.gender = gender;
    }

     public void setDateOfBirth(Date dateofbirth) {
         this.dateofbirth = dateofbirth;
     }

     public void setId(int id) {
         this.id = id;
     }
}
