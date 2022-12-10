fun totalSizeOfDirectories(stdout: String, atMost: Int = 100000) =
    getFolderSizes(parseOutput(stdout)).filter { s -> s <= atMost }.sum()

fun sizeOfDeletedDirectory(stdout: String): Int {
    val folderSizes = getFolderSizes(parseOutput(stdout))
    val neededSpace = 30000000 - (70000000 - folderSizes.max())
    return folderSizes.filter { s -> s >= neededSpace }.minOf { it }
}

fun getFolderSizes(fs: FS): List<Int> {
    val folders = mutableListOf<Int>()

    fun folderSize(node: FS): Int {
        var size = node.size
        if (node.children.size > 0) {
            for (child in node.children) {
                size += folderSize(child)
            }
            folders.add(size)
        }
        return size
    }

    folderSize(fs)

    return folders
}

class FS(val name: String, val size: Int, val parent: FS? = null) {
    val children: MutableList<FS> = mutableListOf()
}

val fileRegex = Regex("^(\\d+) ([\\w.]+)")
val changeDirectoryRegex = Regex("\\$ cd ([\\w.]+)")

fun parseOutput(stdout: String): FS {
    fun run(
        line: String,
        root: FS,
        currentDirectory: FS,
    ): FS {
        if (line == "$ cd /") {
            return root
        }
        if (line == "$ cd .." && currentDirectory.parent != null) {
            return currentDirectory.parent
        }
        val cdMatch = changeDirectoryRegex.matchEntire(line)
        if (cdMatch != null) {
            val node = FS(cdMatch.groupValues[1], 0, currentDirectory)
            currentDirectory.children.add(node)
            return node
        }
        if (line == "$ ls") {
            return currentDirectory
        }
        if (line.startsWith("dir")) {
            return currentDirectory
        }
        val fileMatch = fileRegex.matchEntire(line)
        if (fileMatch != null) {
            val node = FS(fileMatch.groupValues[2], fileMatch.groupValues[1].toInt(), currentDirectory)
            currentDirectory.children.add(node)
            return currentDirectory
        }
        throw Error("Unhandled command: $line")
    }

    return FS("/", 0).let { fs ->
        stdout.split("\n").fold(fs) { currentDirectory, line -> run(line, fs, currentDirectory) }.let { fs }
    }
}

