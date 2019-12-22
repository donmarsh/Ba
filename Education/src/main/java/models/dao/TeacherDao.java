package dao;

import java.util.Date;
import java.text.SimpleDateFormat;
import models.Teacher;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public interface TeacherDao {

  //create
  JSONObject add (Teacher teacher);
  String login (String email, String password);
  // void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype)

  //read
  List<Teacher> getAll();
  Teacher findById(int id);
  // List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId);

  //update
//  void update(int id, String firstname, String lastname, String email, int universityid, int courseid, int staffnumber, String profilepicture, String educationlevel, String location, String gender, Date dateOfBirth, String password);

  //delete
  void deleteById(int id);
  void clearAll();

}
