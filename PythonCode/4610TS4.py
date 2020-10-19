import matplotlib.pyplot as mpl
import numpy as np

def plot2D(*args):
    mpl.grid(1)
    xAxis = np.arange(args[1],args[2],args[3])

    def xfunction(x,input):
        return eval(input)
    print(xfunction(5,args[0]))
    mpl.plot(xAxis, xfunction(xAxis, args[0]), label=args[0])
    mpl.xlabel("Values of input X")
    mpl.ylabel("Values of Output Y")


# creating an empty list
lst = []

# number of elemetns as input
n = int(input("Enter number of elements : "))

# iterating till the range
for i in range(0, n):
    ele = str(input())
    lst.append(ele)  # adding the element
print(lst)

n = len(lst)

for a in range(0, n):
    i = a
    plot2D(lst[i], -10, 10, 1)
mpl.legend(loc="upper left")
mpl.show()

