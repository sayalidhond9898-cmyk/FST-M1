fruits = {
    "apple": 2,
    "banana": 3,
    "orange": 1.5,

}
key_to_check = input("Enter the fruit you are looking for ")
if key_to_check in fruits:
    print("Yes,", key_to_check, "is present in the dictionary with price", fruits[key_to_check])
else:   
    print("No,", key_to_check, "is not present in the dictionary")