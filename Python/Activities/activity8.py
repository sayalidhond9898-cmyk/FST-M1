listNum = list(map(int, input("Enter numbers separated by spaces: ").split()))
print ("Given list is ", listNum)
firstElem = listNum[0]
lastElem = listNum[-1]

if (firstElem == lastElem):
    print(True)
else:
    print(False)
