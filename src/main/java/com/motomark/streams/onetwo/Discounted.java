package com.motomark.streams.onetwo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Discounted {

    public BigDecimal discount(final List<BigDecimal> prices) {
        return prices.stream().filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
            .map(price -> price.multiply(BigDecimal.valueOf(0.9))).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static void main(String[] args) {
        List<BigDecimal> prices = Arrays.asList(new BigDecimal("10"), 
            new BigDecimal("20"), 
            new BigDecimal("45"), 
            new BigDecimal("30"), 
            new BigDecimal("15"), 
            new BigDecimal("12"), 
            new BigDecimal("17"), 
            new BigDecimal("18"));
        Discounted discounted = new Discounted();
        System.out.println(discounted.discount(prices));
    
    }
}


