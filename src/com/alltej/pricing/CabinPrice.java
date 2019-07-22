package com.alltej.pricing;

import java.math.BigDecimal;

public class CabinPrice {
    private String rateCode;
    private String cabinCode;
    private BigDecimal price;

    public CabinPrice(String cabinCode, String rateCode, BigDecimal price) {
        this.rateCode = rateCode;
        this.cabinCode = cabinCode;
        this.price = price;
    }

    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public String getCabinCode() {
        return cabinCode;
    }

    public void setCabinCode(String cabinCode) {
        this.cabinCode = cabinCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
