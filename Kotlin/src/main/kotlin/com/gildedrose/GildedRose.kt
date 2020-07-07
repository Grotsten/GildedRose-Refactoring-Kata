package com.gildedrose

class GildedRose(var items: Array<Item>) {
    fun agedBrieProcessor(item: Item){
        if (item.quality < 50) {
            if (item.sellIn > 0) {
                item.quality += 1
            } else{
                item.quality += 2
            }
        }
        item.sellIn -= 1
    }
    fun normalItemProcessor(item: Item){
        if (item.sellIn<1) {
            item.quality -= 2
        } else {
            item.quality -= 1
        }
        if (item.quality < 0){
            item.quality = 0
        } else if (item.quality > 50) {
            item.quality = 50
        }
        item.sellIn -= 1
    }
    fun sulfurasProcessor(item: Item){
        item.quality = 80
    }
    fun concertProcessor(item: Item){
        if (item.quality < 50) {
            item.quality = item.quality + 1

            if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                if (item.sellIn < 11) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                }

                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                }
            }
        }

        if (item.sellIn < 1) {
            item.quality = 0
        }
        item.sellIn -= 1
    }

    fun checkConjured(item: Item): Boolean {
        return item.name.startsWith("Conjured")
    }

    fun conjuredProcessor(item: Item) {
        item.quality -= 2
        if (item.sellIn < 1) {
            item.quality -= 2
        }
        item.sellIn -= 1
        if (item.quality < 0){
            item.quality = 0
        } else if (item.quality > 50){
            item.quality = 50
        }
     }
    fun processItem(item: Item) {
        if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            concertProcessor(item)
        } else if (item.name == "Sulfuras, Hand of Ragnaros"){
            sulfurasProcessor(item)
        } else if (item.name == "Aged Brie") {
            agedBrieProcessor(item)
        } else if (checkConjured(item)){
            conjuredProcessor(item)
        } else {
            normalItemProcessor(item)
        }
    }

    fun updateQuality() {
        for (item in items) {
            processItem(item)
        }
    }

}

