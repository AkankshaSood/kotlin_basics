data class Grocery(val unitPrice: Int, val quantity: Int, val name: String)
val items = listOf(Grocery(1,2, "banana"),
    (Grocery(3,63, "apple")), Grocery(4, 9, "apricots"))

val ints = listOf<Int>(1,2,5,3)

fun main() {
    println(items.maxByOrNull { it.quantity})
    val doubleInts = ints.map { it * 2 }
    // map transforms the collection
    // filter, groupBy, forEach are also there
    // function chaining can happen with the help of lambdas
    val sumOfInts = ints.fold(0) { runningSum, item -> runningSum + item }
    // fold can be used to find product, concatenate all strings, calculate bill and the balance amount
}