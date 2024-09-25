package com.example.ParlourApp.dto;

import com.example.ParlourApp.Offers.OfferRegModel;

import java.math.BigDecimal;
import java.util.List;

public class OfferDashboardData
{
    private List<OfferRegModel> offers;
    private BigDecimal totalAmount;
    private String mostPopularItem;

    public List<OfferRegModel> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferRegModel> offers) {
        this.offers = offers;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getMostPopularItem() {
        return mostPopularItem;
    }

    public void setMostPopularItem(String mostPopularItem) {
        this.mostPopularItem = mostPopularItem;
    }

    public OfferDashboardData getBody() {
        return  this;
    }
}
