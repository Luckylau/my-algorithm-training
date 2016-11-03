'''

Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).

'''
import unittest


def compression(string):
    counter = 0
    compress = []
    for i in range(len(string)):
        if i != 0 and string[i] != string[i - 1]:
            compress.append(string[i - 1] + str(counter))
            counter = 0
        counter += 1

    compress.append(string[-1] + str(counter))
    return min(string, ''.join(compress), key=len)


class Test(unittest.TestCase):
    data = [
        ('ihaveannnnnappleihaveeeeeeeeeeeeeeeeeeeeeanppppen',
         'i1h1a1v1e1a1n5a1p2l1e1i1h1a1v1e21a1n1p4e1n1'),
        ('ihaveappleihavepen',
         'ihaveappleihavepen')]

    def test(self):
        for test_string, expected in self.data:
            res = compression(test_string)
            self.assertEqual(res, expected)
if __name__ == '__main__':
    unittest.main()
