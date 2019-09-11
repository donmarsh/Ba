package dao;

import models.University;
import java.util.List;

public interface UniversityDao {

  //create
  void add (University university);
  // void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype)

  //read
  List<University> getAll();
  University findById(int id);
  // List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId);

  //update
  //void update(int id, String name, String description, String location);

  //delete
  void deleteById(int id);
  void clearAll();
}
