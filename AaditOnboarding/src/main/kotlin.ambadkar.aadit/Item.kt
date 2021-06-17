abstract class Item(val name: String, val type: ItemType) {
    fun typeAsString(): String {
        return type.name
    }

    abstract fun moreDetails(): String
}
