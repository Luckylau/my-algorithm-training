"""
Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
algorithm to create a binary search tree with minimal height.
"""


class Node(object):

    def __init__(self, item):
        self.left = None
        self.right = None
        self.val = item

    def __str__(self):
        return '(' + str(self.left) + ':L' + "  " + \
            str(self.val) + "  " + ' R:' + str(self.right) + ')'


def arraytoBinarysearchTree(array):

    return createbinarysearchtree(array, 0, len(array) - 1)


def createbinarysearchtree(array, start, end):

    if start > end:
        return ''
    mid = (start + end) / 2
    root = Node(array[mid])
    root.left = createbinarysearchtree(array, start, mid - 1)
    root.right = createbinarysearchtree(array, mid + 1, end)
    return root

if __name__ == '__main__':

    testarray = [1, 2, 3, 4, 5]
    print arraytoBinarysearchTree(testarray)
