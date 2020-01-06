package models.dao;

import models.Unit;
import java.util.List;

public interface UnitDao {

  //create
  void add (Unit unit);
  // void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype)

  //read
  List<Unit> getAll();
  List<Unit> getCourseById(int id);
  Unit findById(int id);
  // List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId);

  //update
  //void update(int id, String wordLink, String powerpointLink, String pdfLink);

  //delete
  void deleteById(int id);
  void clearAll();
}
