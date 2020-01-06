package models.dao;

import models.Studentenrolment;
import java.util.List;

public interface StudentenrolmentDao {

  //create
  //void add (Note note);
  // void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype)

  //read
  // List<Note> getAll();
  // List<Note> getAllNotesByTeacher(int teacherid);
  // List<Note> getAllNotesByUniversity(int universityid);
  // List<Note> getAllNotesByCourse(int courseid);
  // List<Note> getAllNotesByHeading(String heading);
  Studentenrolment findUnitsByStudentId(int studentid);
  // List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId);

  //update
  // void update(int id, String heading, String description, int universityid, int courseid, String notepicture, int teacherid, String requirements, int lectureid);
  //
  // //delete
  // void deleteById(int id);
  // void clearAll();
}
