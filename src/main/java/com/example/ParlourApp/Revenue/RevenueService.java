package com.example.ParlourApp.Revenue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@Slf4j
public class RevenueService {
    @Autowired
    private RevenueRepository revenueRepository;

    public Revenue saveRevenue(Revenue revenue) {
        return revenueRepository.save(revenue);
    }

    public List<Revenue> getAllRevenues() {
        return revenueRepository.findAll();
    }

    public Double calculateTotalRevenue() {
        return revenueRepository.calculateTotalRevenue();
    }

    public List<Revenue> getRevenuesByDate(LocalDate startDate, LocalDate endDate) {
        return revenueRepository.findByDateBetween(startDate, endDate);
    }
}
