'''
Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.

'''
import unittest

def zero_martrix(marix):
    m=len(marix)
    n=len(marix[0])
    row=[]
    column=[]
    for i in range(m):
        for j in range(n):
            if marix[i][j]==0:
                row.append(i)
                column.append(j)
    for i in row:
        for j in range(n):
            marix[i][j]=0
    for i in column:
        for j in range(m):
            marix[j][i]=0
    return marix
class Test(unittest.TestCase):
    data1=[([
        [1,2,3,3,4],
        [5,6,0,7,8],
        [0,9,0,10,11],
        [12,13,14,15,16],
        [17,18,0,19,20],
        [21,22,23,24,25]
    ],[
        [0, 2, 0, 3, 4],
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0],
        [0, 13, 0, 15, 16],
        [0, 0, 0, 0, 0],
        [0, 22, 0, 24, 25]
    ]
)]

    def test(self):
        for test_marix ,expected in self.data:
            res=zero_martrix(test_marix)
            self.assertEqual(res,expected)

if __name__ == '__main__':
    unittest.main()
