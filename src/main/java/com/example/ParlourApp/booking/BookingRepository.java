package com.example.ParlourApp.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingRegModel, Long> {

    // Fetch bookings for a specific parlour on a specific date
    List<BookingRegModel> findByParlourIdAndBookingDate(Long parlourId, LocalDate bookingDate);

    // Fetch bookings for a specific parlour within a date range
    @Query("SELECT b FROM BookingRegModel b WHERE b.parlourId = :parlourId AND b.bookingDate BETWEEN :startDate AND :endDate")
    List<BookingRegModel> findBookingsWithinDateRange(@Param("parlourId") Long parlourId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    long count();
    @Query("SELECT COUNT(*) FROM BookingRegModel b WHERE /* your custom criteria */")
    Long countByCriteria(/* your query parameters */);
}
