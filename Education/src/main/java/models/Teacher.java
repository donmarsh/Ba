package models;

import java.util.Objects;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.sql2o.*;


public class Teacher {
  private int id;
  private String firstname;
  private String lastname;
  private String email;
  private int universityid;
  private int courseid;
  private int staffnumber;
  private String profilepicture;
  private int educationlevelid;
  private String location;
  private int genderid ;
  private Date dateofbirth;
  private String password;

  public Teacher(String firstname, String lastname, String email, int universityid, int courseid, int staffnumber, String profilepicture, int educationlevelid, String location, int genderid, Date dateofbirth, String password){
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.universityid = universityid;
    this.courseid = courseid;
    this.staffnumber = staffnumber;
    this.profilepicture = profilepicture;
    this.educationlevelid = educationlevelid;
    this.location = location;
    this.genderid = genderid;
    this.dateofbirth = dateofbirth;
    this.password = password;
  }

  @Override
  public boolean equals(Object otherTeacher){
    if (!(otherTeacher instanceof Teacher)) {
      return false;
    } else {
      Teacher newTeacher = (Teacher) otherTeacher;
      return this.getFirstName().equals(newTeacher.getFirstName()) &&
      this.getLastName().equals(newTeacher.getLastName()) &&
      this.getId() == newTeacher.getId() &&
      this.getUniversityId() == newTeacher.getUniversityId()&&
      this.getGenderId() == newTeacher.getGenderId() &&
      this.getUniversityId() == newTeacher.getUniversityId();
    }
  }

   public String getFirstName() {
     return firstname;
   }

   public String getLastName() {
     return lastname;
   }

   public String getEmail() {
     return email;
   }

   public int getUniversityId() {
     return universityid;
   }

   public int getCourseId() {
     return courseid;
   }

   public int getStaffNumber() {
     return staffnumber;
   }

   public String getProfilePicture() {
     return profilepicture;
   }

   public int getEducationLevelId() {
     return educationlevelid;
   }

   public String getLocation() {
     return location;
   }

   public int getGenderId() {
     return genderid;
   }

    public Date getDateOfBirth() {
        return dateofbirth;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }
    public void setFirstName(String firstname) {
      this.firstname = firstname;
    }

    public void setLastName(String lastname) {
      this.lastname = lastname;
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

    public void setEducationLevelId(int educationlevelid) {
      this.educationlevelid = educationlevelid;
    }

    public void setLocation(String location) {
      this.location = location;
    }

    public void setGenderId(int genderid) {
      this.genderid = genderid;
    }

     public void setDateOfBirth(Date dateofbirth) {
         this.dateofbirth = dateofbirth;
     }

     public void setPassword(String password) {
         this.password = password;
     }

     public void setId(int id) {
         this.id = id;
     }
}
