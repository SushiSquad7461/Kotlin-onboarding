package items

import Item
import time.Days
import time.Years

class Drill(
    val modelName: String,
    val brand: String,
    val batteryLife: Days = Days(3),
    val warrantyPeriod: Years = Years(1)
) : Item(modelName, ItemType.POWER_TOOLS) {
    private var age: Years = Years(0)
    private var charge: Days = Days(batteryLife.i)
    fun inWarranty(): Boolean {
        return age < warrantyPeriod
    }

    fun hasCharge(): Boolean {
        return charge < batteryLife
    }

    fun incrementAge() {
        age = Years(age.i + 1)
    }

    fun decrementCharge() {
        if (charge.i > 0) charge = Days(charge.i - 1)
    }

    fun chargeBattery() {
        charge = Days(batteryLife.i)
    }

    override fun toString(): String {
        return "$modelName Drill from brand $brand"
    }

    override fun moreDetails(): String {
        return "${toString()}. $charge days of battery left. $age years into warranty. ${
            when (inWarranty()) {
                true -> "Warranty still applies"
                false -> "Warranty no longer applies"
            }
        }."
    }
}