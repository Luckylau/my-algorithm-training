"""
Return Kth to Last: Implement an algorithm to fnd the kth to last element of a singly linked list
"""
from tools.LinkedList import LinkedList


def find_Kth_to_last(ll, k):
    current = runner = ll.head
    for i in range(k):
        if runner is None:
            return None
        runner = runner.next

    while runner:
        current = current.next
        runner = runner.next

    return current


ll = LinkedList()
ll.generate(10, 0, 99)
print ll
res = find_Kth_to_last(ll, 2)
print res
