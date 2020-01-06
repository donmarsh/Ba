package models.dao;

import models.Enrolment;
import java.util.List;

public interface EnrolmentDao {

  //create
  void add (Enrolment enrolment);
  // void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype)

  //read
  List<Enrolment> getAll();
  Enrolment findById(int id);
  // List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId);

  //update
  void update(int id, int teacherid, int noteid );

  //delete
  void deleteById(int id);
  void clearAll();
}
