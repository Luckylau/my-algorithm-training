"""

Implement an algorithm to determine if a string has all unique characters.
What if you can not use additional data structures?


"""

import unittest


def unique(string):
    if len(string) > 128:
        return False
    char_set = [False for _ in range(128)]
    for char in string:
        val = ord(char)
        if char_set[val]:
            return False
        char_set[val] = True

    return True


class Test(unittest.TestCase):
    data1 = [('abcd'), ('s4fad'), ('')]
    data2 = [('edde'), ('=j6f d')]

    def test_unique(self):
        for test_string in self.data1:
            res = unique(test_string)
            self.assertTrue(res)
        for test_string in self.data2:
            res = unique(test_string)
            self.assertFalse(res)

if __name__ == "__main__":
    unittest.main()
