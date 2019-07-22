package com.alltej.pricing;

import java.math.BigDecimal;

/**
 * @author atejano
 */
public class BestGroupPrice {
    private String rateCode;
    private String cabinCode;
    private BigDecimal price;
    private String rateGroup;
    public BestGroupPrice(String rateCode, String cabinCode, BigDecimal price, String rateGroup) {
        this.rateCode = rateCode;
        this.cabinCode = cabinCode;
        this.price = price;
        this.rateGroup = rateGroup;
    }

    @Override
    public String toString() {
        return "BestGroupPrice{" +
                "rateCode='" + rateCode + '\'' +
                ", cabinCode='" + cabinCode + '\'' +
                ", price=" + price +
                ", rateGroup='" + rateGroup + '\'' +
                '}';
    }

    public String getRateCode() {
        return rateCode;
    }

    public String getCabinCode() {
        return cabinCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getRateGroup() {
        return rateGroup;
    }
}
