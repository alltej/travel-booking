package com.alltej.pricing;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author atejano
 */
class GroupPricingTest {

    Rate rateM1 = new Rate("M1", "Military");
    Rate rateM2 = new Rate("M2", "Military");
    Rate srS1 = new Rate("S1", "Senior");
    Rate srS2 = new Rate("S2", "Senior");


    CabinPrice cpcaM1 = new CabinPrice("CA", "M1", new BigDecimal(200.00));
    CabinPrice cpcaM2 = new CabinPrice("CA", "M2", new BigDecimal(250.00));
    CabinPrice cpcas1 = new CabinPrice("CA", "S1", new BigDecimal(225.00));
    CabinPrice cpcas2 = new CabinPrice("CA", "S2", new BigDecimal(260.00));
    CabinPrice cpcbM1 = new CabinPrice("CB", "M1", new BigDecimal(230.00));

    CabinPrice cpcbM2 = new CabinPrice("CB", "M2", new BigDecimal(260.00));
    CabinPrice cpcbS1 = new CabinPrice("CB", "S1", new BigDecimal(245.00));
    CabinPrice cpcbS2 = new CabinPrice("CB", "S2", new BigDecimal(270.00));



    List<CabinPrice> cabinPrices  = Collections.unmodifiableList(asList(cpcaM1, cpcaM2, cpcas1, cpcas2, cpcbM1, cpcbM2, cpcbS1, cpcbS2));
    List<Rate> rates = Collections.unmodifiableList(asList(rateM1, rateM2, srS1, srS2));

    @Test
    void getBestGroupPrices() {
//        Expected Output - Best Cabin Prices:
//        BestGroupPrice(CA, M1, 200.00, Military)
//        BestGroupPrice(CA, S1, 225.00, Senior)
//        BestGroupPrice(CB, M1, 230.00, Military)
//        BestGroupPrice(CB, S1, 245.00, Senior

        List<BestGroupPrice> bestGroupPrices = GroupPricing.getBestGroupPrices(rates, cabinPrices);

        BestGroupPrice caMilitary = bestGroupPrices.stream().filter(g -> g.getCabinCode().equalsIgnoreCase("CA") && g.getRateGroup().equalsIgnoreCase("Military"))
                .findFirst().get();
        assertEquals(new BigDecimal(200.00), caMilitary.getPrice());

        BestGroupPrice caSenior = bestGroupPrices.stream().filter(g -> g.getCabinCode().equalsIgnoreCase("CA") && g.getRateGroup().equalsIgnoreCase("Senior"))
                .findFirst().get();
        assertEquals(new BigDecimal(225.00), caSenior.getPrice());

        BestGroupPrice cbMilitary = bestGroupPrices.stream().filter(g -> g.getCabinCode().equalsIgnoreCase("CB") && g.getRateGroup().equalsIgnoreCase("Military"))
                .findFirst().get();
        assertEquals(new BigDecimal(230.00), cbMilitary.getPrice());

        BestGroupPrice cbSenior = bestGroupPrices.stream().filter(g -> g.getCabinCode().equalsIgnoreCase("CB") && g.getRateGroup().equalsIgnoreCase("Senior"))
                .findFirst().get();
        assertEquals(new BigDecimal(245.00), cbSenior.getPrice());
    }


}