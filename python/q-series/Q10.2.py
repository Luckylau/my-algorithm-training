'''
Group Anagrams: Write a method to sort an array of strings so that all tne anagrnms are next to
each other
'''


def GroupAnagrams(anagrnms):

    groupanagrnms = {}
    for i in range(len(anagrnms)):
        word = ''.join(sorted(anagrnms[i].lower()))
        if word not in groupanagrnms:
            groupanagrnms.setdefault(word, [])
        groupanagrnms[word].append(anagrnms[i])
    keys = groupanagrnms.keys()
    index = 0
    for i in range(len(keys)):
        values = groupanagrnms.get(keys[i])
        for j in range(len(values)):
            anagrnms[index] = values[j]
            index += 1
    return anagrnms


def inital_anagrnms():

    strings = [0] * 8
    strings[0] = "abed"
    strings[1] = "later"
    strings[2] = "bead"
    strings[3] = "alert"
    strings[4] = "altered"
    strings[5] = "bade"
    strings[6] = "alter"
    strings[7] = "alerted"
    return strings


if __name__ == '__main__':

    strings = inital_anagrnms()
    print strings
    print GroupAnagrams(strings)
