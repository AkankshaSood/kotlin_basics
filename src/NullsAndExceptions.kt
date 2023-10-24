import java.lang.Exception

fun main() {
    nullableParams(null)
    types()
    assignValues()
    letOperator()
    elvis()
    doubleExcalamation()
    println(tryAndCatch())
    throwCustomException()
}

fun throwCustomException() {
    val h: Human? = null
    if (h !is Human) throw HumanException("not human!")

    // throw is of type Nothing, var with Nothing type can only hold null values
}

class HumanException(e: String): Exception(e)

fun tryAndCatch(): Int {
    // finally will run even if try catch has return statement, flow jumps to finally then to return
    return try {
        var x = "two"
        println("trying")
        x.toInt()
    } catch (e: Exception) {
        println("in catch")
        0;
    } finally {
        println("in finally")
    }
}

fun doubleExcalamation() {
    // this throws delibrately throws a null pointer exception if object is null
}

fun elvis() {
    var h: Human? = Human()
    var age = h?.age ?: 0
}

class Human() {
    var age: Int? = null;
    fun eat() {
        print("eating")
    }
}

fun letOperator() {
    var h: Human? = Human();
    var age = h?.let {
        it.age
        it.eat()
    }
}

fun assignValues() {
    var a: Int? = 2;
    var x = a?.toString()
    x = "ppp"
    x = null
    // next line will throw compile time error because x is of type string or null
    //x = 2

    // safe assigning
    //a?.b = 2
}

fun types() {
    // the compiler will auto-detect that array is of type Array<String?>
    val array = arrayOf("hey", "hey2", null)

    var x = null;
    // next line will throw compile time error because the compiler has interpreted that it is of type Nothing?
    //x = 2
}

/**
 * If params are nullable even then null has to be passed
 **/
fun nullableParams(x: Int?): String? {
   return if (x!==null && x>0) x.toString() else null
}
