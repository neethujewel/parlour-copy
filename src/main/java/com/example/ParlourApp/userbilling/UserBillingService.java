package com.example.ParlourApp.userbilling;

import com.example.ParlourApp.cart.CartRegModel;
import com.example.ParlourApp.cart.CartRepository;
import com.example.ParlourApp.razorPay.OrderDetailsService;
import com.example.ParlourApp.razorPay.TransactionDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserBillingService {

    @Autowired
    private UserBillingRepository userBillingRepository;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Autowired
    private CartRepository cartRepository;

    public UserBillingRegModel createUserBilling(String uniqueId, BigDecimal discount) {
        List<CartRegModel> cartItems = cartRepository.findAllByUniqueId(uniqueId);
        if (cartItems.isEmpty()) {
            throw new RuntimeException("No cart items found for the given unique ID: " + uniqueId);
        }

        // Calculate total price and quantity
        BigDecimal totalPrice = cartItems.stream()
                .map(CartRegModel::getActualPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        int totalQuantity = cartItems.stream()
                .mapToInt(CartRegModel::getQuantity)
                .sum();

        // Apply discount if any, ensuring total price is not negative
        if (discount != null && discount.compareTo(totalPrice) <= 0) {
            totalPrice = totalPrice.subtract(discount);
        } else if (discount != null) {
            log.warn("Discount exceeds total price. Discount will not be applied.");
            discount = BigDecimal.ZERO;  // Reset discount if it's invalid
        }

        // Initialize UserBilling model with data from the first cart item
        CartRegModel firstItem = cartItems.get(0);
        UserBillingRegModel userBilling = new UserBillingRegModel();

        log.info("Setting user ID: {}", firstItem.getUserId());
        userBilling.setUserId(firstItem.getUserId());
        userBilling.setUniqueId(uniqueId);
        userBilling.setTotalPrice(totalPrice);
        userBilling.setQuantity(totalQuantity);
        userBilling.setStatus("Pending");

        // Set transaction details via Razorpay (or another payment provider)
        TransactionDetails transactionDetails = orderDetailsService.createTransaction(totalPrice.intValue(), firstItem.getUserId());
        if (transactionDetails != null) {
            userBilling.setOrderId(transactionDetails.getOrderId());
            userBilling.setPaymentId(transactionDetails.getPaymentId());
        } else {
            throw new RuntimeException("Failed to retrieve transaction details from payment gateway.");
        }

        // Set booking details from the cart
        userBilling.setBookingDate(firstItem.getBookingDate());
        userBilling.setBookingTime(firstItem.getBookingTime());
        userBilling.setItemId(firstItem.getItemId());
        userBilling.setParlourId(firstItem.getParlourId());
        userBilling.setEmployeeId(firstItem.getEmployeeId());

        // Set the transaction date
        userBilling.setTransactionDate(LocalDate.now());

        // Save the UserBilling record to the database
        return userBillingRepository.save(userBilling);
    }

    public Optional<UserBillingRegModel> getUserBillingById(Long id) {
        return userBillingRepository.findById(id);
    }

    public List<LocalTime> getAllBookingTimes() {
        // Implement logic to fetch all booking times
        return null;
    }

    public List<String> getAllBookingStatuses() {
        // Implement logic to fetch all booking statuses
        return null;
    }

    public List<Long> getAllBookingIds() {
        // Implement logic to fetch all booking IDs
        return null;
    }
}
