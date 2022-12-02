fun calculate(inventory: String): Int {
    return inventory.split("\n\n").map { e -> e.split("\n").map { c -> c.toInt() }.sum() }.max()
}