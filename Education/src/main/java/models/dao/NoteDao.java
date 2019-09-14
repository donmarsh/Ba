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
  Note findById(int id);
  // List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId);

  //update
  //void update(int id, String heading, String description, int universityId, int courseId, String notePicture, int teacherId, int contentId);

  //delete
  void deleteById(int id);
  void clearAll();
}
