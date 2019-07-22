package com.alltej.pricing;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author atejano
 */
public class PricingApp {
    public static void main(String[] args) {
        Rate rateM1 = new Rate("M1", "Military");
        Rate rateM2 = new Rate("M2", "Military");
        Rate rateS1 = new Rate("S1", "Senior");
        Rate rateS2 = new Rate("S2", "Senior");


        CabinPrice cpcaM1 = new CabinPrice("CA", "M1", new BigDecimal(200.00));
        CabinPrice cpcaM2 = new CabinPrice("CA", "M2", new BigDecimal(250.00));
        CabinPrice cpcas1 = new CabinPrice("CA", "S1", new BigDecimal(225.00));
        CabinPrice cpcas2 = new CabinPrice("CA", "S2", new BigDecimal(260.00));
        CabinPrice cpcbM1 = new CabinPrice("CB", "M1", new BigDecimal(230.00));

        CabinPrice cpcbM2 = new CabinPrice("CB", "M2", new BigDecimal(260.00));
        CabinPrice cpcbS1 = new CabinPrice("CB", "S1", new BigDecimal(245.00));
        CabinPrice cpcbS2 = new CabinPrice("CB", "S2", new BigDecimal(270.00));

        List<CabinPrice> cabinPrices = asList(cpcaM1, cpcaM2, cpcas1, cpcas2, cpcbM1, cpcbM2, cpcbS1, cpcbS2);
        List<Rate> rates = asList(rateM1, rateM2, rateS1, rateS2);
        List<BestGroupPrice> bestGroupPrices = GroupPricing.getBestGroupPrices(rates, cabinPrices);

        bestGroupPrices.forEach(b -> System.out.println(b.toString()));
    }
}
