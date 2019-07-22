package com.alltej.promotions;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author atejano
 */
public class PromotionCombo {
    private List<String> promotionCodes;

    public PromotionCombo(List<String> promotionCodes) {
        this.promotionCodes = promotionCodes;
//        Collections.sort(this.promotionCodes);
    }

    public List<String> getPromotionCodes() {
        return promotionCodes;
    }

    @Override
    public String toString() {
        return "promotionCode=" + promotionCodes ;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        PromotionCombo that = (PromotionCombo) o;
//
//        return promotionCodes.equals(that.promotionCodes);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(promotionCodes.hashCode());
////        return ;
//    }
}
