import timeit
import time
import random
import json


class Test(object):
    def __init__(self):
        self.list1 = [1, 6, 3, 5, 2, 9, 7, 8]

    def mao_fun(self):
        list1 = self.list1.copy()
        for i in range(len(list1)):
            for j in range(i, len(list1)):
                if list1[i] > list1[j]:
                    list1[i], list1[j] = list1[j], list1[i]
        return list1

    def fast_fun(self):
        # 快排 原理就是先找一个基准值，比基准值小的放左边，比基准值大的放右边
        list1 = self.list1.copy()

        def compare(list1):
            if len(list1) >= 2:
                num = list1[len(list1)//2]
                left = []
                right = []
                list1.remove(num)
                for i in list1:
                    if i < num:
                        left.append(i)
                    else:
                        right.append(i)
                return compare(left) + [num] + compare(right)
            else:
                return list1
        return compare(list1)

    def insert_fun(self):
        list1 = self.list1.copy()
        # 插入排序的原理就是判断数据，比基准大的插右边，比基准小的放左边
        for i in range(1, len(list1)):
            j = i
            num = list1[i]
            while j > 0 and num < list1[j-1]:
                list1[j] = list1[j -1]
                j -= 1
            list1[j] = num
        return list1

    def xi_fun(self):
        list1 = self.list1.copy()
        # 希尔排序








test = Test()
print(test.mao_fun())
print(test.fast_fun())
print(test.insert_fun())

























