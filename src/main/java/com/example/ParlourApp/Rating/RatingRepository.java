package com.example.ParlourApp.Rating;

import com.example.ParlourApp.parlour.ParlourRegModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<RatingModel,Long> {
    List<RatingModel> findByParlour_Id(Long parlourId);
    List<RatingModel> findByReview_CountGreaterThan(int count);
    List<RatingModel> findByReviewIn(List<String> reviewIds);
    List<RatingModel> findWithReviewCountGreaterThan(@Param("count") int count);

//    List<ParlourRegModel> findByRatingIsNull();
//    List<RatingModel> findByRating(int rating);
//    @Query("SELECT r FROM RatingModel r WHERE r.ratingValue = :ratingValue")
//    List<RatingModel> findByRatingValue(@Param("ratingValue") int ratingValue);
//
//    @Query("SELECT p FROM ParlourRegModel p WHERE p.ratings.size > 0")
//    List<ParlourRegModel> getParloursByReviews();
}

