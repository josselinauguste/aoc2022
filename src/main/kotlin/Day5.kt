import java.util.*

fun cratesOnTopOfStacks(input: String, group: Boolean = false): String {
    val (rawStacks, rawProcedure) = input.split("\n\n")
    val stacks = parseStacks(rawStacks)
    val procedure = parseProcedure(rawProcedure)
    for (p in procedure) {
        val buffer = Stack<Char>()
        for (i in 1..p.first) {
            buffer.push(stacks[p.second - 1].pop())
        }
        if (group) buffer.reverse()
        stacks[p.third - 1].addAll(buffer.toList())
    }
    return stacks.map { s -> s.last() }.joinToString("")
}

fun parseStacks(raw: String): List<Stack<Char>> {
    val storeys = raw.split("\n").reversed().drop(1)
    val stacks: MutableList<Stack<Char>> = mutableListOf()
    for (storey in storeys) {
        for (crateIndex in 1..storey.length step 4) {
            val stackIndex = (crateIndex - 1) / 4
            if (stacks.size == stackIndex) {
                stacks.add(Stack())
            }
            val crate = storey[crateIndex]
            if (crate != ' ') stacks[stackIndex].push(crate)
        }
    }
    return stacks
}

fun parseProcedure(rawProcedure: String): List<Triple<Int, Int, Int>> =
    Regex("move (\\d+) from (\\d+) to (\\d+)").findAll(rawProcedure)
        .map { m -> val (_, m1, m2, m3) = m.groupValues; Triple(m1.toInt(), m2.toInt(), m3.toInt()) }
        .toList()
