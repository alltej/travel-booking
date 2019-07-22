package com.alltej.promotions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * @author atejano
 */
public class PromotionApp {

    public static void main(String[] args) {
//        Input - Promotions:
        Promotion p1 = new Promotion("P1", asList("P3"));// P1 is not combinable with P3
        Promotion p2 = new Promotion("P2", asList("P4", "P5"));// P1 is not combinable with P3
        Promotion p3 = new Promotion("P3", asList("P1"));// P1 is not combinable with P3
        Promotion p4 = new Promotion("P4", asList("P2"));// P1 is not combinable with P3
        Promotion p5 = new Promotion("P5", asList("P2"));// P1 is not combinable with P3

//        Expected Output for All Promotion Combinations:
//        Seq(
//                PromotionCombo(Seq(P1, P2)),
//                PromotionCombo(Seq(P1, P4, P5)),
//                PromotionCombo(Seq(P2, P3)),
//                PromotionCombo(Seq(P3, P4, P5))
//        )

        System.out.println("******All Combinable Promotions*******");

        List<Promotion> allPromotions = asList(p1, p2, p3, p4, p5);
        List<PromotionCombo> allCombinablePromotions = PromotionCombined.allCombinablePromotions(allPromotions);
        allCombinablePromotions.forEach(l -> {
            System.out.println(l);

        });

        System.out.println("******Combinable Promotions for " + p1.getCode() + " *******");
        List<PromotionCombo> promotionCombosForCode = PromotionCombined.getCombinablePromotions(p1.getCode(), allPromotions);
        promotionCombosForCode.forEach(p -> {
            System.out.println(p);
        });

        System.out.println("*******Combinable Promotions for " + p3.getCode() + "******");
        List<PromotionCombo> promotionCombosForCode2 = PromotionCombined.getCombinablePromotions(p3.getCode(), allPromotions);
        promotionCombosForCode2.forEach(p -> {
            System.out.println(p);
        });
    }


}
