package com.gildedrose

class BackstagePassItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun processItem() {
        when {
            this.sellIn in 1..5 -> this.quality += 3
            this.sellIn in 6..10 -> this.quality += 2
            this.sellIn > 10 -> this.quality += 1
            this.sellIn <= 0 -> this.quality = 0
        }
        checkQuality()
        updateSellIn()
    }
}