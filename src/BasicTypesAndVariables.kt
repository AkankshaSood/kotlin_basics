fun main() {
    variableTypes()
    stringTemplates()
    array()
    refCheck()
}

private fun variableTypes() {
    /*
    * Four types of Integer are there:
    * -> Int --------32 bits ------- [-2,147,483,648 to 2,147,483,647]
    * -> Long -------64 bits -------- [
    * -> Byte ------- 8 bits ------ [-128,127]
    * -> Short -------16 bits ------[-32768 to 32767]*/

    /*
    * out of these four by default integers are created*/
    //integer types
    var x = 16;
    var longVariable = 6L;
    var binVariable = 0b10;
    var hexVariable = 0x11;

    //float
    var a = 10.2
    var b = 10.2F

    //boolean
    var c = false;
    var d = true;

    // char and string
    var e= 'o'
    var f = "foo"

    //explicit type creation
    var smallNum: Short = 1;

// below code will throw compilation error because g is of type Int
//        var g = 2;
//        var h: Long = g;

    // in the below code, g & h hold the same address and both are of type Int
    var g = 2;
    var h = g;

    var i = 2;
    var j: Long = i.toLong()

    //In case of overspill, two's complement is calculated
}

private fun stringTemplates() {
    val myArray = arrayOf("long", 1 , 12.3, "hey")
    var arrSize = "My array has ${myArray.size} size"
    println(arrSize)
    println("My array is ${if (myArray.size > 2) "long" else "small"}")
}

private fun array() {
    val myArray = arrayOf("long", 1 , 12.3, "hey")
    println(myArray[2])
    println(myArray.size)

    val myArray2 = arrayOf(1, 2, 3)
    // below statement will not compile because array has inferred its type to be Int
    // myArray2[0] = 0L

    val myArray3 = arrayOf(1, 2, "hi")
    // however, this will work
    myArray3[0] = 0L
}

private fun refCheck() {
    var x = 1;
    var y = x;
    println(y)
    println(x)
    //new references are created
    y = 3;
    x = 4
    println(y)
    println(x)


    var a = "hlo"
    var b  = a
    println(a)
    println(b)
    b = "oo"
    println(a)
    println(b)

    var arr1 = arrayOf(1, 2, 3)
    var arr2 = arr1
    arr2[0] = 4
    println(arr1[0])
    println(arr2[0])
}