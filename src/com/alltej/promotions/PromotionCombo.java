package com.alltej.promotions;

import java.util.List;

/**
 * @author atejano
 */
public class PromotionCombo {
    private List<String> promotionCodes;

    public PromotionCombo(List<String> promotionCodes) {
        this.promotionCodes = promotionCodes;
    }

    public List<String> getPromotionCodes() {
        return promotionCodes;
    }

    @Override
    public String toString() {
        return "promotionCode=" + promotionCodes ;
    }
}
