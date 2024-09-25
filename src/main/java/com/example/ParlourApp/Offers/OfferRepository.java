package com.example.ParlourApp.Offers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface OfferRepository extends JpaRepository<OfferRegModel, Long> {
//    static List<OfferRegModel> findOffersByYear(int year) {
//        return null;
//    }
//
//
//    static BigDecimal calculateTotalAmountByYear(int year) {
//        return null;
//    }
//
//    static String findMostPopularItemByYear(int year) {
//        return null;
//    }


    List<OfferRegModel> findByParlourId(Long parlourId);

    @Query("SELECT o FROM OfferRegModel o WHERE YEAR(o.startDate) = :year")
    static List<OfferRegModel> findOffersByYear(int year) {
      return null;
    }



    @Query("SELECT SUM(o.offerPrice) FROM OfferRegModel o WHERE YEAR(o.startDate) = :year")
    static BigDecimal calculateTotalAmountByYear(int year) {
        return null;
    }



   @Query("SELECT o.name FROM OfferRegModel o WHERE YEAR(o.startDate) = :year GROUP BY o.name ORDER BY COUNT(o.name) DESC")
   static String findMostPopularItemByYear(int year) {
        return null;
  }
}
