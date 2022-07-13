import java.util.UUID

/*
* HashSet works with equals() and hashCode() method to check for duplicate element when you try to add an element.
*
* First compare the hashcode if it's the same execute the method equals to compare objects
* */

class FirstDummy(val value: String) {
    override fun toString(): String {
        return value
    }
}

data class SecondDummy(val value: String) {
    override fun toString(): String {
        return value
    }
}

class ThirdDummy(val value: String) {
    override fun toString(): String {
        return value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ThirdDummy

        return (value == other.value)
    }
}

class FourthDummy(val value: String) {
    override fun toString(): String {
        return value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FourthDummy

        return (value == other.value)
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}

fun main() {
    val firstSet = mutableSetOf<FirstDummy>()
    val secondSet = mutableSetOf<SecondDummy>()
    val thirdDummy = mutableSetOf<ThirdDummy>()
    val fourthDummy = mutableSetOf<FourthDummy>()

    val uuid = UUID.randomUUID().toString()

    println("set of first class")
    firstSet.add(FirstDummy(uuid))
    firstSet.add(FirstDummy(uuid))
    println(firstSet)
    println()

    println("set of second class")
    secondSet.add(SecondDummy(uuid))
    secondSet.add(SecondDummy(uuid))
    println(secondSet)
    println()

    println("set of third class")
    thirdDummy.add(ThirdDummy(uuid))
    thirdDummy.add(ThirdDummy(uuid))
    println(thirdDummy)
    println()

    println("set of fourth class")
    fourthDummy.add(FourthDummy(uuid))
    fourthDummy.add(FourthDummy(uuid))
    println(fourthDummy)
    println()

}
