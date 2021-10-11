const val MAX_EXPERIENCE: Int = 5000

fun main() {
    val playerName = "Fe"
    //playerName = "luder";     Kotlin: Val cannot be reassigned
    //var experiencePoints: Int = "thirty-two"     Kotlin: Type mismatch: inferred type is String but Int was expected
    var experiencePoints: Int = 5
    experiencePoints += 5
    println(playerName)
    println(experiencePoints)
    var hasSteed = 0
    var coins = 50

    val tavernName = "Unicorn Horn"
    val TavernkeeperName = "Steven"
    val menu = listOf<String>("wine", "mead", "LaCroix sparkling water")

    println(playerName.reversed())
}