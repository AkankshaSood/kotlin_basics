fun main() {
    // refer to book for more clarity
}

open class Animal(open var image: String, open val food: String, open var habitat: String) {
    open val propertyOne = "base";
    open var propertyTwo = "base"
    get() {
        return field + "p"
    }
    set(value) {
        field = value + "o";
    }
    var propertyThree = "three"
    fun roar() {
        println("Animal is roaring")
    }
    open fun eat() {
        println("Animal is eating")
    }
}

// the next line would have given compile time error had the class not been open
open class Carnivores: Animal("img", "food", "habitat") {
    override var image = "pppppppp"
    override var food = "c food"
    override var habitat = "c habitat"

    // notice how val variables can become var after overriding
    override var propertyOne = "one"

    // notice even had to be marked as overridden and open for overriding the getter and setter
    override var propertyTwo = "p"
    get() = field + "o"
    set(value) {
        field = value+"l"
    }

    init {
        propertyTwo = "pp"

        //notice since it was a var, there was no need to redeclare it
        propertyThree = "three"
    }

    override fun eat() {
        super.eat()
    }
}

open class Tiger: Carnivores() {

    //notice how we did not have to redeclare the eat function of Carnivores class as open,
    //however if you want to stop the function from getting overridden further down the tree, declare the method as final
    final override fun eat() {
        super.eat()
    }
}

class FemaleTiger: Tiger() {
    //here eat cannot get overridden
}

open class SuperClass() {
    // variables need not be declared as open
    var image = ""
    open val valProperty = "hey"
    // functions are final by default
    open fun methodOne() {

    }
}

// () are a must here
class DerivedClass: SuperClass() {
    // val properties must be overriden if they have to be reinitialsed
    override val valProperty = "hey2"
    init {
        image = "pp"
    }

    override fun methodOne() {
         image = "override in function"
     }
}