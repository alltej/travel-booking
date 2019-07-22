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
public class PromotionCombined {
    static List<PromotionCombo> allCombinablePromotions(List<Promotion> allPromotions) {
        HashSet<TreeSet> hash = new HashSet<>();

        for (Promotion p : allPromotions) {
            List<String> promoList = asList(p.getCode());
            List<Promotion> combinableWith = allPromotions.stream()
                    .filter(a -> (!a.getCode().equals(p.getCode()) && !p.getNotCombinableWith().contains(a.getCode()))).collect(Collectors.toList());
            getCombinablePromotions(hash, promoList, combinableWith);

        }
        return hash.stream().map(h -> new PromotionCombo(new ArrayList<String>(h))).collect(Collectors.toList());
    }

    static List<PromotionCombo> getCombinablePromotions(String promotionCode, List<Promotion> allPromotions) {
        HashSet<TreeSet> hash = new HashSet<>();

        Promotion promotion = allPromotions.stream().filter(p -> p.getCode().equalsIgnoreCase(promotionCode)).findFirst().get();
        List<String> promoList = asList(promotion.getCode());
        List<Promotion> combinableWith = allPromotions.stream()
                .filter(a -> (!a.getCode().equals(promotionCode) && !promotion.getNotCombinableWith().contains(a.getCode()))).collect(Collectors.toList());
        getCombinablePromotions(hash, promoList, combinableWith);
        return hash.stream().map(h -> new PromotionCombo(new ArrayList<String>(h))).collect(Collectors.toList());
    }

    private static void getCombinablePromotions(HashSet<TreeSet> hash, List<String> promoList, List<Promotion> allPromotions) {
        if (allPromotions.size() ==0) return;

        for (int i = 0; i < allPromotions.size()-1; i++) {
            Promotion p = allPromotions.get(i);
            List<Promotion> combinableWith = allPromotions.stream()
                    .filter(a -> (!p.getNotCombinableWith().contains(a.getCode()))).collect(Collectors.toList());
            if (combinableWith.size() <= 2){
                List<String> newPromoList = new ArrayList<>(promoList);
                newPromoList.add(combinableWith.get(0).getCode());
                if (combinableWith.size() == 2) newPromoList.add(combinableWith.get(1).getCode());
                hash.add(new TreeSet<>(newPromoList));
            }
            else{
                getCombinablePromotions(hash, promoList, combinableWith);
            }
        }

    }
}
