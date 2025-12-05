num_tuple = tuple(map(int, input("Enter numbers separated by spaces: ").split()))
#num_tuple = (1, 2, 3, 4, 5)
print("Original tuple:", num_tuple)

print("Elements divisible by 5")
for num in num_tuple:
    if num % 5 == 0:
        print(num)
