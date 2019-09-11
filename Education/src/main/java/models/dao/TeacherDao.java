package dao;

import java.util.Date;
import java.text.SimpleDateFormat;
import models.Teacher;
import java.util.List;

public interface TeacherDao {

  //create
  void add (Teacher teacher);
  // void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype)

  //read
  List<Teacher> getAll();
  Teacher findById(int id);
  // List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId);

  //update
  //void update(int id, String name, String email, int universityId, int courseId, int staffNumber, String profilePicture, String educationLevel, String location, String gender, Date dateOfBirth);

  //delete
  void deleteById(int id);
  void clearAll();
}
