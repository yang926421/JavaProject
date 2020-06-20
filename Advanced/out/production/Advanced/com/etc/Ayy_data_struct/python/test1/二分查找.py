# 二分查找的针对性比较强，主要是已经排好序的元素

list1 = [1, 3, 4, 6, 7, 8, 9, 56, 78]


def find(list1, item, start=0, end=None):
    end = end if end else len(list1) - 1
    mid = (end - start) // 2 + start
    if item < list1[mid]:
        find(list1, item, start=0, end=mid)
    if item > list1[mid]:
        find(list1, item, start=mid + 1, end=end)
    else:
        print('找到了:', mid)
find(list1, 9, start=0, end=None)

















































