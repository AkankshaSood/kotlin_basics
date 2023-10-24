fun main() {
    /**
     * Abstract functions are useful when because even though they dont contain any code,
     * they define the parameters and the return type
     * */

    /**
     * Interfaces determine a protocol
     * */

    isAndAs()
    whenTest(2)
}

fun whenTest(a: Any) {
    println (when(a) {
        in 1..5 -> "in 1 to 5"
        6 -> "6"
        7,8 -> "7,8"
        is String -> "string"
        else -> "idk!"
    })
}

// abstract classes don't have to be marked open
abstract class Animal2(val type: String) {
    abstract val image: String
    abstract fun makeNoise()

    // even in abstarct classes, if you are overriding the functions then open and override keywords are important
    open fun eat() {
        println("eating!!!")
    }

    abstract fun makeNoise2()
}

abstract class Canine(type: String): Animal2(type) {
    override fun eat() {

    }

    // because this function has been implemented here, therefore overriding it in Lion class is optional
    override fun makeNoise2() {
        TODO("Not yet implemented")
    }
}

class Lion() : Canine("lion") {
    //notice how directly the property was made non-abstract here
    override val image = "lion image"

    override fun makeNoise() {
        println("roarrrr")
    }
}

interface Roamable {
    var velocity: Int

//        //this wont compile
//    set(value) = {
//        field = value
//    }
    fun move() {
        println("roaming")
    }
}

//parentheses are not required after Roamable because it has not constructor
class Car: Roamable {
    override var velocity: Int = 20
        get() = 20
    override fun move() {
        TODO("Not yet implemented")
    }
}


// both inhereits and extends
class Cub: Canine("lion"), Roamable {
    override val image = "cub"

    override var velocity: Int = 20
        get() = 20

    override fun makeNoise() {
        TODO("Not yet implemented")
    }

    override fun move() {
        TODO("Not yet implemented")
    }

}

interface A {
    fun test() {
        println("test a")
    }

    fun emptyTest()
}

interface B {
    fun test() {
        println("test B")
    }

    fun test2() {
        println("test 2")
    }
}

class C: A, B {
    override fun test() {
        super<A>.test()
        super<B>.test()
    }

    // class name in angular bracket is not required here
    override fun test2() {
        super.test2()
    }

    override fun emptyTest() {
        TODO("Not yet implemented")
    }
}

class D: A {
    fun test3() {
        println("test 3")
    }

    override fun emptyTest() {
        TODO("Not yet implemented")
    }
}

/**
* [IMPORTANT] What is the difference between abstract class and an interface?
* Abstract functions cannot have definitions but interface functions can,
* because in abstract class you define a template for a group of subclasses
* whereas in interface you define some common behaviour
* */

/*
* is is used to ensure the subtype, like if (wolf is Animal)
* */
fun isAndAs() {
    val arr = arrayOf(C(), D())
    for (item in arr) {
        item.test()
        if (item is D) {
            item.test3()
        }
        println("is not D? ${item !is D}")
    }
    val c = D()
    if (c is D) {
        c.test3()
    }

}

