package models.dao;

import models.Review;

import java.util.List;

public interface ReviewDao {
    //create
    void add(Review review);

    //read
    List<Review> getAll();
    List<Review> getAllReviewsByNote(int noteid);
    List<Review> getAllReviewsByNoteSortedNewestToOldest(int restaurantid);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
