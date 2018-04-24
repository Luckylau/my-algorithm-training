"""
Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
as to make a loop in the linked list.
EXAMPLE
Input:
Output:
SOLUTION
A - > B - > C - > D - > E - > C [the same C as earlier]
C
"""

def return_cirular_start(ll):
    fast=slow=ll.head

    while fast and fast.next and fast is not slow:
        fast=fast.next.next
        slow=slow.next

    while fast or fast.next is None:
        return False

    slow=ll.head

    while fast is not slow:
        fast=fast.next
        slow=slow.next

    return fast
