listOne = [12, 24, 35, 24, 88, 120, 155, 88, 120, 155]
listTwo = [12, 24, 35, 24, 88, 120, 155]

print("list one:", listOne)
print("list two:", listTwo)

thirdList = []

for item in listOne:
    if (item % 2 != 0):
        thirdList.append(item)  

for item in listTwo:
    if(item % 2 ==0):
        thirdList.append(item)

print("Result", thirdList)