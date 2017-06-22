'''
Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
steps at a time. Implement a method to count how many possible ways the child can run up the
stairs.
'''

'''
Time Limit Exceeded
'''


def TripleHop(n):

    if n < 0:
        return 0
    if n == 0:
        return 1
    if n == 1:
        return 1
    return TripleHop(n - 1) + TripleHop(n - 2) + TripleHop(n - 3)


def TripleHop2(n):
    if n < 0:
        return 0
    if n == 0 or n == 1:
        return 1
    if n == 2:
        return 2
    if n == 3:
        return 4
    result = [1, 2, 4]
    if n > 3:
        for i in range(n - 3):
            result.append(result[-1] + result[-2] + result[-3])
    return result[-1]

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
    print TripleHop2(1)
    print TripleHop2(2)
    print TripleHop2(3)
    print TripleHop2(4)
    print TripleHop2(5)
    print TripleHop2(6)
    print TripleHop2(7)
    print TripleHop2(8)
    print TripleHop2(9)
    print TripleHop2(10)
