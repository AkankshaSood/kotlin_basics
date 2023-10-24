fun main() {
    intro()
    val pounds = convert(20.0, getConversionLambda("KgToPound"))
    val a = getConversionLambda("KgToPounds")(2.5)
    combineLambda(getConversionLambda("KgToPounds"), getConversionLambda("PoundstoTons"))
    combineLambda2(getConversionLambda("KgToPounds"), getConversionLambda("PoundstoTons"))
}

// it can be used to rename Array<Duck> also and not just functions
typealias DoubleConversion = (Double) -> Double

fun combineLambda2(lambda1: DoubleConversion, lambda2: DoubleConversion): (Double) -> Double{
    return { x : Double -> lambda2(lambda1(x)) }
}

fun combineLambda(lambda1: (Double) -> Double, lambda2: (Double) -> Double): (Double) -> Double{
    return { x : Double -> lambda2(lambda1(x)) }
}

fun intro() {
    // Lambda functions start and end with braces, they can have any number of parameters
    // The parameters are followed by ->, this is the actual code has to be executed. They can have one or multiple lines
    // Last line is used as the return value of the lambda function
    // lambdas have no name

    /*
    * Lambdas and functions are both valid ways to write code in Kotlin.
    * Lambdas are often used when you need to pass a function as a parameter,
    * or when you need to create a function that is only used once.
    * Functions are often used when you need to create a function that is used multiple times,
    * or when you need to create a function that has a more complex return type.
    * */

    val addFive = { x: Int -> x + 5}
    val result = addFive.invoke(2)
    print(result)
    print(addFive(2))

    // infer parameters
    val twp: (Int)->Int = {x -> x+5}

    //single parameter can be replaced by it
    val three: (Int) -> Int = {it+5}

    val calculate: (Int, Int) -> Int
    // wont compile
    //calculate = {x: Double, y: Double -> x+y}

    val faValue = convert(2.0) {
        println("hello")
        it * 1.8 + 32
    }
}

fun convert(x: Double, converter: (Double) -> Double) : Double {
    return converter(x)
}

//return lambda from function
fun getConversionLambda(str: String): (Double) -> Double {
    return when(str) {
        "CentToFar" -> { x -> x * 1.8 + 32 }
        "KgToPound" -> { x -> x * 2.204 }
        else -> { x -> x }
    }
}
