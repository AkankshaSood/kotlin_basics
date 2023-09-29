import java.util.*

class Dog (name: String, var weight: Int, val height: Int, val breed: String) {
    fun bark() {
        // name cannot be referenced here
        println("bark")
    }
}

fun main() {
    initializeClass()
    behindTheScenesOfConstructor()
    customConstructor()
    initBlock()
    lateinitVariables()
    customGettersAndSetters()
}

fun customGettersAndSetters() {
    /*
    * Need:
    * Getters -> to return the weight in kg
    * Setters -> To ensure that weight is not a negative value
    * */

    class Dog(val name: String, val weight: Int) {
        // this property does not need to be initialised because its value is derived in the getter
        val weightInKg: Double
        get() {
            return weight/2.2
        }
    }

    class Dog2(val name: String, val weight: Int) {
        // here the property has to be initialised
        // this will run when dog.weight = 75 is called
        var weightInKg: Int = weight
            set(value) = if (value>0) field = value else field = 0

    }

    /**
     * Whenever any field is added, the compiler secretly adds a custom getter to the val fields
     * and both custom getter as well as setter to var fields
     * */
}

fun lateinitVariables() {
    /*
    * A variable cannot be left uninitialised in the class,
    * The only way to manage this is to mark the variable as lateinit
    * otherwise the code will not compile
    * */

    /*
    * If a lateinit property is used before getting initialise, then it will throw an error at runtime
    * */

    /*
    * lateinit can be used only with var
    * It cannot be used with int, Short, long, boolean, byte, double, char, string*/
}

fun initBlock() {
    /*
    * These are executed immediately after the constructor is called, and are used for complex init level things
    * (anything other than simple expression)
    * */

    /*
    * Each class can have multiple init blocks, and they are executed in the order of their occurrence
    * */

    class Dog4(val name: String, var weight: Int, val height: Int, val breed: String) {
        init {
            println("first init, activities have not yet been initialised")
        }
        val activities = arrayOf("walk", "eat", "sleep");
        init {
            println("second init, activities have been initialised")
        }
    }
}

fun customConstructor() {
    /*
    * Initializing values in constructor is such a common operation that its code was concised,
    * however if you want to initialize it in the old fashion or want to do something other than just initialising
    * like preprocessing etc. then do the following:
    * */

    class DogWithCustomConstructor(name_param: String, weight_param: Int, breed_param: String) {
        val name = name_param
    }

    /*
    * Now name_param etc. are no longer properties of class (val or var), they are just arguments to the constructor*/

    class Dog2(val name: String, var weight: Int, val height: Int, val breed: String) {
        val activities = arrayOf("walk", "eat", "sleep");
    }

    class Dog3(val name: String, breed_param: String, val weight: Int) {
        val breed = breed_param + "breed";
    }
}

fun behindTheScenesOfConstructor() {
    /*
    * 1) An object is created for each argument of the constructor
    * 2) Space allocation for new dog object, then constructor is called
    * 3) A variable of appropriate type is created for each variable
    * 4) Values are assigned
    * 5) Ref to dog object is created and is assigned to the variable
    * */
}

fun initializeClass() {
    val dog = Dog("Sheero", 70, 20, "german");
    dog.bark();
    println(dog.breed)

   // will give compiler error because breed is val
   // dog.breed = "try"

    // A constructor is a piece of code that is needed to initialize an object,
    // it runs before the object is assigned any reference
}
