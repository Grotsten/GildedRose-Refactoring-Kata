package com.gildedrose

class GildedRose(var items: Array<Item>) {
    //decrements sellIn date
    private fun updateSellIn(item: Item) {
        item.sellIn -= 1
    }

    private fun agedBrieProcessor(item: Item) {
        when {
            item.sellIn > 0 -> item.quality += 1
            item.sellIn <= 0 -> item.quality += 2
        }
        if (item.quality > 50) {
            item.quality = 50
        }
        updateSellIn(item)
    }

    private fun normalItemProcessor(item: Item) {
        when {
            item.sellIn >= 1 -> item.quality -= 1
            item.sellIn < 1 -> item.quality -= 2
        }
        if (item.quality < 0) {
            item.quality = 0
        } else if (item.quality > 50) {
            item.quality = 50
        }
        updateSellIn(item)
    }

    private fun sulfurasProcessor(item: Item) {
        item.quality = 80
    }

    private fun concertProcessor(item: Item) {
        when {
            item.sellIn in 1..5 -> item.quality += 3
            item.sellIn in 6..10 -> item.quality += 2
            item.sellIn > 10 -> item.quality += 1
            item.sellIn < 1 -> item.quality = 0
        }
        if (item.quality > 50) {
            item.quality = 50
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

        if (item.quality < 0) {
            item.quality = 0
        } else if (item.quality > 50) {
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

