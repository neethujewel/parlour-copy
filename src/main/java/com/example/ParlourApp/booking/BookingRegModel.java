package com.example.ParlourApp.booking;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "booking")
public class BookingRegModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "itemId", nullable = false)
    private Long itemId;

    @Column(name = "parlourId", nullable = false)
    private Long parlourId;

    @Column(name = "employeeId")
    private Long employeeId;

    @Column(name = "categoryId")
    private Long categoryId;

    @Column(name = "subCategoryId")
    private Long subCategoryId;

    @Column(name = "subSubCategoryId")
    private Long subSubCategoryId;

    @Column(name = "bookingDate", nullable = false)
    private LocalDate bookingDate;

    @Column(name = "bookingTime", nullable = false)
    private LocalTime bookingTime;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "price")
    private Double price;

    @Column(name = "paymentStatus")
    private String paymentStatus;  // e.g. 'PAID', 'PENDING', etc.

    @Column(name = "createdDate", nullable = false)
    private LocalDate createdDate;

    @Column(name = "updatedDate")
    private LocalDate updatedDate;

    @Column(name = "serviceDuration")
    private Integer serviceDuration;  // Duration in minutes

    @Column(name = "specialRequest", length = 500)
    private String specialRequest;

    @Column(name = "ratingGiven")
    private Boolean ratingGiven = false;

    @Column(name = "isCancelled")
    private Boolean isCancelled = false;
}
