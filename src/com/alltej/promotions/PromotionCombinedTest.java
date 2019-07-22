package com.alltej.promotions;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author atejano
 */
class PromotionCombinedTest {

    Promotion p1 = new Promotion("P1", asList("P3"));// P1 is not combinable with P3
    Promotion p2 = new Promotion("P2", asList("P4", "P5"));// P1 is not combinable with P3
    Promotion p3 = new Promotion("P3", asList("P1"));// P1 is not combinable with P3
    Promotion p4 = new Promotion("P4", asList("P2"));// P1 is not combinable with P3
    Promotion p5 = new Promotion("P5", asList("P2"));// P1 is not combinable with P3

    List<Promotion> allPromotions = Collections.unmodifiableList(asList(p1, p2, p3, p4, p5));

    @Test
    void allCombinablePromotions() {
        List<PromotionCombo> allCombinablePromotions = PromotionCombined.allCombinablePromotions(allPromotions);
        assertTrue(allCombinablePromotions.size()==4);
        assertTrue(allCombinablePromotions.stream().filter(p -> p.getPromotionCodes().equals(asList("P1", "P2"))).findFirst().isPresent());
        assertTrue(allCombinablePromotions.stream().filter(p -> p.getPromotionCodes().equals(asList("P2", "P3"))).findFirst().isPresent());
        assertTrue(allCombinablePromotions.stream().filter(p -> p.getPromotionCodes().equals(asList("P1", "P4", "P5"))).findFirst().isPresent());
        assertTrue(allCombinablePromotions.stream().filter(p -> p.getPromotionCodes().equals(asList("P3", "P4", "P5"))).findFirst().isPresent());
        assertFalse(allCombinablePromotions.stream().filter(p -> p.getPromotionCodes().equals(asList("P1", "P3"))).findFirst().isPresent());
        assertFalse(allCombinablePromotions.stream().filter(p -> p.getPromotionCodes().equals(asList("P2", "P4"))).findFirst().isPresent());

    }

    @Test
    void getCombinablePromotionsForAPromoCode() {
        System.out.println("******Combinable Promotions for " + p1.getCode() + " *******");
        List<PromotionCombo> p1Combos = PromotionCombined.getCombinablePromotions(p1.getCode(), allPromotions);
        assertTrue(p1Combos.stream().filter(p -> p.getPromotionCodes().equals(asList("P1", "P2"))).findFirst().isPresent());
        assertTrue(p1Combos.stream().filter(p -> p.getPromotionCodes().equals(asList("P1", "P4", "P5"))).findFirst().isPresent());
        assertFalse(p1Combos.stream().filter(p -> p.getPromotionCodes().equals(asList("P2", "P3"))).findFirst().isPresent());

        System.out.println("******Combinable Promotions for " + p3.getCode() + " *******");
        List<PromotionCombo> p3Combos = PromotionCombined.getCombinablePromotions(p3.getCode(), allPromotions);
        assertTrue(p3Combos.stream().filter(p -> p.getPromotionCodes().equals(asList("P2", "P3"))).findFirst().isPresent());
        assertTrue(p3Combos.stream().filter(p -> p.getPromotionCodes().equals(asList("P3", "P4", "P5"))).findFirst().isPresent());
        assertFalse(p3Combos.stream().filter(p -> p.getPromotionCodes().equals(asList("P1", "P2"))).findFirst().isPresent());
    }
}