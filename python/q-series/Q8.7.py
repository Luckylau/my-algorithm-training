'''
Permutations without Dups: Write a method to compute all permutations of a string of unique
characters.
'''


def getPerm(str):

    permutations = []
    if str is None:
        return None
    if len(str) == 0:
        permutations.append(' ')
        return permutations

    first = str[0]
    remainder = str[1:]
    letters = getPerm(remainder)
    for letter in letters:
        for index in range(len(letter)):
            newletter = insertChar(letter, first, index)
            permutations.append(newletter)
    return permutations


def insertChar(letter, char, index):
    start = letter[:index]
    end = letter[index:]
    return start + char + end


def getParm2(str):

    permutations = []
    getParm2inner(" ", str, permutations)
    return permutations


def getParm2inner(prefix, remainder, permutations):

    if len(remainder) == 0:
        permutations.append(prefix)

    for i in range(len(remainder)):
        before = remainder[:i]
        char = remainder[i]
        after = remainder[i + 1:]
        getParm2inner(prefix + char, before + after, permutations)


if __name__ == '__main__':
    str = "abc"
    print getPerm(str)
    print getParm2(str)
