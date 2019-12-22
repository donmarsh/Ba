package models;

import java.util.Objects;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.sql2o.*;


public class Studentenrolment {
  private int id;
  private int studentid;
  private int unitid;

  public Studentenrolment(int studentid, int unitid){
    this.studentid = studentid;
    this.unitid = unitid;
  }

  @Override
  public boolean equals(Object otherStudentenrolment){
    if (!(otherStudentenrolment instanceof Studentenrolment)) {
      return false;
    } else {
      Studentenrolment newStudentenrolment = (Studentenrolment) otherStudentenrolment;
      return this.getStudentId() == (newStudentenrolment.getStudentId()) &&
      this.getUnitId() == newStudentenrolment.getUnitId();
    }
  }

   public int getStudentId() {
     return studentid;
   }

   public int getUnitId() {
     return unitid;
   }

    public int getId() {
        return id;
    }
    public void setUnitId(int unitid) {
      this.unitid = unitid;
    }

    public void setStudentId(int studentid) {
      this.studentid = studentid;
    }

     public void setId(int id) {
         this.id = id;
     }
}
