//Abel Dagne Programming Kotlin Onboarding - 7/31/20
import java.util.Scanner
abstract class Item(name: String, rank: Fun) {
    val ITEM_NAME = name;
    val ITEM_RANK = rank;

    fun getName() = ITEM_NAME
    fun getRank() = rank
}
inline class Fun(val rank: Int) {
    inline fun satisfactionPercent(): Int = rank/100
}

class Digital(name: String, rank: Int) : Item(name, rank)
class Physical(name: String, rank: Int) : Item(name, rank)

class Inventory {
    val INVENTORY_LIST = arrayOfNulls<Item>(4)
    var NUM_ITEMS = 0
    fun addItem(item: Item){
        if(NUM_ITEMS<6){
            INVENTORY_LIST[NUM_ITEMS] = item
            NUM_ITEMS++
        }
        else println("Maximum number of activities reached!")
    }
}
var SCANNER_READ : Scanner = Scanner(System.'in')
var CURRENT_INVENTORY : Inventory = Inventory()
fun main(){
    println("You are about to embark on a 5 hour journey. You can do 4 activities. Type 'begin' to start planning.")
    var play =true;
    while (play) {
        val userResponse = SCANNER_READ.next()
        when (userResponse) {
            "begin" -> println("You can either add a digital or physical activity to your itinerary. What would you like to add first?")
            "digital" -> addItem("Digital")
            "physical" -> addItem("Physical")
        }
        println("Would you like to add another activity, press 1 for yes and 2 for no. You can also type 'list' to view your activities.")
        userResponse = scanner_variable.nextInt()
        when (userResponse) {
            1 -> play = true
            2 -> play = false
            "list" -> listItem()
            else -> println("Press 1 for yes and 2 for no")
        }
    }
}
fun addItem(itemChoice :String){
    println(itemChoice + " activity name?")
    val itemName = SCANNER_READ.next()
    println("On a scale of 1-100, how fun is this?")
    val itemRank = SCANNER_READ.nextInt()
    if(itemChoice.equals("Digital")) {
        CURRENT_INVENTORY.addItem(Digital(itemName, Fun(itemRank)))
    }
    if(itemChoice.equals("Physical")) {
        CURRENT_INVENTORY.addItem(Physical(itemName, Fun(itemRank)))
    }
}

fun listItem(){
    val digitalList = INVENTORY_LIST.filter {it is Digital}
    val physicalList = INVENTORY_LIST.filter {it is Physical}
    println("Type 1 to view your digital activites or 2 to view your physical activites")
    val userResponse = SCANNER_READ.nextInt()
    if(userResponse==1){
        digitalList.forEach{println(it.getName()+", Rank: "+it.getRank())}
    }
    if(userResponse==2){
        physicalList.forEach{println(it.getName()+", Rank: "+it.getRank())}
    }
}