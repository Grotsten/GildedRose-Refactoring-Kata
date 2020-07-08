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
        if (this.quality < 0) {
            this.quality = 0
        } else if (this.quality > 50) {
            this.quality = 50
        }
        updateSellIn()
    }
}

class AgedBrieItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun processItem() {
        when {
            this.sellIn > 0 -> this.quality += 1
            this.sellIn <= 0 -> this.quality += 2
        }
        if (this.quality > 50) {
            this.quality = 50
        }
        updateSellIn()
    }
}

class SulfurasItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun processItem() {
        this.quality = 80
    }
}

class BackstagePassItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun processItem() {
        when {
            this.sellIn in 1..5 -> this.quality += 3
            this.sellIn in 6..10 -> this.quality += 2
            this.sellIn > 10 -> this.quality += 1
            this.sellIn <= 0 -> this.quality = 0
        }
        if (this.quality > 50) {
            this.quality = 50
        }
        updateSellIn()
    }
}

class ConjuredItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun processItem() {
        this.quality -= 2
        if (this.sellIn <= 0) {
            this.quality -= 2
        }

        if (this.quality < 0) {
            this.quality = 0
        } else if (this.quality > 50) {
            this.quality = 50
        }
        updateSellIn()
    }
}