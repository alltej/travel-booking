package com.alltej.promotions;

import java.util.List;

/**
 * @author atejano
 */
public class Promotion {
    private final String code;
    private final List<String> notCombinableWith;

    public Promotion(String code, List<String> notCombinableWith) {
        this.code = code;
        this.notCombinableWith = notCombinableWith;
    }

    public String getCode() {
        return code;
    }

    public List<String> getNotCombinableWith() {
        return notCombinableWith;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        return code.equals(promotion.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
