package com.example.ParlourApp.userbilling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface UserBillingRepository extends JpaRepository<UserBillingRegModel, Long> {

    // Custom query for specific combination of fields
    List<UserBillingRegModel> findByUserIdAndOrderIdAndPaymentIdAndItemIdAndParlourIdAndEmployeeIdAndBookingTimeAndBookingDateAndQuantityAndStatus(
            Long userId, String orderId, String paymentId, Long itemId, Long parlourId, Long employeeId, LocalTime bookingTime, LocalDate bookingDate, Integer quantity, String status
    );

    // Find by orderId
    Optional<UserBillingRegModel> findByOrderId(String orderId);

    // Find by ID (use 'id' not 'userId')
    Optional<UserBillingRegModel> findById(Long id);

    // Query to fetch all booking statuses
    @Query("SELECT u.status FROM UserBillingRegModel u")
    List<String> findAllBookingStatuses();

    // Find by userId
    Optional<UserBillingRegModel> findByUserId(Long userId);

    // Find by userId and booking date
    List<UserBillingRegModel> findByUserIdAndBookingDate(Long userId, LocalDate bookingDate);

    // Find first record by userId and booking date
    Optional<UserBillingRegModel> findFirstByUserIdAndBookingDate(Long userId, LocalDate bookingDate);

    // Find by booking date range (adjusted to use LocalDate if appropriate)
    List<UserBillingRegModel> findByBookingDateBetween(LocalDate startDate, LocalDate endDate);

    // Find all bookings after a given date (use LocalDate instead of Instant)
    List<UserBillingRegModel> findAllByBookingDateAfter(LocalDate bookingDate);

    // Implemented method to find recent bookings (can be based on the date)
    @Query("SELECT u FROM UserBillingRegModel u WHERE u.bookingDate >= CURRENT_DATE")
    List<UserBillingRegModel> findRecent();
}
