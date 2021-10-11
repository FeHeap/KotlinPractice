fun main() {
    val name = "Fe"
    var healthPoints = 100
    val isBlessed = true
    val isImmortal = false

    //if...else...
    if(healthPoints == 100) {
        println(name + " is in excellent condition!")
    } else {
        println(name + " is in awful condition!")
    }

    healthPoints = 89

    //if...else if...else...
    if(healthPoints == 100) {
        println(name + " is in excellent condition!")
    } else if (healthPoints >= 90) {
        println(name + " has a few scratches.")
    } else if (healthPoints >= 75) {
        if(isBlessed)   {
            println(name + " has some minor wounds but is healing quite quickly!")
        } else {
            println(name + " has some minor wounds.")
        }
    } else if (healthPoints >= 15) {
        println(name + " looks pretty hurt.")
    } else {
        println(name + " is in awful condition!")
    }

    val healthStatus1 = if(healthPoints == 100) {
        "is in excellent condition!"
    } else if (healthPoints >= 90) {
        "has a few scratches."
    } else if (healthPoints >= 75) {
        if(isBlessed)   {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
    } else if (healthPoints >= 15) {
        "looks pretty hurt."
    } else {
        "is in awful condition!"
    }
    println(name + " " + healthStatus1)

    //range
    val healthStatus2 = if(healthPoints == 100) {
        "is in excellent condition!"
    } else if (healthPoints in 90..99) {
        "has a few scratches."
    } else if (healthPoints in 75..89) {
        if(isBlessed)   {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
    } else if (healthPoints in 15..74) {
        "looks pretty hurt."
    } else {
        "is in awful condition!"
    }
    println(name + " " + healthStatus2)
    println(1 in 1..3)          //true
    println((1..3).toList())    //[1, 2, 3]
    println(1 in 3 downTo 1)    //true
    println(1 in 1 until 3)     //true
    println(2 in 1..3)          //true
    println(2 !in 1..3)         //false
    println('x' in 'a'..'z')    //true


    //logical operator
    if(isBlessed && healthPoints > 50 || isImmortal) {
        println("GREEN")
    } else {
        println("NONE")
    }

    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    if(auraVisible) {
        println("GREEN")
    } else {
        println("NONE")
    }
    var auraColor = if(auraVisible) "GREEN" else "NONE"
    println(auraColor)

    //when
    val race = "gnome"
    val faction = when(race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
        "orc"   -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else    -> ""
    }

    val healthStatus3 = when(healthPoints) {
        100       -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if(isBlessed) {
                         "has some minor wounds but is healing quite quickly!"
                     } else {
                         "has some minor wounds."
                     }
        in 15..74 -> "looks pretty hurt."
        else      -> "is in awful condition!"
    }
    println(name + " " + healthStatus3)

    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()
    auraColor = when(karma) {
        in 0..5   -> "red"
        in 6..10  -> "orange"
        in 11..15 -> "purple"
        in 16..20 -> "green"
        else      -> "error"
    }
    println(auraColor)

    //string $ ${}
    println("$name $healthPoints")
    println("(Aura: $auraColor) " + "(Blessed: ${if(isBlessed) "YES" else "NO"})")
    val statusFormatString = "(HP: $healthPoints)(Aura: $auraColor) -> $healthStatus3"
    println(statusFormatString)
}