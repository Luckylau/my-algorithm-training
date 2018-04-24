'''
Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?

'''

'''
o(n) in time,n is the number of element in linklist
'''
from tools.LinkedList import LinkedList

def removeduplicate(linklist):
    if linklist.head is None:
        return -1

    current=linklist.head
    seen=set([current.value])

    while current.next:
        if current.next.value in seen :
            current.next=current.next.next
        else:
            seen.add(current.next.value)
            current=current.next
    return ll

'''
o(1) in space ,o(n^2) in time,not using a temporary buffer
'''

def removeduplicate_fllowup(linklist):
    if linklist.head is None:
        return -1
    current=linklist.head
    while current:
        runner = current
        while runner.next:
            if runner.next.value == current.value:
                runner.next = runner.next.next
            else:
                runner = runner.next
        current = current.next

    return ll.head


ll = LinkedList()
ll.generate(20, 0, 9)
print(ll)
removeduplicate_fllowup(ll)
print(ll)
