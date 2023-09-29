
fun main() {
    var options = arrayOf("stone", "paper", "scissor")
    var first = getChoice(options)
    println(first)
    first = "will value in array change?"
    println(first)
    println(options[0]+" "+options[1]+" "+options[2])
    println("no values of array does not change")
    var second = getUserChoice(options)
    println("Winner is ${getWinner(first, second)}")
}

fun forLoopTypes() {
    // both are included
    for (i in 1..5) {
        println(i)
    }

    //end is excluded
    for (i in 1 until 5) {
        println(i)
    }

    // for reverse order
    for (i in 5 downTo 1) {
        println(i)
    }

    //defined step
    for (i in 1 until 5 step 2) {
        println(i)
    }

    // looping an array
    var arr = arrayOf(1,2,3)
    for (item in arr) {
        println(item)
    }
    for ((i, item) in arr.withIndex()) {
        println(item)
    }
}

// Unit means no return type, it can be omitted as well
fun printSum(num1: Int, num2: Int): Unit {
    // next line will not compile because parameters are treated as val
//    num1 = 9
    println(num1+num2)
}

// If a function contains a single expression, it can be written in the following form
fun max(num1: Int, num2: Int): Int = if (num1 > num2) num1 else num2;

// As a further optimisation, return type can get auto inferred, but this won't work in normal functions
fun max2(num1: Int, num2: Int) = if (num1 > num2) num1 else num2;

fun getChoice(options: Array<String>) = options[(Math.random()*options.size).toInt()]

fun getUserChoice(options: Array<String>): String {
    var choice: String? = null;
    var input: String?
    while (choice == null) {
        println("Choose one of the below")
        for (option in options) {
            println(option)
        }
        input = readLine()
        if (input != null && input in options) {
            choice = input
        }
    }
    return choice
}

fun getWinner(first: String, second: String): String {
    if (first == second) {
        return "nobody";
    }
    return if (first == "paper") {
        if (second == "scissor") "user" else "computer"
    } else if (first == "scissor") {
        if (second == "stone") "user" else "computer"
    } else {
        if (second == "scissor") "computer" else "user"
    }
}

