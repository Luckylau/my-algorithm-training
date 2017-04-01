'''
Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
steps at a time. Implement a method to count how many possible ways the child can run up the
stairs.
'''


def TripleHop(n):

    if n < 0:
        return 0
    if n == 0:
        return 1
    if n == 1:
        return 1
    return TripleHop(n - 1) + TripleHop(n - 2) + TripleHop(n - 3)

if __name__ == '__main__':
    print TripleHop(1)
    print TripleHop(2)
    print TripleHop(3)
    print TripleHop(4)
    print TripleHop(5)
    print TripleHop(6)
    print TripleHop(7)
    print TripleHop(8)
    print TripleHop(9)
    print TripleHop(10)