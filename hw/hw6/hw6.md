# Math 4610 Tasksheet 5

## Task 1
In this problem consider the function
                  f(x)=e^(−x^2) sin(4x^2−1.0)+0.051
Try all four methods for finding roots that you have developed. Start by computing the closest root to zero. Hint: Start with Bisection on a small interval around x∗=0.0 to bracket the root and then apply the other methods to verify they work. Write a code that is linked to your shared library, jar-file, or python module folder.
## Response

## Sources
[]()

[]()

[]()

## Task 2
Apply your Newton method to the function in Task 1 by starting 
x0=−5.0 and x0=6. If we want the root closest to zero, as in Task1, compare the results obtained to the root we found in the previous Task. What went right or wrong?
## Response

	

## Sources
[]()

[]()

[]()

## Task 3
Come up with an algorithm that starts by applying something like a hybrid method starting with an initial interval, 
[−5,6], that will find the closest root to zero. Hint: you will need to modify the logic a little in the Bisection part to avoid finding different zeros than the one found in Task 1.
## Response

## Sources
[]()

[]()

## Task 4
Repeat Task 3 for the hybrid method using the secant method. Use the results to verify the results in Task 3.
## Response



## Sources
[]()

[]()

## Task 5
Let's change the problem a bit. Use your hybrid code to find as many roots as possible in the interval, [−5,6]. Note that you will need to write a bit of logic into your code that breaks the interval into intervals acceptable for use of the Bisection method. Hint: Write code that will produce subintervals where f(xk) f(xk+1)<0. You may need to refine the points which means dividing the initial interval into smaller and smaller intervals.
## Response


	
## Sources
[]()

[]()

[]()
## Task 6
Search the internet for sites that discuss location of multiple roots in one dimension. Discuss the methods used to find additional toots. Write a brief summary of what you find including the pros and cons of the methods. Your write up should be a brief paragraph (3 or 4 sentences) that describe your findings. Include links to the sites you cite.
## Response



## Sources
[]()

[]()

[]()

[]()
