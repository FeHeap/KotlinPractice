fun main() {

    var swordsJuggling: Int? = null
    var isJugglingProficient = (1..3).shuffled().last() == 3
    if(isJugglingProficient) {
        swordsJuggling = 2
    }
    println("You juggle $swordsJuggling swords!")

    try {
        proficiencyCheck_1(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
    } catch(e: Exception) {
        println(e)
    }

    println("You juggle $swordsJuggling swords!")

    swordsJuggling = null
    isJugglingProficient = (1..3).shuffled().last() == 3
    if(isJugglingProficient) {
        swordsJuggling = 2
    }
    try {
        proficiencyCheck_2(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
    } catch(e: Exception) {
        println(e)
    }
    println("You juggle $swordsJuggling swords!")
}

fun proficiencyCheck_1(swordsJuggling: Int?) {
    swordsJuggling ?: throw UnskilledSwordJugglerException()
}

fun proficiencyCheck_2(swordsJuggling: Int?) {
    checkNotNull(swordsJuggling, {"Player cannot juggle swords"})
}

fun juggleSwords(swordsJuggling: Int) {
    require(swordsJuggling >= 3, {"juggle at least 3 swords to be exciting."})
}

class UnskilledSwordJugglerException():
    IllegalStateException("Player cannot juggle swords")