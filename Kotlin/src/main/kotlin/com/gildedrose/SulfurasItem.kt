package com.gildedrose

class SulfurasItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun processItem() {
        this.quality = 80
    }
}