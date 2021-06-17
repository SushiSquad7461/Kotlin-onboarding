package items

import Item
import time.*

class Shirt(val shirtName: String, val size: Int, val lifespan: Years) : Item(shirtName, ItemType.CLOTHING) {
    override fun toString(): String {
        return "Shirt $shirtName"
    }

    override fun moreDetails(): String {
        return "Shirt $shirtName has size $size, with a lifespan of $lifespan"
    }
}