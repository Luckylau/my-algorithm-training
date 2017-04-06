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


if __name__ == '__main__':
    set = ([1, 2, 3])
    print getSubsets(set, 0)
