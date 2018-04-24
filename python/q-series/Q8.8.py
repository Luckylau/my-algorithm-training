'''
Permutations with Duplicates: Write a method to compute all permutations of a string whose
characters are not necessarily unique.The list of permutations should not have duplicates
'''


def getParm2(str):

    permutations = []
    getParm2inner(" ", str, permutations)
    return permutations


def getParm2inner(prefix, remainder, permutations):

    if len(remainder) == 0:
        if prefix not in permutations:
            permutations.append(prefix)

    for i in range(len(remainder)):
        before = remainder[:i]
        char = remainder[i]
        after = remainder[i + 1:]
        getParm2inner(prefix + char, before + after, permutations)


def getParm(str):

    permutations = []
    dict = countCharnum(str)
    getParminner(" ", len(str), dict, permutations)
    return permutations


def countCharnum(str):
    dict = {}
    for char in str:
        if char not in dict:
            dict[char] = 0
        dict[char] += 1
    return dict


def getParminner(prefix, remainlength, dict, result):

    if remainlength == 0:
        result.append(prefix)
        return

    for char in dict:
        count = dict[char]
        if count > 0:
            dict[char] -= 1
            getParminner(prefix + char, remainlength - 1, dict, result)
            dict[char] = count


if __name__ == '__main__':

    str = "aabb"
    print getParm2(str)
    print getParm(str)
