'''
Recursive Multiply: Write a recursive function to multiply two positive integers without using
the * operator (or / operator). You can use addition, subtraction, and bit shifting, but you should
minimize the number of those operations
'''


def Multiply(a, b, answer):

    if a <= 0 or b <= 0:
        return 'a,b is not positive integer'
    if a >= b:
        bigger = a
        smaller = b
    else:
        bigger = b
        smaller = a
    if answer == 0:
        answer = bigger
    if bigger == 1:
        return answer
    if smaller == 1:
        return answer
    else:
        answer += bigger
        return Multiply(bigger, smaller - 1, answer)

if __name__ == '__main__':

    print Multiply(1, 7, 0)
