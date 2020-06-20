# 使用列表来实现 斐波那契数列
list1 = [1, 1]
for i in range(10):
    list1.append(list1[-1] + list1[-2])
print(list1)


print(dict(zip()))