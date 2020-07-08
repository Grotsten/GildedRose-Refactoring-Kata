package com.gildedrose

class ConjuredItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun processItem() {
        this.quality -= 2
        if (this.sellIn <= 0) this.quality -= 2
        checkQuality()
        updateSellIn()
    }
}