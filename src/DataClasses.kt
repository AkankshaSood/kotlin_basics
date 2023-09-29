fun main() {
    equalityOper()
    anyClass()
    dataClass()
    copyFun()
    componentNFun()
    refCheckDataClass()
    keepInMind()
    tooManyArguments()
    print("${null}")
}

fun tooManyArguments() {
    /**
    * Whenever there are too many fields in the data class, consider adding default value
    * */

    data class TooManyArgs(val a: Int, val b: Int, val c: Int = 3, val d: Int, val e: Int)

    val args = TooManyArgs(1,2,3,4,5)
    /**
     * alternatively, use named arguments
    * */
    val args2 = TooManyArgs(a=1, d=3, b=4, e=5)
}

fun keepInMind() {
    val test = Test2(1,2)
    val test2 = Test2(1,2)
    test.c = "o"
    test2.c = "i"

    /** this will compile to true, because in data classes, equals and hashCode functions
     * only takes into consideration what is present in the constructor
     */
    println(test.equals(test2))
}

fun refCheckDataClass() {
    /*
    * To check if two object hold the same ref, use === operator
    * */
}

fun componentNFun() {
    val test = DataClassTest(1, "pp")
    val a = test.a

    /**
    * data classes create component functions,
     * this is used for destructing the object
    * */
    val b = test.component1()

    val (c, d) = test
    println( c)
    println(d)
}

fun copyFun() {
    /**
     * This function is used to copy some data object while altering some of its properties
     * */

    val a = DataClassTest(2, "test");
    val b = a.copy(b = "testing")
    println(b)
}

fun dataClass() {
    /**
    * Whenever you want to compare the contents of the object instead of just the reference,
    * either override the equals functions or simply use data classes
    *
    * data class can be created by prefixing the class with data keyword,
    * other than that everything remains same
    *
    * they override all three functions of Any class, toHashCode function generates same code for objects having
    * same values
    **/

    val a = DataClassTest(1, "hey")
    val b = DataClassTest(1, "hey")
    println(a == b)
}

fun anyClass() {
    /**
   * equals is inherited from Any class
   * Any class is the mother of all classes,
   * it ensures that every class inherits common behaviour
   * also, polymorphic array can be created of type Any
   * */

    /**
    * Any class has three functions, equals, hashCode and toString
    * */
}

fun equalityOper() {
    /**
    The == operator calls equals function,
    by default the equals functions checks if both the objects hold the same reference,
    however this function can be overriden
    * */
    var a: Test = Test();
    var test = a;
    println(a==test)
    println(a.equals(test))

    val b = Test()
    println(b==test)
    println(b.equals(test))

}

class Test() {

}

data class DataClassTest(val a: Int, val b: String)

data class Test2(val a: Int, val b: Int) {
    var c = "pp";
}
