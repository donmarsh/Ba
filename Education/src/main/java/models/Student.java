package models;

import java.util.Objects;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.sql2o.*;


public class Student {
  private int id;
  private String firstname;
  private String lastname;
  private String email;
  private String profilepicture;
  private String location;
  private int genderid ;
  private Date dateofbirth;
  private String password;

  public Student(String firstname, String lastname, String email, String profilepicture, String location, int genderid, Date dateofbirth, String password){
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.profilepicture = profilepicture;
    this.location = location;
    this.genderid = genderid;
    this.dateofbirth = dateofbirth;
    this.password = password;
  }

  @Override
  public boolean equals(Object otherStudent){
    if (!(otherStudent instanceof Student)) {
      return false;
    } else {
      Student newStudent = (Student) otherStudent;
      return this.getFirstName().equals(newStudent.getFirstName()) &&
      this.getLastName().equals(newStudent.getLastName()) &&
      this.getId() == newStudent.getId() &&
      this.getGenderId() == newStudent.getGenderId();
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

   public String getProfilePicture() {
     return profilepicture;
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

    public void setProfilePicture(String profilepicture) {
      this.profilepicture = profilepicture;
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
