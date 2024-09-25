package com.example.ParlourApp.userbilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/userBill")
public class UserBillingController {

    @Autowired
    private UserBillingService userBillingService;

    // Create a user billing entry
    @PostMapping("/create")
    public ResponseEntity<?> createUserBilling(
            @RequestParam String uniqueId,
            @RequestParam(required = false) BigDecimal discount) {

        // Validate the uniqueId parameter
        if (uniqueId == null || uniqueId.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Unique ID must not be null or empty.");
        }

        try {
            // Create user billing with optional discount
            UserBillingRegModel userBilling = userBillingService.createUserBilling(uniqueId, discount);
            return ResponseEntity.ok(userBilling);
        } catch (RuntimeException e) {
            // Handle any exceptions (e.g., transaction failure, invalid data)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create billing: " + e.getMessage());
        }
    }

    // Get user billing details by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserBillingById(@PathVariable Long id) {
        Optional<UserBillingRegModel> userBilling = userBillingService.getUserBillingById(id);

        // If user billing record is found, return it; otherwise, return 404
        if (userBilling.isPresent()) {
            return ResponseEntity.ok(userBilling.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Billing record not found for ID: " + id);
        }
    }
}

