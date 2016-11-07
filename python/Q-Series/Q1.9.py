'''
Assume you have a method isSubstring which checks if one word is a substring
of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
call to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").

Email:laujunbupt0913@163.com
'''
import unittest


def isSubstring(str1, str2):
    if len(str1) == len(str2) != 0:
        if (str1 + str1).find(str2) != -1:
            return True
    else:
        return False


class Test(unittest.TestCase):
    data = [('ilovepython', 'ovepythonil'), ('ihaveapple', 'appleihave')]

    def test(self):
        for test_str1, test_str2 in self.data:
            res = isSubstring(test_str1, test_str2)
            self.assertTrue(res)

if __name__ == '__main__':
    unittest.main()
