import items.Dessert
import items.Drill
import items.Shirt
import time.Days
import time.Years

fun main() {
    val shoppingCart = mutableListOf<Item>();
    println("Action please (Done, Dessert, Drill, Shirt, Print, Filter)")
    var c = readLine()!!.toLowerCase().capitalize()
    while (c != "Done") {
        when (c) {
            "Dessert" -> {
                println("Name and sweetness level (String Int)")
                val (name, sweet) = readLine()!!.split(" ")
                shoppingCart.add(Dessert(name, sweet.toInt()))
            }
            "Drill" -> {
                println("Model name and brand please (String String)")
                val (mname, brand) = readLine()!!.split(" ")
                println("More info? (Y/N)")
                if (readLine() == "Y") {
                    println("Battery Life and Warranty Period (Int Int)")
                    val (blife, wp) = readLine()!!.split(" ").map {
                        it.toInt()
                    }
                    shoppingCart.add(Drill(mname, brand, Days(blife), Years(wp)))
                } else {
                    shoppingCart.add(Drill(mname, brand))
                }
            }
            "Shirt" -> {
                println("Name, Size, and Lifespan please (String Int Int)")
                val (sname, size, lspan) = readLine()!!.split(" ")
                shoppingCart.add(Shirt(sname, size.toInt(), Years(lspan.toInt())))
            }
            "Print" -> {
                println("---------------------------------------------------------")
                shoppingCart.forEach {
                    println(it)
                }
                println("---------------------------------------------------------")
                println()
                println("More info (Y/N)?")
                if (readLine() == "Y") {
                    println("---------------------------------------------------------")
                    shoppingCart.forEach {
                        println(it.moreDetails())
                    }
                    println("---------------------------------------------------------")
                }
            }
            "Filter" -> {
                println("Which type? (Food, Power_Tool, Medicine, Clothing)")
                val type = readLine()!!.toUpperCase()
                println("---------------------------------------------------------")
                if (type == "FOOD" || type == "POWER_TOOL" || type == "MEDICINE" || type == "CLOTHING") {
                    shoppingCart
                        .filter {
                            it.typeAsString() == type
                        }
                        .forEach {
                            println(it)
                        }
                }
                println("---------------------------------------------------------")
            }
            else -> {
                println("OOPS!")
                break
            }
        }
        println("Action please (Done, Dessert, Drill, Shirt, Print, Filter)")
        c = readLine()!!.toLowerCase().capitalize()
    }
}