user_input = input("Enter numbers separated by spaces: ")


user_list = list(map(int, user_input.split()))


user_total = sum(user_list)
print("The sum of your list is:", user_total)