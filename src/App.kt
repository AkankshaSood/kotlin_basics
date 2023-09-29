fun helloWorld() {
    println("hello world")

    var x = 1;
    println("Value of x: $x");
    while (x<10) {
        x++;
    }
    println("New value of x: $x");

    val y = 1;
    val z = 4;

    if (y>z) {
        println("y is greater than z");
    } else {
        println("z is greater than y")
    }

    println(if (y>z) "y is greater" else "z is greater")
}

/*
* JVM looks for this function and executes it
* */
fun main() {
    helloWorld()
}