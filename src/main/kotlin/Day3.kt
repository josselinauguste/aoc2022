fun sumPrioritiesOfItemTypesInBothCompartiments(listOfcontents: String) =
    listOfcontents.split("\n").map { r -> splitCompartiments(r) }.flatMap { r -> itemsInBothCompartiments(r) }
        .sumOf { r -> itemTypeToPriority(r) }

fun sumPrioritiesOfBadgesOfElfGroups(listOfcontents: String) =
    listOfcontents.split("\n").chunked(3).filter { g -> g.size == 3 }
        .flatMap { (e1, e2, e3) -> e1.asIterable().intersect(e2.asIterable()).intersect(e3.asIterable()) }
        .sumOf { r -> itemTypeToPriority(r) }

private fun splitCompartiments(rucksack: String): Pair<CharSequence, CharSequence> =
    rucksack.subSequence(0, rucksack.length / 2) to rucksack.subSequence(
        rucksack.length / 2, rucksack.length
    )

private fun itemsInBothCompartiments(rucksack: Pair<CharSequence, CharSequence>): Set<Char> =
    rucksack.first.asIterable().intersect(rucksack.second.asIterable().toSet())

private fun itemTypeToPriority(itemType: Char): Int =
    if (itemType.minus('A') < 26) itemType.minus('A') + 27 else itemType.minus('a') + 1
