package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.map(Item::processItem)
    }

}

