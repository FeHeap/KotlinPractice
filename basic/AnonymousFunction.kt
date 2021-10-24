fun main() {
    var numLetters = "Mississippi".count()
    println(numLetters)

    numLetters = "Mississippi".count({ letter->
        letter == 's'
    })
    println(numLetters)

    println({
        val currentYear = 2021
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
    }())

    val greetingFunction1: () -> String = {
        val currentYear = 2021
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
    }
    println(greetingFunction1())

    val greetingFunction2: (String) -> String = { playerName ->
        val currentYear = 2021
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingFunction2("Fe"))

    val greetingFunction3: (String) -> String = {
        val currentYear = 2021
        "Welcome to SimVillage, $it! (copyright $currentYear)"
    }
    println(greetingFunction3("Fe"))

    println("Mississippi".count({ it == 's' }))

    val greetingFunction4: (String, Int) -> String = { playerName, numBuildings ->
        val currentYear = 2021
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingFunction4("Fe", 2))

    val greetingFunction5 = {
        val currentYear = 2021
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
    }
    println(greetingFunction5())

    val greetingFunction6 = { playerName: String, numBuildings: Int ->
        val currentYear = 2021
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

    println(greetingFunction6("Fe", 3))
    runSimulation1("Andy", greetingFunction6)

    println("Mississippi".count { it == 's' })

    runSimulation1("luder") { playerName, numBuildings ->
        val currentYear = 2021
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

    runSimulation2("shiro", ::printConstructionCost) { playerName, numBuildings ->
        val currentYear = 2021
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

    runSimulation3()

    runMyRunnable { println("hey now") }
}

fun runMyRunnable(runnable: () -> Unit) = runnable()

fun runSimulation3() {
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("jhaorong"))
    println(greetingFunction("jhaorong"))
}

fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2021
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}

inline fun runSimulation2(playerName: String,
                          costPrinter: (Int) -> Unit,
                          greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()
    costPrinter(numBuildings)
    println(greetingFunction(playerName, numBuildings))
}

fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("construction cost: ${cost * numBuildings}")
}

// Function Inlining
inline fun runSimulation1(playerName: String, greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()
    println(greetingFunction(playerName, numBuildings))
}
