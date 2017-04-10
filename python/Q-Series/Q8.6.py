#!/usr/bin/env python
#-*- coding: utf-8 -*-

'''
Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
diﬀerent sizes which can slide onto any tower. The puzzle starts with disks sorted inascendingorder
of size from top to bottom (i.e. each disk sits on top of an even larger one). You have the following
constraints:
(1) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto another tower.
(3) A disk cannot be placed on top of a smaller disk.
Write a program to move the disks from the frst tower to the last using Stacks

'''
import sys


class Multistacks:

    def __init__(self, stacksize):

        self.numstacks = 3
        self.array = [0] * (self.numstacks * stacksize)
        self.sizes = [0] * self.numstacks
        self.stacksize = stacksize

    def Push(self, item, stacknum):

        if self.Isfull(stacknum):
            raise Exception('%s is full' % stacknum)
        self.sizes[stacknum] += 1
        self.array[self.IndexOfTop(stacknum)] = item

    def Pop(self, stacknum):

        if self.Isempty(stacknum):
            raise Exception('%s is empty' % stacknum)

        item = self.array[self.IndexOfTop(stacknum)]
        self.array[self.IndexOfTop(stacknum)] = 0
        self.sizes[stacknum] -= 1
        return item

    def Isempty(self, stacknum):
        return self.sizes[stacknum] == 0

    def Isfull(self, stacknum):
        return self.sizes[stacknum] == self.stacksize

    def IndexOfTop(self, stacknum):
        offset = self.stacksize * stacknum
        return offset + self.sizes[stacknum] - 1

    def Size(self, stacknum):
        return self.sizes[stacknum]


def Tower(N):

    newstack = Multistacks(N)
    for i in range(N, 0, -1):
        newstack.Push(i, 0)
    return newstack


def operate(N, start, buff, end, stack):
    if N == 1:
        stack.Push(stack.Pop(start), end)
    else:
        operate(N - 1, start, end, buff, stack)
        operate(1, start, buff, end, stack)
        operate(N - 1, buff, start, end, stack)


def printTower(newStack, stacknum):

    if not newStack.Isempty(stacknum):
        for i in range(newStack.stacksize):
            print ''.join('-' for i in range(newStack.array[newStack.IndexOfTop(stacknum) - i]))

if __name__ == '__main__':

    N = 5
    tower = Tower(N)
    print 'Tower in 0'
    printTower(tower, 0)
    operate(N, 0, 1, 2, tower)
    print 'Tower in 2'
    printTower(tower, 2)
