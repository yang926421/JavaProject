class Node():
    # 实例化一个节点类
    def __init__(self, item):
        self.item = item
        self.left = None
        self.right = None

class Tree():
    # 实例化一个二叉树
    def __init__(self):
        self.root = None

    #完全二叉树情况
    def add(self, item):
        # 向树中添加元素
        node = Node(item)
        if self.root is None:
            self.root = node
            return
        cur = self.root
        # 存的是所有节点
        q = [cur]
        while q:
            nd = q.pop(0)
            if nd.left is None:
                nd.left = node
                return
            else:
                q.append(nd.left)
            if nd.right is None:
                nd.right = node
                return
            else:
                q.append(nd.right)

    def travel(self):
        # 遍历二叉树（广度遍历）
        cur = self.root
        q = [cur]
        while q:
            nd = q.pop(0)
            print(nd.item)
            if nd.left:
                q.append(nd.left)
            if nd.right:
                q.append(nd.right)

    # 深度优先遍历
    """
        前序遍历   根左右
        中序遍历   左右根
        后序遍历    左根右
    """
    def forwoar(self, root):
        if root == None:
            return
        # 利用递归来前序遍历
        print(root.item)
        self.forwoar(root.left)
        self.forwoar(root.right)

    def middle(self, root):
        # 利用递归中序遍历
        if root is None:
            return
        self.middle(root.left)
        print(root.item)
        self.middle(root.right)

    def back(self, root):
        # 利用递归后续遍历
        if root is None:
            return
        self.back(root.left)
        self.back(root.right)
        print(root.item)






tree = Tree()
tree.add(1)
tree.add(2)
tree.add(3)
tree.add(4)
tree.add(5)
tree.add(6)
tree.add(7)

# tree.travel()
# tree.forwoar(tree.root)
tree.back(tree.root)
