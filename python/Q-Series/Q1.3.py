"""
Write a method to replace all spaces in a string with '%20'.
EXAMPLE
Input: "Mr John Smith "
Output: "Mr%20John%20Smith%20"

Writen by luckylau
Email:<laujunbupt0913@163.com>
"""
import unittest


def replace(str):
    length = len(str)
    string = list(str)
    counter = 0
    for i in range(length):
        if string[i] == ' ':
            counter += 1
    new_len = length + counter * 2
    new_str = [0] * new_len
    for i in reversed(range(length)):
        if string[i] == ' ':
            new_str[new_len - 3:new_len] = '%20'
            new_len -= 3
        else:
            new_str[new_len - 1] = string[i]
            new_len -= 1
    return ''.join(new_str)


class Test(unittest.TestCase):
    data = [(('i love  python '), ('i%20love%20%20python%20')), ((
        'python  make me  happy  '), ('python%20%20make%20me%20%20happy%20%20'))]

    def test_replace(self):
        for (test_string, expected) in self.data:
            res = replace(test_string)
            self.assertEqual(res, expected)

if __name__ == '__main__':
    unittest.main()
