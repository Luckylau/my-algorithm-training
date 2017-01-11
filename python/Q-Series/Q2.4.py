
'''
Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
before all nodes greater than or equal to x. If x is contained within the list the values of x only need
to be afer the elements less than x (see below). The partition element x can appear anywhere in the
"right partition"; it does not need to appear between the left and right partitions.
EXAMPLE
Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
Output: 3 -> 1 -> 2 -> 5-> 5 -> 8 -> 10
'''
from tools.LinkedList import LinkedList


def partition(ll, x):
    current = ll.tail = ll.head

    while current:
        nextnode = current.next
        current.next = None
        if current.value < x:
            current.next = ll.head
            ll.head = current
        else:
            ll.tail.next = current
            ll.tail = current
        current = nextnode

    if ll.tail.next is not None:
        ll.tail.next = None

ll = LinkedList()
ll.add_multiple([1, 2, 4, 3])
print ll
partition(ll, 6)
print ll
