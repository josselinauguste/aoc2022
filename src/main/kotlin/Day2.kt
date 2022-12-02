fun calculateScore(tournament: String) = getRounds(tournament).sumOf { (opponent, me) ->
    calculateRoundScore(opponent, me)
}

fun calculateScoreForRoundEnd(tournament: String) =
    getRounds(tournament).map { (opponent, end) -> listOf(opponent, shapeFromEnd[end]!![opponent]!!) }
        .sumOf { (opponent, me) ->
            calculateRoundScore(opponent, me)
        }

private fun getRounds(tournament: String) = tournament.split("\n").map { r ->
    r.split(" ")
}

private fun calculateRoundScore(opponent: String, me: String) =
    selectedShapeScoreMap[me]!! + roundScoreMap[me]!![opponent]!!

val selectedShapeScoreMap = mapOf("X" to 1, "Y" to 2, "Z" to 3)
val roundScoreMap = mapOf(
    "X" to mapOf("A" to 3, "B" to 0, "C" to 6),
    "Y" to mapOf("A" to 6, "B" to 3, "C" to 0),
    "Z" to mapOf("A" to 0, "B" to 6, "C" to 3)
)
val shapeFromEnd = mapOf(
    "X" to mapOf("A" to "Z", "B" to "X", "C" to "Y"), // lose
    "Y" to mapOf("A" to "X", "B" to "Y", "C" to "Z"), // draw
    "Z" to mapOf("A" to "Y", "B" to "Z", "C" to "X") // win
)
