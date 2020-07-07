package com.gildedrose

import org.junit.Assert.*
import org.junit.Test

class GildedRoseTest {

    @Test fun foo() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }

    //test the sulfuras quality doesn't change
    @Test fun sulfurasQuality() {
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros",5,80),
                Item("Sulfuras, Hand of Ragnaros",1,80),
                Item("Sulfuras, Hand of Ragnaros",-1,80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(80, app.items[0].quality)
        assertEquals(80,app.items[1].quality)
        assertEquals(80,app.items[2].quality)
    }

    //Test the sulfuras sellin doesn't decrease
    @Test fun sulfurasSellIn() {
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros",5,80),
                Item("Sulfuras, Hand of Ragnaros",-1,80))
        val app = GildedRose(items)
        assertEquals(5, app.items[0].sellIn)
        assertEquals(-1, app.items[1].sellIn)
    }

    //Test the concert ticket behaviour 10+ days
    @Test fun concert10plusDays() {
        val items = arrayOf<Item>( Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                Item("Backstage passes to a TAFKAL80ETC concert", 10, 30))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(21, app.items[0].quality)
        assertEquals(32, app.items[1].quality)
    }

    //Test the concert ticket behaviour 5-10 days
    @Test fun concert5plusDays() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 5, 45),
                Item("Backstage passes to a TAFKAL80ETC concert", 7,49))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(48, app.items[0].quality)
        assertEquals(50, app.items[1].quality)
    }

    //Test the concert ticket behaviour 1-5 days
    @Test fun concert1Day() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 1,34),
                Item("Backstage passes to a TAFKAL80ETC concert",3,50),
                Item("Backstage passes to a TAFKAL80ETC concert", 2,45))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(37, app.items[0].quality)
        assertEquals(50, app.items[1].quality)
        assertEquals(48, app.items[2].quality)
    }

    //Test the concert tickets after the concert happens
    @Test fun concert0Day(){
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 0,48),
                Item("Backstage passes to a TAFKAL80ETC concert",-4,4))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
        assertEquals(0, app.items[1].quality)
    }

    //Test Brie behaviour when in date
    @Test fun brieInDate() {
        val items = arrayOf<Item>(Item("Aged Brie",2,2),
                Item("Aged Brie", 3,50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(3, app.items[0].quality)
        assertEquals(50,app.items[1].quality)
    }

    //Tests the behaviour when Brie is out of date
    @Test fun brieOutOfDate() {
        val items = arrayOf<Item>(Item("Aged Brie", 0, 5),
                Item("Aged Brie", -4,3),
                Item("Aged Brie", -4, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(7, app.items[0].quality)
        assertEquals(5, app.items[1].quality)
        assertEquals(50, app.items[2].quality)
    }
    //Tests the behaviour with normal items in date
    @Test fun normalInDate() {
        val items = arrayOf<Item>(Item("Front stage pass", 5,4),
                Item("Apple", 7,50),
                Item("Glass", 4,0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(3, app.items[0].quality)
        assertEquals(49, app.items[1].quality)
        assertEquals(0, app.items[2].quality)
    }

    //Tests the behaviour with normal items out of date
    @Test fun normalOutOfDate() {
        val items = arrayOf<Item>(Item("Pen",0,3),
                Item("Shoe", -2, 50),
                Item("Bowl", -5,0),
                Item("Shirt", -3,1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, app.items[0].quality)
        assertEquals(48, app.items[1].quality)
        assertEquals(0, app.items[2].quality)
        assertEquals(0, app.items[3].quality)
    }

    //Tests the conjured item in date
    @Test fun conjuredInDate(){
        val items = arrayOf<Item>(Item("Conjured Pen", 5, 5),
                Item("Conjured Shoe", 5,1),
                Item("Conjured Bowl", 3, 0),
                Item("Conjured Shirt", 4, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(3, app.items[0].quality)
        assertEquals(0, app.items[1].quality)
        assertEquals(0, app.items[2].quality)
        assertEquals(48, app.items[3].quality)
    }

    //Test an out of date conjured item
    @Test fun conjuredOutOfDate() {
        val items = arrayOf<Item>(Item("Conjured Pen", 0, 5),
                Item("Conjured Shoe", -1, 3),
                Item("Conjured Bowl", -3, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, app.items[0].quality)
        assertEquals(0, app.items[1].quality)
        assertEquals(0, app.items[2].quality)

    }
}


