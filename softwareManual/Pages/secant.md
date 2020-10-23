# Math 4610 Numerical Methods

**Routine Name:**           secant

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

**Input:** There are three inputs, double x0, double x1, double tol, double iters. The value x0 and x1 are the initial guesses of the value of the function at some point, the tolerance is tol, and the maximum iterations to run is iters.
 

**Output:** This routine returns a single double, xkp2, which is the calculated root within some tolerance. 

**Usage/Example:**

The routine has four arguments required to perform the operations to return the estimate. 

        //Tasksheet 5 # 1 Newton verification
        double h = 0.00001;
        double tol = h;
        double x = 0.1;
        double a = -1.0;
        double b = 1.0;
        int iters = 100;

        double ans = root.secant(-1.0, -0.5, tol, iters);
        System.out.println("Seccant roots found: " + ans);

Output is:
     
        Secant roots found: 0.0


**Implementation/Code:** 

    public double secant(double x0, double x1, double tol, int maxIters)
    {
        //initialize variables
        double error = 10.0 * tol;
        int iters = 0;
        //f(x) is just a function call to evaluate a given formula for a given x
        double fk = f(x0);
        double fkp1 = f(x1);
        double xk = x0;
        double xkp1 = x1;
        double xkp2 = 0.0;

        //iterate through the while loop while the error is greater than the tolerance given
        while(error > tol && iters < maxIters)
        {
            //calculate the next value of x
            xkp2 = xkp1 - ((fkp1*(xkp1-xk))/(fkp1-fk));
            //update the error
            error = Math.abs(xkp1 - xk);
            //reset the values of x to get the next value
            xk = xkp1;
            xkp1 = xkp2;
            //calculate the new function values.
            fk = fkp1;
            fkp1 = f(xkp1);
            //increment iters
            iters = iters + 1;
        }
        //return the root found/convergence value
        return xkp2;
    }
    
**Last Modified:** 23/October/2020
