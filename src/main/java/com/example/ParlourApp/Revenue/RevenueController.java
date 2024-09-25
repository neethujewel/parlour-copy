package com.example.ParlourApp.Revenue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(path = "/revenue")
public class RevenueController {
    @Autowired
    private RevenueService revenueService;

    @PostMapping(path = "/create")
    public Revenue createRevenue(@RequestBody Revenue revenue) {
        return revenueService.saveRevenue(revenue);
    }

    @GetMapping(path = "/allrevenue")
    public List<Revenue> getAllRevenues() {
        return revenueService.getAllRevenues();
    }

    @GetMapping(path = "/totalRevenue")
    public Double getTotalRevenue() {
        return revenueService.calculateTotalRevenue();
    }

    @GetMapping(path = "/date")
    public List<Revenue> getRevenuesByDate(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                           @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return revenueService.getRevenuesByDate(startDate, endDate);
    }

}
