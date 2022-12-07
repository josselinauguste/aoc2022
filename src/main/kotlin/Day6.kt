fun charsProcessedToGetStartOfPacket(input: String, packetLength: Int = 4) = input.windowed(packetLength)
    .indexOfFirst { window -> window.all { char1 -> window.count { char2 -> char2 == char1 } == 1 } } + packetLength

fun charsProcessedToGetStartOfMessage(input: String) = charsProcessedToGetStartOfPacket(input, 14)
