from django.test import TestCase

# Create your tests here.


# 数据结构和算法
# 实例化一个空列表，将0-n范围内的数据添加到排列表中
# 四种方法

# def test1():
#     list1 = []
#     for i in range(100000):
#         list1 += [i]
#     return list1
#
#
# def test2():
#     list1 = []
#     for i in range(100000):
#         list1.append(i)
#     return list1
#
#
# def test3():
#     list1 = [i for i in range(100000)]
#     return list1
#
#
# def test4():
#     list1 = list(range(100000))
#     return list1
#
#
# # 实例化一个栈
# class Stack():
#     def __init__(self):
#         self.items = []
#
#     # 进栈操作
#     def push(self, item):
#         self.items.append(item)
#     def pop(self):
#         # 默认移除最后一个元素
#         return self.items.pop()
#     def peek(self):
#         # 返回栈顶元素的下标
#         return len(self.items) - 1
#     def isEmpty(self):
#         # 判断是否为空
#         return self.items == []
#     def size(self):
#         # 返回栈中元素的数量
#         return len(self.items)
#
# # 实例化队列
#
# class Queue():
#     def __init__(self):
#         self.items = []
#
#     def enqueue(self, item):
#         # 在索引为0的位置插入，原来位置的元素往后顺移
#         self.items.insert(0, item)
#
#     def dequeue(self):
#         return self.items.pop()
#
#     def isEmpty(self):
#         # 判断是否为空
#         return self.items == []
#     def size(self):
#         # 返回栈中元素的数量
#         return len(self.items)
#
#
# # 烫手的山芋面试题
# kids = ['A', 'B', 'C', 'D', 'E', 'F']
#
# # 实现一个空队列
# queue = Queue()
# for kid in kids:
#     queue.enqueue(kid)   # A是队头， F是队尾
# # 传递山芋，循环
# while queue.size() > 1:
#     for i in range(6):
#         # 保证手里有山芋的在队头位置  出队列再入队列
#         kid = queue.dequeue()
#         queue.enqueue(kid)
#     # 循环完以后删除一下
#     queue.dequeue()
# print('获胜的选手是:', queue.dequeue())
#
# # 双端队列两个头部和尾部，可以在双端进行数据的插入和删除，提供了单数据
# # # 结构中栈和队列的特性
# class Deque():
#     def __init__(self):
#         self.items = []
#
#     def addFront(self, item):
#         self.items.insert(0, item)
#
#     def addRear(self, item):
#         self.items.append(item)
#
#     def removeFront(self):
#         return self.items.pop()
#
#     def removeRear(self):
#         return self.items.pop(0)
#
#     def isEmpty(self):
#         # 判断是否为空
#         return self.items == []
#     def size(self):
#         # 返回栈中元素的数量
#         return len(self.items)
#
# q = Deque()
# q.addFront(1)
# q.addFront(2)
# q.addFront(3)
# # 先进先出
# # print(q.removeFront())
# # print(q.removeFront())
# # print(q.removeFront())
# # 先进后出
# print(q.removeRear())
# print(q.removeRear())
# print(q.removeRear())



# 双端队列应用案例 回文检查
# 回文是一个字符串  读取首尾相同的字符
# radar   toot   madam
#
# def isHuiWen(s):
#
#     ex = True
#     q = Deque()
#     for ch in s:
#         q.addFront(ch)
#     while q.size() > 1:
#         if q.removeFront() != q.removeRear():
#             ex = False
#             break
#     return ex
# print(isHuiWen('hefgeh'))
#
# # timeit 模块
# from timeit import Timer
# if __name__ == '__main__':
    # 测试各个方法的运行效率
    # timer = Timer('test4()', 'from __main__ import test4')
    # t1 = timer.timeit(1000)
    # print(t1)
    #
    # timer = Timer('test1', 'from __main__ import test1')
    # t2 = timer.timeit(1000)
    # print(t1)
    #
    # timer = Timer('test3', 'from __main__ import test3')
    # t3 = timer.timeit(1000)
    # print(t3)
    #
    # timer = Timer('test2', 'from __main__ import test2')
    # t4 = timer.timeit(1000)
    # print(t4)

    # 栈的实现
    # stack = Stack()
    # stack.push(1)
    # stack.push(2)
    # stack.push(3)
    # print('栈顶元素下标', stack.peek())
    # print(stack.isEmpty())
    # print('元素个数', stack.size())
    # print(stack.pop())
    # print(stack.pop())
    # print(stack.pop())

    # q = Queue()
    # q.enqueue(1)
    # q.enqueue(2)
    # q.enqueue(3)
    # print(q.dequeue())
    # print(q.dequeue())
    # print(q.dequeue())


# 链表的实现
class Node():

    """
    这个类是对链表中每个元素对应的data部分和指针部分
    """

    def __init__(self, item):
        self.item = item
        self.next = None

# 整个链表的实现
class Link():
    def __init__(self):
        """
        # 构造一个空列表，head只能是第一个节点的地址
        """
        self._head = None

    # 向链表的头部添加元素
    def add(self, item):
        # 实例化一个元素
        node = Node(item)
        # 将新添加的元素的指针指向之前的head指向的地址
        node.next = self._head
        self._head = Node

    # 循环遍历整个链表
    def travel(self):
        # 确定循环次数用for,不确定用while
        # (_head在链表创建好之后，一定是不可变的 指向第一个地址)
        cur = self._head
        while cur:
            print(cur.item)
            cur = cur.next

    def is_empty(self):
        return self._head is None

    def size(self):
        cur = self._head
        count = 0
        while cur:
            count += 1
            cur = cur.next
        return count

    def append(self, item):
        # 向链表的尾部添加元素
        node = Node(item)
        # 特殊判断 如果链表为空
        if self._head is None:
            self._head = node
            return
        # cur是第一个元素， pre就是空  cur第二个 pre第一个
        # 循环到最后，pre是当前元素 cur指向None
        cur = self._head
        pre = None
        while cur:
            pre = cur
            cur = cur.next
        pre.next = node

    def search(self, item):
        # 在链表中的item寻找是否存在数据
        find = False
        cur = self._head
        while cur:
            if cur.item == item:
                find = True
                break
            cur = cur.next
        return find

    def insert(self, pos, item):
        # 向position位置插入item数据
        node = Node(item)
        cur = self._head
        for i in range(pos):
            pre = cur
            cur = cur.next
        pre.next = node
        node.next = cur

    def remove(self, item):
        # 删除指定节点
        cur = self._head
        pre = None
        if cur.item == item:
            self._head = cur.next
            return
        while cur:
            pre = cur
            cur = cur.next
            if cur.item == item:
                pre.next = cur.next
                return



link = Link()
link.append(1)












