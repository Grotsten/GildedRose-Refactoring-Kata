package com.gildedrose

class AgedBrieItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun processItem() {
        when {
            this.sellIn > 0 -> this.quality += 1
            this.sellIn <= 0 -> this.quality += 2
        }
        checkQuality()
        updateSellIn()
    }
}
