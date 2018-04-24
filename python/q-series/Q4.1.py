"""
Given a directed graph, design an algorithm to find out whether there is a
route between two nodes.

"""
import Queue


class Graph(object):

    def __init__(self, max_vertice):

        self.max_vertice = max_vertice
        self.vertices = [0] * self.max_vertice
        self.count = 0

    def add_node(self, x):

        if self.count < self.max_vertice:
            self.vertices[self.count] = x
            self.count += 1
        else:
            print 'Graph full'

    def get_node(self):
        return self.vertices


class Node(object):

    def __init__(self, vertex, adjacentLength):

        self.vertex = vertex
        self.adjacent = [0] * adjacentLength
        self.adjacentCount = 0
        self.visited = False

    def add_adjacent(self, x):

        if self.adjacentCount < len(self.adjacent):
            self.adjacent[self.adjacentCount] = x
            self.adjacentCount += 1
        else:
            print 'Node adjacent full'

    def get_adjacent(self):

        return self.adjacent

    def get_vertex(self):

        return self.vertex


def breadthfirstsearch(Graph, start, end):

    if start == end:
        return True
    queue = Queue.Queue(len(Graph.get_node()))
    queue.put(start)
    start.visited = True
    while not queue.empty():
        item = queue.get()
        if item is not None:
            adjacent = item.get_adjacent()
            for i in range(len(adjacent)):
                if adjacent[i].visited == False:
                    if adjacent[i] == end:
                        return True
                    else:
                        queue.put(adjacent[i])
                adjacent[i].visited = True

    return False


def createNewGraph():

    max_vertice = 7
    graph = Graph(max_vertice)
    nodes = [0] * max_vertice

    nodes[0] = Node('a', 3)
    nodes[1] = Node('b', 0)
    nodes[2] = Node('c', 0)
    nodes[3] = Node('d', 1)
    nodes[4] = Node('e', 2)
    nodes[5] = Node('f', 0)
    nodes[6] = Node('g', 0)

    nodes[0].add_adjacent(nodes[1])
    nodes[0].add_adjacent(nodes[2])
    nodes[0].add_adjacent(nodes[3])
    nodes[3].add_adjacent(nodes[1])
    nodes[4].add_adjacent(nodes[5])
    nodes[4].add_adjacent(nodes[6])

    for i in range(max_vertice):
        graph.add_node(nodes[i])

    return graph


def createNewGraphwithLoop():
    max_vertice = 7
    graph = Graph(max_vertice)
    nodes = [0] * max_vertice

    nodes[0] = Node('a', 1)
    nodes[1] = Node('b', 2)
    nodes[2] = Node('c', 1)
    nodes[3] = Node('d', 1)
    nodes[4] = Node('e', 1)
    nodes[5] = Node('f', 1)
    nodes[6] = Node('g', 1)

    nodes[0].add_adjacent(nodes[1])
    nodes[1].add_adjacent(nodes[2])
    nodes[1].add_adjacent(nodes[4])
    nodes[2].add_adjacent(nodes[3])
    nodes[3].add_adjacent(nodes[4])
    nodes[4].add_adjacent(nodes[5])
    nodes[5].add_adjacent(nodes[6])
    nodes[6].add_adjacent(nodes[4])

    for i in range(max_vertice):
        graph.add_node(nodes[i])

    return graph

if __name__ == '__main__':

    g = createNewGraphwithLoop()
    n = g.get_node()
    start = n[0]
    end = n[4]
    print "Start at:", start.get_vertex(), "End at: ", end.get_vertex()
    print breadthfirstsearch(g, start, end)
