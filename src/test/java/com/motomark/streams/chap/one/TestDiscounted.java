package com.motomark.streams.chap.one;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDiscounted {

    private List<BigDecimal> prices;
    private Discounted discounted;

    @Before
    public void before() {
         prices = Arrays.asList(new BigDecimal("10"), 
            new BigDecimal("20"), 
            new BigDecimal("45"), 
            new BigDecimal("30"), 
            new BigDecimal("15"), 
            new BigDecimal("12"), 
            new BigDecimal("17"), 
            new BigDecimal("18"));
        discounted = new Discounted();
    }

    @Test
    public void testDiscount() {
        Assert.assertEquals(BigDecimal.valueOf(67.5), discounted.discount(prices));
    }

}
