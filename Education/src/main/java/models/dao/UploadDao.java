package dao;

import models.Upload;
import java.util.List;

public interface UploadDao {

  //create
  void add (Upload upload);
  // void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype)

  //read
  List<Upload> getAll();
  Upload findById(int id);
  // List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId);

  //update
  void update(int id, String filename);

  //delete
  void deleteById(int id);
  void clearAll();
}
