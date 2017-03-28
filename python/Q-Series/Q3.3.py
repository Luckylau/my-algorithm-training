"""
Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks.push() and SetOfStacks. pop() should behave identically to a single stack
(that is, pop() should return the same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a specifc substack.
"""
import unittest


class SetOfStacks(object):

    def __init__(self, capacity):
        self.capacity = capacity
        self.stacks = []

    def is_empty(self):
        stack = self.get_last_stack()
        return not stack or stack.is_empty()

    def push(self, value):
        last = self.get_last_stack()
        if not last or last.is_full():
            stack = Stacks(self.capacity)
            stack.push(value)
            self.stacks.append(stack)
        else:
            last.push(value)
        return True

    def pop(self):
        last = self.get_last_stack()
        if not last:
            return None
        value = last.pop()
        if last.size == 0:
            del self.stacks[-1]
        return value

    def pop_at(self, index):
        return self.left_shift(index, True)

    def left_shift(self, index, remove_top):
        if index > len(self.stacks) - 1:
            print "list index out of range"
            return None
        stack = self.stacks[index]
        remove_item = stack.pop() if remove_top else stack.remove_from_bottom()
        if stack.is_empty():
            del self.stacks[index]
        elif len(self.stacks) > index + 1:
            v = self.left_shift(index + 1, False)
            stack.push(v)
        return remove_item

    def get_last_stack(self):
        if not self.stacks:
            return None
        return self.stacks[-1]


class Stacks(object):

    def __init__(self, capacity):

        self.capacity = capacity
        self.size = 0
        self.top = None
        self.bottom = None

    def is_full(self):

        return self.size == self.capacity

    def is_empty(self):

        return self.size == 0

    def push(self, value):

        if self.size >= self.capacity:
            return False
        self.size += 1
        n = Node(value)
        if self.size == 1:
            self.bottom = n
        self.join(n, self.top)
        self.top = n
        return True

    def pop(self):

        if not self.top:
            return None
        value = self.top.value
        self.top = self.top.below
        self.size -= 1
        return value

    def remove_from_bottom(self):
        b = self.bottom
        self.bottom = self.bottom.above
        if self.bottom:
            self.bottom.below = None
        self.size -= 1
        return b.value

    def join(self, above, below):

        if below:
            below.above = above
        if above:
            above.below = below


class Node(object):

    def __init__(self, value):
        self.value = value
        self.above = None
        self.below = None


class Tests(unittest.TestCase):

    def test_SetOfStacks(self):
        stacks = SetOfStacks(6)
        for _val in range(36):
            stacks.push(_val)
        lst = []
        for _ in range(30):
            lst.append(stacks.pop())
        self.assertEqual(lst, list(reversed(range(6, 36))))

    def test_pop_at(self):
        stacks = SetOfStacks(6)
        for _val in range(36):
            stacks.push(_val)
        lst = []
        for _ in range(24):
            lst.append(stacks.pop_at(2))
        self.assertEqual(lst,
                         [17,
                          18,
                          19,
                          20,
                          21,
                          22,
                          23,
                          24,
                          25,
                          26,
                          27,
                          28,
                          29,
                          30,
                          31,
                          32,
                          33,
                          34,
                          35,
                          16,
                          15,
                          14,
                          13,
                          12])


if __name__ == '__main__':
    unittest.main()

