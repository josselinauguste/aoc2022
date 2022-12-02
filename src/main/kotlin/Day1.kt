fun caloriesOfTheElfCarryingTheMost(inventory: String) = caloriesPerElf(inventory).max()

fun caloriesOfTheTopElvesCarryingTheMost(inventory: String, top: Int) =
    caloriesPerElf(inventory).sortedDescending().take(top).sum()

private fun caloriesPerElf(inventory: String) =
    inventory.split("\n\n").map { e -> e.split("\n").map { c -> c.toInt() }.sum() }