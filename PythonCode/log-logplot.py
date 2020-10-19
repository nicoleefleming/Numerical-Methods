from matplotlib import pyplot as plt
import numpy as np
# initialize the exact value of the 2nd derivative
aval = 2.0
exactVal = -np.sin(aval)
# set up the arrays for plotting the log-log plot we need
x = []
y = []
# initialize the array for the increment size and error in the finite
# difference approximation
h = []
error = []
# append the initial increment with a starting value - in this case, 1.0
h.append(1.0)
# compute the difference quotient for the increment value
dfVal = ( np.cos(aval + h[0]) - np.cos(aval) ) / h[0]
error.append(np.abs(exactVal - dfVal))
# append the log-log point for plotting at the end
x.append(np.log(h[0]))
y.append(np.log(error[0]))
# print the exact value for sanity
print('The exact derivative value is: ', exactVal)
# set a loop counter
l=1
# the loop over ndiv increments
ndiv = 45
while l<45:
# append the next increment of h
  h.append(0.5 * h[l-1])
  # compute the numerator and denominator for the difference approximation
  # and compute the approximation from these
  numval = np.cos(aval+h[l])-np.cos(aval)
  denom = h[l]
  dfVal = numval / denom
  # compute the error in the approximation
  error.append(np.abs( dfVal - exactVal ))
  # append the log-log point to the arrays for plotting below
  x.append(np.log(h[l]))
  y.append(np.log(error[l]))
  # update the loop iterator
  l += 1
# set up a plot for the data generated
plt.title('Error in the Difference Quotient of the 2nd Derivative')
plt.xlabel('Increment Values of h')
plt.ylabel('Error in the Approximation')
plt.plot(x, y, label='Log-Log Plot of Error for cos(2.0)')
plt.legend()
plt.show()