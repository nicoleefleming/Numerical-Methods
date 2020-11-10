# Math 4610 Tasksheet 6

## Task 1
In this problem consider the function
                  f(x)=e^(−x^2) sin(4x^2−1.0)+0.051
Try all four methods for finding roots that you have developed. Start by computing the closest root to zero. Hint: Start with Bisection on a small interval around x∗=0.0 to bracket the root and then apply the other methods to verify they work. Write a code that is linked to your shared library, jar-file, or python module folder.
## Response
With this problem, I first applied the bisection method for the interval ( -0.4, 0.6 ) which returns 0.48361358642578123. The code for bisection that performed this was:

	a = -0.4;
       	b = 0.6;
        ans = root.bisection(a, b, tol, iters);
        //print out the root
        System.out.println(ans);
	
For the Secant Method I called the method previously written, and passed in -0.4 for x0 and 0.6 for x1. This method returned 0.48361358642578123. The code that performed this was:

	//1 - secant
        ans = root.bisection(a, b, tol, iters);
        //print out the root
        System.out.println(ans);

For Newton's Method I called the method previously written in the jar file, and had f and f2 as the original and the derivative respectively. The root found was not a valid answer. With three iterations the root was 0.4414197630292626. The code that recieved the result of the root is:

	ans = root.newton(0.1,tol,5);
        //print out the root
        System.out.println(ans);
	
For the HybridNewton method I called the method previously written method hybridN, and passed in a = -0.4 and b = 0.6. The root found was 0.4999995708465576. The code that found the root is:

	ans = root.hybridN(a,0.5,tol,iters);
        //print out the root
        System.out.println(ans);
	
I could have done this all in one method named solve that would apply these methods and implement them 
## Sources
[bisection Software Manual Page](https://github.com/nicoleefleming/math4610/blob/master/softwareManual/Pages/bisection.md)

[secant Software Manual Page](https://github.com/nicoleefleming/math4610/blob/master/softwareManual/Pages/secant.md)

[newton Software Manual Page](https://github.com/nicoleefleming/math4610/blob/master/softwareManual/Pages/newton.md)

[hybridN Software Manual Page](https://github.com/nicoleefleming/math4610/blob/master/softwareManual/Pages/hybridN.md)

[source Code for Root Finding Methods](https://github.com/nicoleefleming/math4610/blob/master/math4610Code/src/main/java/rootFinders.java)

[Source code for where it was run from](https://github.com/nicoleefleming/math4610/blob/master/math4610Code/src/test/java/myTest.java)

## Task 2
Apply your Newton method to the function in Task 1 by starting 
x0=−5.0 and x0=6. If we want the root closest to zero, as in Task 1, compare the results obtained to the root we found in the previous Task. What went right or wrong?
## Response
This method was not able to focus in on one root. However, the graph is really flat at -5 and at 6. I beleive that the method was getting stuck on the flat part, since the derivative of f is also flat at these points, it was running through and not finding the root as a result of the flatness of the function. The odd part about this is that the narrowing of the root cannot be started too far from 0 and the iterations run through fast to get a root, but they can't be started too far from zero or they get stuck in the flatness. Where the slope is close to 0. 
	

## Sources
[newton Software Manual Page](https://github.com/nicoleefleming/math4610/blob/master/softwareManual/Pages/newton.md)

[Source Code for newton](https://github.com/nicoleefleming/math4610/blob/master/math4610Code/src/main/java/rootFinders.java)

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
The roots in a specified area are hard to get any specific algorithm to comput all the roots. The algorithm will search and hunt for one root and return that specific root. The methods used to find all the roots I found were: Exclusion and Enclosure methods such as the Lehmer–Schur algorithm uses the Schur–Cohn test for circles; a variant, Wilf's global bisection algorithm uses a winding number computation for rectangular regions in the complex plane; Real Root Isolation, Aberth's Method, and a few others that are older than Newton's Method; The last is Square Free Facotrization which doesn't seem as good of a choice as the other algorithms. The pros to the first set in Exclusion and enclosure are that you are guarenteed to have a root found in a specified interval, however, the Real Roots Isolation are faster to converge. The cons of the Exclusion are that they might not have a root on the interval, or there might be a saddle point before the root where the algorithm gets stuck, for the others, it may miss multiple roots in one interval as it converges to the closest one possible. 

## Sources
[Root Finding Algorithms](https://en.wikipedia.org/wiki/Root-finding_algorithms)

[1D-Root Finding Techniques](https://www.gnu.org/software/gsl/doc/html/roots.html)

[Root Finding in 1D](http://albi3ro.github.io/M4/Roots_1D.html)

[Root Finding Algorithms](https://medium.com/cantors-paradise/some-root-finding-algorithms-5c6fa8a4a165)
