'''
Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
The robot can only move in two directions, right and down, but certain cells are "off limits"such that
the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
the bottom right
'''

'''
solution 1
'''
def getPath(maze):
    if len(maze)==0 or maze==None:
        return None

    path=[]
    if hasPath(maze,len(maze)-1,len(maze[0])-1,path):
        return path
    return None

def hasPath(maze,row,col,path):

    if row<0 or col<0 or not maze[row][col]:
        return False

    isAtorigin=(row==0 ) and (col ==0)
    if isAtorigin or hasPath(maze,row-1,col,path) or hasPath(maze,row, col-1,path):
        point=(row,col)
        path.append(point)
        return True
    return False

'''
solution 2
'''

def getPathwithMemory(maze):

    if maze==None or len(maze)==0:
        return None
    path=[]
    failedpoint=[]
    if hasPathwithMemory(maze,len(maze)-1,len(maze[0])-1,path,failedpoint):
        return path
    return None

def hasPathwithMemory(maze, row, col, path, failedPoints):

    if row<0 or col<0 or not maze[row][col]:
        return False

    point=(row,col)

    if point in failedPoints:
        return False

    isAtorigin = (row == 0) and (col == 0)
    if isAtorigin or hasPathwithMemory(maze,row-1,col,path,failedPoints) or hasPathwithMemory(maze,row,col-1,path,failedPoints):
        path.append(point)
        return True
    failedPoints.append(point)
    return False



if __name__ == '__main__':
    maze=[[True,True,False],[False,True,True],[False,False,True]]
    print getPath(maze=maze)
    print getPathwithMemory(maze=maze)
