def findRoots(at, cost):
	if len(children[at]) == 1:
		dest, add = children[at][0]
		return findRoots(dest, cost + add)
	global costNoTrees
	costNoTrees += cost
	if children[at]:
		trees.append([at, 0, 0])
		calcVisits(at)


def calcVisits(at):
	for dest, _ in children[at]:
		calcVisits(dest)
		visits[at] += visits[dest]
	visits[at] = max(visits[at], 1)


def calcRootDist(at=0):
	for dest, add in children[at]:
		rootDist[dest] = rootDist[at] + add
		calcRootDist(dest)


def calcCanSave(at):
	ret = 0
	delta = 0
	for dest, cost in children[at]:
		saveMain = (visits[dest] - 1) * parentCost[dest] + calcCanSave(dest)
		saveAlt = max(0, saveMain - rootDist[at])
		if saveMain - saveAlt > delta:
			ret += saveMain - delta
			delta = saveMain - saveAlt
		else:
			ret += saveAlt
	return ret


input = __import__("sys").stdin.readline
__import__("sys").setrecursionlimit(2147483647)
n = int(input())
children = __import__("collections").defaultdict(list)
parentCost = {}
for _ in xrange(n - 1):
	u, v, t = map(int, input().split())
	children[u - 1].append((v - 1, t))
	parentCost[v - 1] = t
costNoTrees = 0
trees = []
visits = [0] * n
for child in children[0]:
	findRoots(*child)
calcTreeCost = lambda at: sum(visits[dest] * add + calcTreeCost(dest) for dest, add in children[at])
for tree in trees:
	tree[1] = calcTreeCost(tree[0])
rootDist = [0] * n
calcRootDist()
for tree in trees:
	tree[2] = calcCanSave(tree[0])
print(costNoTrees + sum(treeCost - canSave for _, treeCost, canSave in trees))