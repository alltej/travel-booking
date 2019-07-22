package com.alltej.pricing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

/**
 * @author atejano
 */
public class GroupPricing {

    public static List<BestGroupPrice> getBestGroupPrices(List<Rate> rates, List<CabinPrice> cabinPrices) {

        Map<String, String> mapRate = rates.stream().collect(toMap(Rate::getRateCode, Rate::getRateGroup));
        Map<String, Map<String, CabinPrice>> bestCabinPrice = cabinPrices.stream().collect(
                groupingBy(CabinPrice::getCabinCode,
                        groupingBy(s -> mapRate.get(s.getRateCode()),
                                collectingAndThen(
                                        reducing((e1, e2) -> e1.getPrice().compareTo(e2.getPrice()) <0 ? e1 : e2), Optional::get))));
        List<BestGroupPrice> bestGroupPrices = new ArrayList<>();
        bestCabinPrice.entrySet().stream().forEach(s -> {
            s.getValue().entrySet().stream().forEach(v -> {
                bestGroupPrices.add(new BestGroupPrice(v.getValue().getRateCode(), v.getValue().getCabinCode(), v.getValue().getPrice(), v.getKey()));
            });
        });
        return bestGroupPrices;
    }
}
