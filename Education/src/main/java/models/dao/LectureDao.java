package models.dao;

import models.Lecture;
import java.util.List;

public interface LectureDao {

  //create
  void add (Lecture lecture);
  // void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype)

  //read
  List<Lecture> getAll();
  List<Lecture> getLectureById(int id);
  Lecture findById(int id);
  // List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId);

  //update
  void update(int id, String name, int contentid, int noteid);

  //delete
  void deleteById(int id);
  void clearAll();

  //display lectureid for a courses
  List<Lecture> getLectureByNoteId(int noteid);
}
