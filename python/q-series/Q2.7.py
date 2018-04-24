"""
Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
intersecting node. Note that the intersection is defned based on reference, not value. That is, if the
kth node of the frst linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting.

"""
from tools.LinkedList import LinkedList
def intersection(ll_a,ll_b):
    if ll_a.tail is not ll_b.tail:
        return False
    longer=ll_a if len(ll_b)<len(ll_a) else ll_b
    shorter=ll_b if len(ll_b)<len(ll_a) else ll_a

    diff=len(longer)-len(shorter)

    shorter_node ,longer_node=shorter.head,longer.head
    for i in range(diff):
        longer_node=longer_node.next

    while shorter.node is not longer.node:
        shorter_node=shorter_node.next
        longer_node=longer_node.next
    return longer_node