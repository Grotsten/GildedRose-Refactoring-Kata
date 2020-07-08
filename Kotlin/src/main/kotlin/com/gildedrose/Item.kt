package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }

    fun updateSellIn() {
        this.sellIn -= 1
    }

    open fun processItem() {
        when {
            this.sellIn > 0 -> this.quality -= 1
            this.sellIn <= 0 -> this.quality -= 2
        }
        checkQuality()
        updateSellIn()
    }
    open fun checkQuality() {
        when {
            this.quality < 0 -> this.quality = 0
            this.quality > 50 -> this.quality = 50
        }
    }
}






