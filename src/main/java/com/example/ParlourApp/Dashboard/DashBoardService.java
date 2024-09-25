package com.example.ParlourApp.Dashboard;

import com.example.ParlourApp.Offers.OfferRegModel;
import com.example.ParlourApp.Offers.OfferRepository;
import com.example.ParlourApp.Rating.RatingRepository;
import com.example.ParlourApp.Revenue.RevenueRepository;
import com.example.ParlourApp.Revenue.RevenueRepository;
import com.example.ParlourApp.booking.BookingRepository;
import com.example.ParlourApp.cart.CartRepository;
import com.example.ParlourApp.dto.DashboardData;
import com.example.ParlourApp.dto.OfferDashboardData;
import com.example.ParlourApp.employee.EmployeeRepository;
import com.example.ParlourApp.parlour.ParlourRepository;
import com.example.ParlourApp.parlour.ParlourService;
import com.example.ParlourApp.userbilling.UserBillingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@Service
@Slf4j
public class DashBoardService {


    @Autowired
     CartRepository cartRepository;

    @Autowired
     RatingRepository ratingRepository;

    @Autowired
     ParlourService parlourService;

    @Autowired
    ParlourRepository parlourRepository;

    @Autowired
     BookingRepository bookingRepository;

  @Autowired
  RevenueRepository revenueRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserBillingRepository userBillingRepository;

    @Autowired
    private OfferRepository offerRepository;


    private OfferDashboardData getofferDataByYear(int year) {
        List<OfferRegModel> offers = OfferRepository.findOffersByYear(year);
        BigDecimal totalAmount = OfferRepository.calculateTotalAmountByYear(year);
        String mostPopularItem = OfferRepository.findMostPopularItemByYear(year);

        OfferDashboardData dashboardData = new OfferDashboardData();
        dashboardData.setOffers(offers);
        dashboardData.setTotalAmount(totalAmount);
        dashboardData.setMostPopularItem(mostPopularItem);

        return dashboardData;
    }

    public List<Long> getAllBookingIds() {
        return cartRepository.findAllBookingIds();
    }

    public List<LocalTime> getAllBookingTimes() {
        return cartRepository.findAllBookingTimes();
    }

    public List<BigDecimal> getAllBookingPrices() {
        return cartRepository.findAllBookingPrices();
    }

    public List<String> getAllBookingStatuses() {
        return userBillingRepository.findAllBookingStatuses();
    }

    public DashboardData getDashboardData() {
        DashboardData dashboardData = new DashboardData();
        dashboardData.setTotalBookings(bookingRepository.count());
       dashboardData.setTotalRevenue(revenueRepository.sumAll());
        dashboardData.setActiveParlours(parlourRepository.countActive());
        dashboardData.setActiveEmployees(employeeRepository.countActive());
        dashboardData.setRecentTransactions(userBillingRepository.findRecent());
        System.out.println("Dashboard Data: " + dashboardData);

        return dashboardData;
    }

    public static OfferDashboardData getOfferDataByYear(int year) {
        List<OfferRegModel> offers = OfferRepository.findOffersByYear(year);
        BigDecimal totalAmount = OfferRepository.calculateTotalAmountByYear(year);
        String mostPopularItem = OfferRepository.findMostPopularItemByYear(year);

        OfferDashboardData dashboardData = new OfferDashboardData();
        dashboardData.setOffers(offers);
        dashboardData.setTotalAmount(totalAmount);
        dashboardData.setMostPopularItem(mostPopularItem);

        return dashboardData;
    }


}
