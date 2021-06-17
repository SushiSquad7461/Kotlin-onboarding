package time

inline class Years(val i: Int) {
    override fun toString(): String {
        return i.toString()
    }

    operator fun compareTo(other: Years): Int {
        return i - other.i
    }
}
