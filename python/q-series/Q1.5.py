'''

There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.

'''

import unittest


def check_edits(str1, str2):
    if len(str1) == len(str2):
        return edit_replace(str1, str2)
    elif len(str1) + 1 == len(str2):
        return edit_insert(str1, str2)
    elif len(str1) - 1 == len(str2):
        return edit_insert(str2, str1)
    else:
        return False


def edit_replace(str1, str2):
    edited = False
    for c1, c2 in zip(str1, str2):
        if c1 != c2:
            if edited:
                return False
            edited = True
    return True


def edit_insert(str1, str2):
    edited = False
    i, j = 0, 0
    while i < len(str1) and j < len(str2):
        if str1[i] != str2[j]:
            if edited:
                return False
            edited = True
            j += 1
        else:
            i += 1
            j += 1
    return True


class Test(unittest.TestCase):
    data = [('i', 'ih', True),
            ('have', 'ave', True),
            ('apple', 'apples', True),
            ('i', 'll', False),
            ('have', 'has', False),
            ('pen', 'pepy', False)]

    def test(self):
        for test_str1, test_str2, expected in self.data:
            res = check_edits(test_str1, test_str2)
            self.assertEqual(res, expected)

if __name__ == '__main__':
    unittest.main()
