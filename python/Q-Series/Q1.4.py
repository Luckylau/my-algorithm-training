'''

Given a string, write a function to check if it is a permutation of
a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
permutation is a rearrangement of letters. The palindrome does not need to be limited to just
dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat"; "atc o eta"; etc.)

'''

import unittest


def check_permutation(string):
    table = [0 for _ in range(ord('z') - ord('a') + 1)]
    countodd = 0
    for c in string:
        x = char_number(c)
        if x != -1:
            table[x] += 1
            if table[x] % 2:
                countodd += 1
            else:
                countodd -= 1
    return countodd <= 1


def char_number(char):
    if 'a' <= char <= 'z':
        return ord(char) - ord('a')
    elif 'A' <= char <= 'Z':
        return ord(char) - ord('A')
    return -1


class Test(unittest.TestCase):
    data = [('luckylau', False), ('to be good man', False),
            ('i love you you love i', True), ('miaomiao', True)]

    def test(self):
        for test_string, expected in self.data:
            res = check_permutation(test_string)
            self.assertEqual(res, expected)
