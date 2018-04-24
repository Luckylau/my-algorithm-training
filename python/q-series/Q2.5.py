"""
Sum Lists: You have two numbers represented by a linked list,where each node contains a single
digit. The digits are stored in reverse order,such that the 1's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
Output: 2 -> 1 -> 9.That is,912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
Output: 9 -> 1 -> 2.That is, 912.
"""
from tools.LinkedList import LinkedList


def sum_list(ll_a, ll_b):
    ll = LinkedList()
    revel = 0
    n1 = ll_a.head
    n2 = ll_b.head
    while n1 or n2:
        result = revel
        if n1:
            result += n1.value
            n1 = n1.next
        if n2:
            result += n2.value
            n2 = n2.next

        ll.add(result % 10)
        revel = result // 10
    if revel:
        ll.add(revel)
    return ll


def sum_list_followup(ll_a, ll_b):

    if ll_a.__len__() > ll_b.__len__():
        for i in range(ll_a.__len__() - ll_b.__len__()):
            ll_b.add_to_beginning(0)
    elif ll_a.__len__() < ll_b.__len__():
        for i in range(ll_b.__len__() - ll_a.__len__()):
            ll_a.add_to_beginning(0)

    result = 0
    n1, n2 = ll_a.head, ll_b.head

    while n1 and n2:
        result = (result * 10) + n1.value + n2.value
        n1 = n1.next
        n2 = n2.next
    ll = LinkedList()
    ll.add_multiple([int(i) for i in str(result)])

    return ll

ll_a = LinkedList()
ll_a.generate(3, 0, 9)
ll_b = LinkedList()
ll_b.generate(5, 0, 9)
print ll_a
print ll_b
print
print (sum_list(ll_a, ll_b))
print (sum_list_followup(ll_a, ll_b))
