"""
Three in One: Describe how you could use a single array to implement three stacks.
"""


class Multi_stacks():

    def __init__(self, stacksize):
        self.numberstack = 3
        self.array = [0] * (stacksize * self.numberstack)
        self.size = [0] * self.numberstack
        self.stacksize = stacksize

    def Push(self, numstack, item):
        if self.Isfull(numstack):
            raise Exception("Stack is full")
        self.size[numstack]+=1
        self.array[self.IndexofTop(numstack)] = item

    def Pop(self, numstack):
        if self.Isempty(numstack):
            raise Exception("Stack is empty")
        self.size[numstack] -= 1
        value = self.array[self.IndexofTop(numstack)]
        self.array[self.IndexofTop(numstack)] = 0
        return value

    def Peek(self, numstack):
        if self.Isempty(numstack):
            raise Exception("Stack is empty")
        value = self.array[self.IndexofTop(numstack)]
        return value

    def Isfull(self, numstack):
        return self.size[numstack] == self.stacksize

    def Isempty(self, numstack):
        return self.size[numstack] == 0

    def IndexofTop(self, numstack):
        offset = numstack * self.stacksize
        return offset + self.size[numstack] - 1


def Three_in_one():
    stack = Multi_stacks(2)
    stack.Push(1, 23)
    print stack.Peek(1)
    print stack.Pop(1)
    stack.Push(1, 24)
    stack.Push(1, 25)
    stack.Push(1, 26)

Three_in_one()
