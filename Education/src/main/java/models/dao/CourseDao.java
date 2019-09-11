package dao;

import models.Course;
import java.util.List;

public interface CourseDao {

  //create
  void add (Course course);
  // void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype)

  //read
  List<Course> getAll();
  List<Course> getCourseById(int id);
  Course findById(int id);
  // List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId);

  //update
  //void update(int id, String wordLink, String powerpointLink, String pdfLink);

  //delete
  void deleteById(int id);
  void clearAll();
}
