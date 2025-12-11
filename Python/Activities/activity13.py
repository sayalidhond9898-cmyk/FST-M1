def sum(num):
    sum = 0
    for num in num:
        sum = sum + num
    return sum
listNum = list(map(int, input("Enter numbers separated by spaces: ").split()))
print("Given list is ", listNum)
total = sum(listNum)
print("Sum of all elements in the list is:", total)