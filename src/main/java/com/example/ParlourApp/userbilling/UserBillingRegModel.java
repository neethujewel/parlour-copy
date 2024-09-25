package com.example.ParlourApp.userbilling;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "UserBilling")
public class UserBillingRegModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "orderId")
    private String orderId;

    @Column(name = "paymentId")
    private String paymentId;

    @Column(name = "itemId")
    private Long itemId;

    @Column(name = "parlourId")
    private Long parlourId;

    @Column(name = "employeeId")
    private Long employeeId;

    @Column(name = "bookingTime")
    private LocalTime bookingTime;

    @Column(name = "bookingDate")
    private LocalDate bookingDate;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "totalPrice")
    private BigDecimal totalPrice;

    @Column(name = "uniqueId")
    private String uniqueId;

    @Column(name = "status", nullable = false)
    private String status = "Pending";

    // New fields
    @Column(name = "discountApplied")
    private BigDecimal discountApplied;

    @Column(name = "paymentMethod")
    private String paymentMethod;

    @Column(name = "transactionDate")
    private LocalDate transactionDate;

    @Column(name = "gst")
    private BigDecimal gst;

    @Column(name = "serviceCharge")
    private BigDecimal serviceCharge;

    @Column(name = "billingAddress")
    private String billingAddress;

    @Column(name = "isRefunded")
    private Boolean isRefunded = false;

    @Column(name = "refundAmount")
    private BigDecimal refundAmount;

    public UserBillingRegModel(Long userId, String orderId, String paymentId, Long itemId, Long parlourId, Long employeeId, LocalTime bookingTime, LocalDate bookingDate, Integer quantity, BigDecimal totalPrice, String uniqueId, String status, BigDecimal discountApplied, String paymentMethod, LocalDate transactionDate, BigDecimal gst, BigDecimal serviceCharge, String billingAddress, Boolean isRefunded, BigDecimal refundAmount) {
        this.userId = userId;
        this.orderId = orderId;
        this.paymentId = paymentId;
        this.itemId = itemId;
        this.parlourId = parlourId;
        this.employeeId = employeeId;
        this.bookingTime = bookingTime;
        this.bookingDate = bookingDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.uniqueId = uniqueId;
        this.status = status;
        this.discountApplied = discountApplied;
        this.paymentMethod = paymentMethod;
        this.transactionDate = transactionDate;
        this.gst = gst;
        this.serviceCharge = serviceCharge;
        this.billingAddress = billingAddress;
        this.isRefunded = isRefunded;
        this.refundAmount = refundAmount;
    }

    public UserBillingRegModel() {
    }
}
