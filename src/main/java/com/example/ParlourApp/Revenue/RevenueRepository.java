package com.example.ParlourApp.Revenue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Long> {

    @Query("SELECT SUM(r.amount) FROM Revenue r")
    Double calculateTotalRevenue();

    List<Revenue> findByDateBetween(LocalDate startDate, LocalDate endDate);

    Double sumAll();
}
