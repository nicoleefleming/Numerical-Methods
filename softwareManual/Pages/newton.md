# Math 4610 Numerical Methods

**Routine Name:**           newton

**Author:** Nicole Fleming

**Language:** Java. The code can be compiled using the commandline, I use it with gradle specifically when I do this.

For example,

    commandline: gradle build .
                 gradle run

will produce in running the program in both sources. If one does not have the gradle installed with the project, to run from the commandline

    "FILE-PATH" src/test/*.java -d classes
    "FILE-PATH" -cp classes test.java rootFinders.java
    
where the method belonds to the class rootFinders. These commands should also work.

**Description/Purpose:** This routine finds roots in a function by taking an initial input and using that, the original function value and the derivative to find the root(s) of a function. 

**Input:** There are three inputs, double x, double tol, double iters. The value x is the initial guess of the value of the function at some point, the tolerance is tol, and the maximum iterations to run is iters.
 

**Output:** This routine returns a singe double, xnew, which is the calculated root within some tolerance. 

**Usage/Example:**

The routine has three arguments required to perform the operations to return the estimate. 

        //Tasksheet 5 # 1 Newton verification
        double h = 0.00001;
        double tol = h;
        double x = 0.1;
        double a = -1.0;
        double b = 1.0;
        int iters = 100;

        double ans = root.newton(x, tol, iters);
        System.out.println("Newton roots found: " + ans);

Output is:
     
        Newton roots found: 0.0


**Implementation/Code:** 

    public double newton(double x0, double tol, int maxIters)
    {
        //Initialize variables
        double xnew = 0.0;
        double xold = x0;
        //ensures one trip through the loop
        double error = 10.0 *tol;
        int iters = 0;

        //while error is larger than tolerance
        while(error > tol && iters < maxIters)
        {
            //increment the iteration
            iters = iters+1;
            //calculate the new value for x
            xnew = xold - (f(xold)/f2(xold));
            //update the error
            error = Math.abs(xnew - xold);
            //update the value of x
            xold = xnew;
        }
        //return the found value of the root/convergent value for the function
        return xnew;
    }
    
**Last Modified:** 23/October/2020
