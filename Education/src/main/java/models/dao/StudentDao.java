package models.dao;

import java.util.Date;
import java.text.SimpleDateFormat;
import models.Student;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public interface StudentDao {

  //create
  JSONObject add (Student student);
  // void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype)

  //read
  List<Student> getAll();
  Student findById(int id);
  // List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId);

  //update
//  void update(int id, String firstname, String lastname, String email, int universityid, int courseid, int staffnumber, String profilepicture, String educationlevel, String location, String gender, Date dateOfBirth, String password);

  //delete
  void deleteById(int id);
  void clearAll();

}
