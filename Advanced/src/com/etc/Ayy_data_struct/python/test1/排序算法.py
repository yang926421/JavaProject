class sort():
    list1 = [1, 4, 2, 5, 6, 7, 9, 3]

    def __init__(self):
        pass
        # self.list1 = [1, 4, 2, 8, 6, 7, 9，3]

    # 冒泡排序
    def mao(self):
        list1 = self.list1.copy()
        for i in range(len(list1)):
            for j in range(i, len(list1)):
                if list1[i] > list1[j]:
                    list1[i], list1[j] = list1[j], list1[i]
        print(list1)

    # 快排
    def kuai(self):
        """
        快排原理 就是先整一个中间数 把比它小的放左边，比它大的放右边
        """
        list2 = self.list1.copy()

        def compare(list2):
            if len(list2) >= 2:
                num = list2[len(list2)//2]
                left = []
                right = []
                list2.remove(num)
                for i in list2:
                    if i < num:
                        left.append(i)
                    else:
                        right.append(i)
                return compare(left) + [num] + compare(right)
            else:
                return list2
        list3 = compare(list2)
        print(list3)
        return list3

    # 插入排序
    def insert(self):
        list1 = self.list1.copy()
        for i in range(1, len(list1)):
            j = i
            num = list1[i]
            while j > 0 and num < list1[j - 1]:
                list1[j] = list1[j-1]
                j -= 1
            list1[j] = num
        print(list1)
        return list1

    # 希尔排序
    def xi_fun(self):
        list1 = self.list1.copy()
        gap = len(list1) // 2
        while gap >= 1:
            for i in range(gap, len(list1)):
                while i > 0 and list1[i] < list1[i-gap]:
                    list1[i], list1[i-gap] = list1[i-gap], list1[i]
                    i -= gap
            gap //= 2
        return list1
    # 就是在插入排序的基础上每次都将间隔//2
    def xi_fun1(self):
        list1 = self.list1.copy()
        gap = len(list1) // 2
        while gap >= 1:
            for i in range(gap, len(list1)):
                while i > 0 and list1[i] < list1[i-gap]:
                    list1[i], list1[i - gap] = list1[i - gap], list1[i]
                    i -= gap
            gap //= 2
        return



    # 选择排序
    """
    选择排序原理就是，找到乱序中的最大值，通过更改max等于最大值的下标
    来将最大值下标对应的元素放到最后一位  
    选择排序的交换是放在内层循环外面 所以复杂度要小于冒泡排序
    """
    def choice_fun(self):
        list1 = self.list1.copy()
        for i in range(len(list1)-1):
            max_index = 0
            for j in range(1, len(list1)-i):
                if list1[max_index] < list1[j]:
                    max_index = j
            list1[len(list1) - 1 - i], list1[max_index] = list1[max_index], list1[len(list1) -1 -i]
        return list1

    # 归并排序

    def back_fun(self):
        list1 = self.list1.copy()

        def asort(list1):
            if len(list1) <= 1:
                return list1
            num = len(list1) // 2
            left = asort(list1[0: num])
            right = asort(list1[num:])
            return bsort(left, right)

        def bsort(left, right):
            i, j = 0, 0
            extend1 = []
            while i < len(left) and j < len(right):
                if left[i] < right[j]:
                    extend1.append(left[i])
                    i += 1
                else:
                    extend1.append(right[j])
                    j += 1
            extend1 += left[i:]
            extend1 += right[j:]
            return extend1
        return asort(list1)




clc = sort()
# clc.kuai()
# clc.mao()
# clc.insert()
# print(clc.choice_fun())
# print(clc.xi_fun())
print(clc.back_fun())

a = 7


























































