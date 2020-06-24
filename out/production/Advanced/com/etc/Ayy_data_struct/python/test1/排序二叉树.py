# 乱序数据的插入的时候，需要遵循一个准则
# 后序插入的数值，如果比根节点小，插入根节点的左侧，否则插入到右侧

class Node():
    def __init__(self, item):
        self.item = item
        self.left = None
        self.right = None


class SortTree():
    def __init__(self):
        self.root = None

    def add(self, item):
        node = Node(item)
        if self.root is None:
            self.root = node
            return
        cur = self.root
        while cur:
            # 往右边插入
            if cur.item < item:
                if cur.right is None:
                    cur.right = node
                    break
                else:
                    cur = cur.right
            else:
                # 向左边插入
                if cur.left is None:
                    cur.left = node
                    break
                else:
                    cur = cur.left

    def fowoar(self, root):
        if self.root is None:
            return
        print(root.item)
        self.fowoar(root.left)
        self.fowoar(root.right)

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


tree = SortTree()
list1 = [3, 8, 5, 7, 6, 2, 9, 4, 1]
for i in list1:
    tree.add(i)
tree.middle(tree.root)
















