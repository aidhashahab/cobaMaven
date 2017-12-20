/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valensi.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class LatestConversion {

    private String disclaimer;
    private String license;
    private long timestamp;
    private String base;
    private Map<String, Double> rates = new HashMap<>();

    public LatestConversion() {
    }

    public Date getLatestDate() {
        return new Date(getTimestamp() * 1000);
    }

    public Double getConversion(double fromValue, String fromCurrency, String toCurrency) {
        double value = 0.0;
        if (fromCurrency.equalsIgnoreCase("USD")) {
            value = fromValue * rates.get(toCurrency);
        } else {
            double usd = fromValue / rates.get(fromCurrency);
            value = usd * rates.get(toCurrency);
        }
        return value;
    }

    /**
     * @return the disclaimer
     */
    public String getDisclaimer() {
        return disclaimer;
    }

    /**
     * @param disclaimer the disclaimer to set
     */
    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    /**
     * @return the license
     */
    public String getLicense() {
        return license;
    }

    /**
     * @param license the license to set
     */
    public void setLicense(String license) {
        this.license = license;
    }

    /**
     * @return the base
     */
    public String getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * @return the rates
     */
    public Map<String, Double> getRates() {
        return rates;
    }

    /**
     * @param rates the rates to set
     */
    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "1 USD = Rp " + rates.get("IDR") + " per " + getLatestDate();
    }

}
