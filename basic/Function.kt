fun main() {
    val playerName = "Fe"
    var healthPoints = 100
    val isBlessed = true
    val isImmortal = false
    var Drunk = 0

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)
    println(playerName + " " + healthStatus)

    var auraColor = auraColor_1(isBlessed, healthPoints, isImmortal)
    printPlayerStatus(playerName, healthPoints, auraColor, isBlessed)
    auraColor = auraColor_2(isBlessed, healthPoints, isImmortal)
    printPlayerStatus(playerName, healthPoints, auraColor, isBlessed)
    printPlayerStatus(playerName = "luder", healthPoints = 60, auraColor = "purple", isBlessed = false)
    printPlayerStatus(playerName = "luder", isBlessed = false, auraColor = "purple", healthPoints = 60)

    Drunk += castFireball_1()
    Drunk += castFireball_2(5)
    Drunk += castFireball_3()
    Drunk += castFireball_3(6)
    val Drunkenness = when(Drunk) {
        in 1..10    -> "tipsy"
        in 11..20   -> "sloshed"
        in 21..30   -> "soused"
        in 31..40   -> "stewed"
        else -> "..t0zSt3d"
    }
    println("Drunkenness: $Drunkenness")

    performCombat()
    performCombat("Ulrich")
    performCombat("Hildr", true)

    shouldReturnAString()

}

private fun printPlayerStatus(
    playerName: String,
    healthPoints: Int,
    auraColor: String,
    isBlessed: Boolean
) {
    println("$playerName $healthPoints")
    println("(Aura: $auraColor) " + "(Blessed: ${if (isBlessed) "YES" else "NO"})")
}

private fun auraColor_1(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"

    return auraColor
}

private fun auraColor_2(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean) =
    if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }


private fun castFireball_1(): Int {
    println("A glass of Fireball springs into existence.")
    return (1..3).random()
}

private fun castFireball_2(numFireballs: Int): Int {
    println("A glass of Fireball springs into existence. (x$numFireballs)")
    return (1..3).random() * numFireballs
}

private fun castFireball_3(numFireballs: Int = 2): Int {
    println("A glass of Fireball springs into existence. (x$numFireballs)")
    return (1..3).random() * numFireballs
}

//TODO
fun shouldReturnAString(): String {
    TODO("implement the string building functionality here to return a string")
    println("unreachable")
}

//function overloading
fun performCombat() {
    println("You see nothing to fight!")
}

fun performCombat(enemyName: String) {
    println("You begin fighting $enemyName.")
}

fun performCombat(enemyName: String, isBlessed: Boolean) {
    if(isBlessed) {
        println("You begin fighting $enemyName. You are blessed with 2X damage!")
    } else {
        println("You begin fighting $enemyName.")
    }
}