import java.time.Instant
import java.time.temporal.ChronoUnit

fun Instant.millisDifference(end: Instant): Long =
    ChronoUnit.MILLIS.between(this, end)

fun jumpLines(l: Int) {
    for (i in 0..l) println()
}