fun main(args: Array<String>) {

    var signatureDrink = "Buttered Ale"
    //signatureDrink = null         Kotlin: Null can not be a value of a non-null type String

    var beverage1 = readLine()   //public fun readLine(): String?
    println(beverage1)

    beverage1 = null
    println(beverage1)

    // ?.
    var beverage2 = readLine()?.split(' ')?.map { it.replaceFirstChar( Char::uppercase ) }?.joinToString(" ")
    println(beverage2)

    var beverage3 = readLine()?.let {
        if(it.isNotBlank()) {
            it.split(' ').map { it.replaceFirstChar( Char::uppercase ) }.joinToString(" ")
        } else {
            "Bluttered Ale"
        }
    }
    println(beverage3)

    // !!.
    var beverage4 = readLine()!!.split(' ')?.map { it.replaceFirstChar( Char::uppercase ) }?.joinToString(" ")
    println(beverage4)

    // if
    var beverage5 = readLine()
    if(beverage5 != null) {
        beverage5.split(' ').map { it.replaceFirstChar( Char::uppercase ) }.joinToString(" ")
        println(beverage5)
    } else {
        println("I can't do that with out crashing - beverage was null!")
    }
    val beverageServed: String = beverage5 ?: "Bluttered Ale"
    println(beverageServed)

    // beverage5 = null

    beverage5?.let {
        it.split(' ').map { it.replaceFirstChar( Char::uppercase ) }.joinToString(" ")
    } ?: println("I can't do that with out crashing - beverage was null!")
}