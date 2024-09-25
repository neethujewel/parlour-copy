package com.example.ParlourApp.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Get bookings for a specific day
    @GetMapping("/parlour/{parlourId}/day")
    public ResponseEntity<List<BookingRegModel>> getOneDayBookings(
            @PathVariable Long parlourId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<BookingRegModel> bookings = bookingService.getOneDayBookings(parlourId, date);
        return ResponseEntity.ok(bookings);
    }

    // Get bookings for the current week
    @GetMapping("/parlour/{parlourId}/week")
    public ResponseEntity<List<BookingRegModel>> getOneWeekBookings(
            @PathVariable Long parlourId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<BookingRegModel> bookings = bookingService.getOneWeekBookings(parlourId, date);
        return ResponseEntity.ok(bookings);
    }

    // Get bookings for the current month
    @GetMapping("/parlour/{parlourId}/month")
    public ResponseEntity<List<BookingRegModel>> getOneMonthBookings(
            @PathVariable Long parlourId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<BookingRegModel> bookings = bookingService.getOneMonthBookings(parlourId, date);
        return ResponseEntity.ok(bookings);
    }
}
