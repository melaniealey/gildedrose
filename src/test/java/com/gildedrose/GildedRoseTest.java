package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
    @Test
    public void foo() {
        StockItem[] items = new StockItem[] { new StockItem("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void shouldNormalProducesNormalDegradationWhenInSellInPeriod() {
        StockItem[] items = new StockItem[] { new StockItem("A Item", 1 ,10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    @Test
    public void shouldNormalProducesDegradeTheQualityTwiceAsFastOnceTheSellInDateHasReachedZero() {
        StockItem[] items = new StockItem[] { new StockItem("A Item", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    //BRIE TESTS
    @Test
    public void brieIncreasesInValueAsAges(){
        StockItem[] items = new StockItem[] { new AgedBrie( 1000000, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    public void brieIncreasesTwiceAsFasterAfterSellIn(){
        StockItem[] items = new StockItem[] { new AgedBrie(0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    //BACKSTAGE
    @Test
    public void backstageIncreasesAsConcertApproachsUnderTen(){
        StockItem[] items = new StockItem[] { new BackstagePass( 8, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void backstageIncreasesAsConcertApproachsUnderFive(){
        StockItem[] items = new StockItem[] { new BackstagePass(4, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }

    @Test
    public void backstageUselessAfterConcert(){
        StockItem[] items = new StockItem[] { new BackstagePass(0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }


    @Test
    public void conjuredShouldDegradeTwiceAsFastAsANormalItem(){
        StockItem[] items = new StockItem[] { new Conjured(5,10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }
    @Test

    public void conjuredShouldDegradeFourTimesAsFastAsANormalItemAtSellinExpired(){
        StockItem[] items = new StockItem[] { new Conjured(0,10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }
}
