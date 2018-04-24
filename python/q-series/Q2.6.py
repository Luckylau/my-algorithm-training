"""
Palindrome: Implement a function to check if a linked list is a palindrome.
"""
from tools.LinkedList import LinkedList
def check_palindrome(ll):
    slow=fast=ll.head
    stack=[]
    while fast and fast.next:
        stack.append(slow.value)
        slow=slow.next
        fast=fast.next.next
    if fast:
        slow=slow.next

    while slow:
        top=stack.pop()
        if slow.value != top:
            return False
        slow=slow.next
    return True

ll=LinkedList([1,2,3,2,1])
print (check_palindrome(ll))

ll=LinkedList([1,2,3,4,5])
print (check_palindrome(ll))