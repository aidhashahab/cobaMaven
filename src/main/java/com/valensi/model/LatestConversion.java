package com.valensi.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "1 USD = Rp " + rates.get("IDR") + " per " + getLatestDate();
    }

}
