package dao;

import models.Gender;
import java.util.List;

public interface GenderDao {

  //create
  void add (Gender gender);
  // void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype)

  //read
  List<Gender> getAll();
  Gender findById(int id);
  // List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId);

  //update
  void update(int id, String name);

  //delete
  void deleteById(int id);
  void clearAll();
}
