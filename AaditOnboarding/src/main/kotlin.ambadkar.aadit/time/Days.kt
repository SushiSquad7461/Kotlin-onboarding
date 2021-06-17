package time

inline class Days(val i: Int) {
    override fun toString(): String {
        return i.toString()
    }

    operator fun compareTo(other: Days): Int {
        return i - other.i
    }
}