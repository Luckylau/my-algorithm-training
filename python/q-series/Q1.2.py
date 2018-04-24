"""

Given two strings, write a method to decide if one is a permutation of the
other.


"""
import unittest
from collections import Counter


def check_premutation(string):
    str1 = string[0]
    str2 = string[1]
    if len(str1) != len(str2):
        return False
    counter = Counter()
    for c in str1:
        counter[c] += 1
    for c in str2:
        counter[c] -= 1
        if counter[c] != 0:
            return False
    return True


class Test(unittest.TestCase):
    data1 = [(['abcd', 'bcda']), (['erdf', 'rfde'])]
    data2 = [(['efsa', 'esag']), (['prfds', 'rfdasp'])]

    def test_premutation(self):
        for test_string in self.data1:
            res = check_premutation(test_string)
            self.assertTrue(res)
        for test_string in self.data2:
            res = check_premutation(test_string)
            self.assertFalse(res)

if __name__ == '__main__':
    unittest.main()
