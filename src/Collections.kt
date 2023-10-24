fun main() {
    arrays()
    //list and set are immutable by default, use mutableListOf for mutable list
    var list = mutableListOf<Int?>(1,2,3)
    list.add(4)
    list.add(1,5)
    list.remove(2)
    list.removeAt(0)
    val list2 = listOf(5,6,7)
    // can only add list of Int? type
    list.addAll(list2)
    //retain, remove
    equalsFunction()
}

fun equalsFunction() {
    // === checks for reference while == uses .equals() to check
    // == can be used on sets and lists also
}

fun arrays() {
    val arr1 = arrayOf(1,2,3)
    var nullArray = arrayOfNulls<String>(3)
    arr1.size
    arr1.get(1)
    arr1.sum()
    arr1.reverse()
    arr1.sort()
    //read more about map function
}
