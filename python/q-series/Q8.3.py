'''
Magic Index: A magic index in an array A[1 ... n-1] is defined to be an index such that A[i]=
i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
array A.
FOLLOW UP
What if the values are not distinct?
'''


def hasMagicIndex(array, min, max):

    mid = (min + max) / 2

    if array[mid] == mid:
        return mid
    elif array[mid] < mid:
        return hasMagicIndex(array, mid + 1, max)
    elif array[mid] > mid:
        return hasMagicIndex(array, min, mid - 1)


def generatedArray():

    array = [0] * 10
    array[0] = -14
    array[1] = -12
    array[2] = 0
    array[3] = 1
    array[4] = 2
    array[5] = 4
    array[6] = 6
    array[7] = 10
    array[8] = 23
    array[9] = 25

    return array

if __name__ == '__main__':

    array = generatedArray()
    print hasMagicIndex(array, 0, len(array)-1)
