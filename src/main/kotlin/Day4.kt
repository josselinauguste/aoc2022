fun numberOfOverlappingAssignments(assignments: String) =
    assignments.split("\n").map { p -> p.split(",") }
        .map { p -> p.map { a -> a.split("-").map { r -> r.toInt() } } }
        .map { (a1, a2) -> doesContains(a1[0]..a1[1], a2[0]..a2[1]) }
        .filter { t -> t }
        .size

fun doesContains(a1: IntRange, a2: IntRange) = a1.intersect(a2).size == minOf(a1.toList().size, a2.toList().size)
