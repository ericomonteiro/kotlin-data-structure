import java.time.Instant.now
import java.util.LinkedList
import java.util.UUID

const val quantityOfItems = 9999999

/*
* ArrayList
*   is an implementation of the List interface that is based on an array. ArrayList internally handles resizing of
*   this array when the elements are added or removed. You can access its elements in constant time by their index in
*   the array. However, inserting or removing an element infers shifting all consequent elements which may be slow if the
*   array is huge and the inserted or removed element is close to the beginning of the list.
*
* LinkedList
*   is a doubly-linked list: single elements are put into Node objects that have references to previous and
*   next Node. This implementation may appear more efficient than ArrayList if you have lots of insertions or deletions in
*   different parts of the list, especially if the list is large.
*
*  In most cases, however, ArrayList outperforms LinkedList. Even elements shifting in ArrayList, while being an O(n)
*  operation, is implemented as a very fast System.arraycopy() call. It can even appear faster than the LinkedList‘s O(1)
*  insertion which requires instantiating a Node object and updating multiple references under the hood. LinkedList
*  also can have a large memory overhead due to a creation of multiple small Node objects.
* */


fun main() {
    val simulatedArrayList = ArrayList<UUID>()
    val simulatedLinkedList = LinkedList<UUID>()

    println("*** star to process LinkedList ***")
    simulate(simulatedLinkedList)

    println("*** star to process ArrayList ***")
    simulate(simulatedArrayList)

}


fun simulate(l: MutableList<UUID>) {

    val funStarted = now()
    var subFunStarted = now()

    val toRemove = mutableListOf<UUID>()

    for (i in 1..quantityOfItems) {
        val uuid = UUID.randomUUID()
        l.add(uuid)

        if (i < 5000) {
            toRemove.add(uuid)
        }

    }
    println("time to add ${l.size} items: ${subFunStarted.millisDifference(now())}")

    println("starting to remove")
    subFunStarted = now()
    for (item in toRemove) {
        l.remove(item)
    }
    println("time to remove ${toRemove.size} items in beginning of list: ${subFunStarted.millisDifference(now())}")
    println("total time: ${funStarted.millisDifference(now())}")

    println("*** end to process ***")
    jumpLines(2)
}