fun calculateScore(tournament: String) = tournament.split("\n").map { r ->
    r.split(" ")
}.sumOf { (opponent, me) ->
    calculateRoundScore(opponent, me)
}

private fun calculateRoundScore(opponent: String, me: String) =
    selectedShapeScoreMap[me]!! + roundScoreMap[me]!![opponent]!!

val selectedShapeScoreMap = mapOf("X" to 1, "Y" to 2, "Z" to 3)
val roundScoreMap = mapOf(
    "X" to mapOf("A" to 3, "B" to 0, "C" to 6),
    "Y" to mapOf("A" to 6, "B" to 3, "C" to 0),
    "Z" to mapOf("A" to 0, "B" to 6, "C" to 3)
)

