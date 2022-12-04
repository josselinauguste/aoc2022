fun numberOfFullyOverlappingAssignments(assignments: String) =
    stuff(assignments, ::doesContain)

fun numberOfOverlappingAssignments(assignments: String) =
    stuff(assignments, ::doesOverlap)

fun stuff(assignments: String, predicate: (IntRange, IntRange) -> Boolean) =
    assignments.split("\n").map { p -> p.split(",") }
        .map { p -> p.map { a -> a.split("-").map { r -> r.toInt() } } }
        .map { (a1, a2) -> predicate(a1[0]..a1[1], a2[0]..a2[1]) }
        .filter { t -> t }
        .size

fun doesContain(a1: IntRange, a2: IntRange) = a1.intersect(a2).size == minOf(a1.toList().size, a2.toList().size)

fun doesOverlap(a1: IntRange, a2: IntRange) = a1.intersect(a2).isNotEmpty()