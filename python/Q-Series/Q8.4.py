'''
Power Set: Write a method to return all subsets of a set.
'''


def getSubsets(setz, index):

    allSubsets = []
    if len(setz) == index:
        if [] not in allSubsets:
            allSubsets.append([])
    else:
        allSubsets = getSubsets(setz, index + 1)
        item = setz[index]
        moreSubsets = []
        for subset in allSubsets:
            newSubset = []
            [newSubset.append(value)
             for value in subset if value not in newSubset]
            newSubset.append(item)
            moreSubsets.append(newSubset)
        [allSubsets.append(value) for value in moreSubsets]

    return allSubsets


def getSubsets2(setz):

    allSubsets = []
    max = 1 << len(setz)
    for k in range(max):
        subset = convertIntforGet(setz, k)
        allSubsets.append(subset)
    return allSubsets


def convertIntforGet(setz, k):

    subset = []
    index = 0
    i = k
    while i > 0:
        if i & 1 == 1:
            subset.append(setz[index])
        index += 1
        i >>= 1
    return subset


if __name__ == '__main__':
    set = ([1, 2, 3])
    print getSubsets(set, 0)
    print getSubsets2(set)
