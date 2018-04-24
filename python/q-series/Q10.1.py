'''
Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the
end to hold B. Write a method to merge B into A in sorted order.
'''


def MergeArray(A, B):

    index = len(A) - 1
    indexB = len(B) - 1
    indexA = index - indexB - 1

    while indexB >= 0:
        if indexA >= 0 and A[indexA] >= B[indexB]:
            A[index] = A[indexA]
            indexA -= 1
        else:
            A[index] = B[indexB]
            indexB -= 1
        index -= 1
    return A


def arrayA(length, buffer):

    A = [0] * (buffer + length)
    for i in range(length):
        A[i] = i * 2 + 2
    return A


def arrayB(length):

    B = [0] * length
    for i in range(length):
        B[i] = 1 + i * 2
    return B

if __name__ == '__main__':

    A = arrayA(5, 10)
    print A
    B = arrayB(10)
    print B
    print MergeArray(A, B)