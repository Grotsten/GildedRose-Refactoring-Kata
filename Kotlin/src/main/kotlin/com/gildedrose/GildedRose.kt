package com.gildedrose

class GildedRose(var items: Array<Item>) {
    private fun updateSellIn(item: Item) {
        item.sellIn -= 1
    }
    private fun agedBrieProcessor(item: Item){
        if (item.quality < 50) {
            if (item.sellIn > 0) {
                item.quality += 1
            } else{
                item.quality += 2
            }
        }
        updateSellIn(item)
    }
    private fun normalItemProcessor(item: Item){
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
        updateSellIn(item)
    }
    private fun sulfurasProcessor(item: Item){
        item.quality = 80
    }
    private fun concertProcessor(item: Item){
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
        updateSellIn(item)
    }

    private fun checkConjured(item: Item): Boolean {
        return item.name.startsWith("Conjured")
    }

    private fun conjuredProcessor(item: Item) {
        item.quality -= 2
        if (item.sellIn < 1) {
            item.quality -= 2
        }

        if (item.quality < 0){
            item.quality = 0
        } else if (item.quality > 50){
            item.quality = 50
        }
        updateSellIn(item)
     }
    private fun processItem(item: Item) {
        when {
            item.name == "Backstage passes to a TAFKAL80ETC concert" -> {
                concertProcessor(item)
            }
            item.name == "Sulfuras, Hand of Ragnaros" -> {
                sulfurasProcessor(item)
            }
            item.name == "Aged Brie" -> {
                agedBrieProcessor(item)
            }
            checkConjured(item) -> {
                conjuredProcessor(item)
            }
            else -> {
                normalItemProcessor(item)
            }
        }
    }

    fun updateQuality() {
        items.map { item -> processItem(item) }
    }

}

