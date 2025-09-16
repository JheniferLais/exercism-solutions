class Deque<T> {
   private data class Node<T>(
        var value: T,
        var previous: Node<T>? = null,
        var next: Node<T>? = null
    )

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var length = 0

    fun push(value: T) {
        val newNode = Node(value, previous = tail, next = null)
        if (tail == null) {
            head = newNode
        } else {
            tail!!.next = newNode
        }
        tail = newNode
        length++
    }

    fun pop(): T? {
        val lastNode = tail ?: return null
        val previousNode = lastNode.previous

        tail = previousNode
        if (previousNode == null) {
            head = null
        } else {
            previousNode.next = null
        }

        length--
        return lastNode.value
    }

    fun unshift(value: T) {
        val newNode = Node(value, previous = null, next = head)
        if (head == null) {
            tail = newNode
        } else {
            head!!.previous = newNode
        }
        head = newNode
        length++
    }

    fun shift(): T? {
        val firstNode = head ?: return null
        val nextNode = firstNode.next

        head = nextNode
        if (nextNode == null) {
            tail = null
        } else {
            nextNode.previous = null
        }

        length--
        return firstNode.value
    }
}
