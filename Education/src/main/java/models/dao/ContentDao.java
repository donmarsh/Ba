package dao;

import models.Content;
import java.util.List;

public interface ContentDao {

  //create
  void add (Content content);
  // void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype)

  //read
  List<Content> getAll();
  Content findById(int id);
  // List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId);

  //update
  void update(int id, String filename);

  //delete
  void deleteById(int id);
  void clearAll();
}
