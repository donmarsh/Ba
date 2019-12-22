package dao;

import models.Note;
import java.util.List;

public interface NoteDao {

  //create
  void add (Note note);
  // void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype)

  //read
  List<Note> getAll();
  List<Note> getAllNotesByTeacher(int teacherid);
  List<Note> getAllNotesByUniversity(int universityid);
  List<Note> getAllNotesByCourse(int courseid);
  List<Note> getAllNotesByHeading(String heading);
  List<Note> getAllNotesByHeadingAndUniversityId(String heading, int universityid);
  Note findById(int id);
  List<Note> getFirstThreeNotes();

  Note findStudentNotesByUnitId(int unitid);
  // List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId);

  //update
  void update(int id, String heading, String description, int universityid, int courseid, String notepicture, int teacherid, String requirements, int lectureid, int unitid);

  //delete
  void deleteById(int id);
  void clearAll();
}
