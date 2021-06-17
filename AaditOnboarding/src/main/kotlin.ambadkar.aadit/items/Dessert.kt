package items

import Item
import ItemType
import kotlin.math.pow

class Dessert(name: String, val sweetnessLevel: Int = 1) : Item(name, ItemType.FOOD) {
    private var appeal: Int
        get() {
            return field++ // More people are interested in it, so its appeal is higher
        }

    init {
        appeal = name.length * sweetnessLevel
        appeal = appeal.toDouble().pow(2.0).toInt() // Square the appeal because
    }

    override fun toString(): String {
        return "Dessert $name with a sweetness of $sweetnessLevel"
    }

    override fun moreDetails(): String {
        return "Dessert $name with a sweetness of $sweetnessLevel. Current predicted appeal: $appeal"
    }
}