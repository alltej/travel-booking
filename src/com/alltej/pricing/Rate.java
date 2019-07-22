package com.alltej.pricing;

/**
 * @author atejano
 */
public class Rate {
    private String rateCode;
    private String rateGroup;

    public Rate(String rateCode, String rateGroup) {
        this.rateCode = rateCode;
        this.rateGroup = rateGroup;
    }

    public String getRateCode() {
        return rateCode;
    }

    public String getRateGroup() {
        return rateGroup;
    }

}


