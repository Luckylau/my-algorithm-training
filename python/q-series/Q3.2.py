'''
Stack Min: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time.
'''
import sys


class Multi_stack():

    def __init__(self, stacksize):
        self.numstack = 1
        self.stacksize = stacksize
        self.array = [0] * (stacksize * self.numstack)
        self.sizes = [0] * self.numstack
        self.Mins = [sys.maxsize] * (stacksize * self.numstack)

    def Push(self, item, stacknum):
        if self.Isfull(stacknum):
            raise Exception("stack is full !")
        self.sizes[stacknum] += 1
        if self.Isempty(stacknum):
            self.Mins[self.IndexofTop(stacknum)] = item
        else:
            self.Mins[self.IndexofTop(stacknum)] = min(
                item, self.Mins[self.IndexofTop(stacknum) - 1]
            )
        self.array[self.IndexofTop(stacknum)] = item

    def Pop(self, stacknum):
        if self.Isempty(stacknum):
            raise Exception("stack is empty !")
        value = self.array[self.IndexofTop(stacknum)]
        self.array[self.IndexofTop(stacknum)] = 0
        self.sizes[stacknum] -= 1
        return value

    def Peak(self, stacknum):
        if self.Isempty(stacknum):
            raise Exception("stack is empty !")
        return self.array[self.IndexofTop(stacknum)]

    def Min(self, stacknum):
        return self.Mins[self.IndexofTop(stacknum)]

    def Isempty(self, stacknum):
        return self.sizes[stacknum] == 0

    def Isfull(self, stacknum):
        return self.sizes[stacknum] == self.stacksize

    def IndexofTop(self, stacknum):
        offset = stacknum * self.stacksize
        return offset + self.sizes[stacknum] - 1

newstack=Multi_stack(5)
print newstack.Min(0)
newstack.Push(32,0)
print newstack.Min(0)
newstack.Push(2,0)
print newstack.Min(0)
newstack.Push(4,0)
print newstack.Min(0)
newstack.Push(1,0)
print newstack.Min(0)
newstack.Pop(0)
print newstack.Min(0)