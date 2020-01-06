package models.dao;

import models.Educationlevel;
import java.util.List;

public interface EducationlevelDao {

  //create
  void add (Educationlevel educationlevel);
  // void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype)

  //read
  List<Educationlevel> getAll();
  Educationlevel findById(int id);
  // List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId);

  //update
  void update(int id, String name);

  //delete
  void deleteById(int id);
  void clearAll();
}
