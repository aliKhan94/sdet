print("Hello, World!")

x = 1
y = 2.3
z = 3j

print(type(x))
print(type(y))
print(type(z))

print('Hello')
print("Hello")

a = "Hello, World!"

print(a)
print(len(a))
print(a[3:len(a)])

b = a.replace("o","0")
print(b)
print(a.split(","))

txt = "The rain in Spain stays mainly in the plain"
x = "ain" in txt
y = "ain" not in txt
print(x) # True
print(y) # False


age = 36
txt = "My name is John, I am {}"
print(txt.format(age))


quantity = 3
itemno = 567
price = 49.95
myorder = "I want {} pieces of item {} for {} dollars."
print(myorder.format(quantity, itemno, price))

# Output: I want 3 pieces of item 567 for 49.95 dollars.

myorder = "I want {2} pieces of item {1} for {0} dollars."
print(myorder.format(price, itemno, quantity))

a = int(1)   	 # a will be 1
b = int(2.8)	 # b will be 2
c = int("3") 	 # c will be 3

x = float(1)     # x will be 1.0
y = float(2.8)   # y will be 2.8
z = float("3")   # z will be 3.0
w = float("4.2") # w will be 4.2

j = str("s1") 	 # j will be 's1'
k = str(2)    	 # k will be '2'
l = str(3.0)  	 # l will be '3.0' 

fruits = "apple is my favorite"
for fruit in fruits:
  print(fruit) 

x = range(6)
print(x)

for y in x:
    print(y)

name = "Ali"

print(name, 2)