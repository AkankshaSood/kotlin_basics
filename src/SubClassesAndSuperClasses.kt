fun main() {
    // refer to book for more clarity
}

open class Animal(open var image: String, open val food: String, open var habitat: String) {
    open val propertyOne = "base";
    var propertyTwo = "base";
    fun roar() {
        println("Animal is roaring")
    }
    fun eat() {
        println("Animal is eating")
    }
}

// the next line would have given compile time error had the class not been open
class Carnivores: Animal("img", "food", "habitat") {
    override var image = "pppppppp"
    override var food = "c food"
    override var habitat = "c habitat"
    override val propertyOne = "properyy"

    init {
        propertyTwo = "pp"
    }
}

open class SuperClass() {
    var image = ""
}

class DerivedClass: SuperClass() {
    init {
        image = "pp"
    }
}