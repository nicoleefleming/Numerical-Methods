# Math 4610 Numerical Methods

**Routine Name:**           hybridN

**Author:** Nicole Fleming

**Language:** Java. The code can be compiled using the commandline, I use it with gradle specifically when I do this.

For example,

    commandline: gradle build .
                 gradle run

will produce in running the program in both sources. If one does not have the gradle installed with the project, to run from the commandline

    "FILE-PATH" src/test/*.java -d classes
    "FILE-PATH" -cp classes test.java rootFinders.java
    
where the method belonds to the class rootFinders. These commands should also work.

**Description/Purpose:** This routine finds roots in a function by taking an initial interval, tolerance and iterations to calculate the root of a function with the assistance of the bisection method (see [bisection](./bisection.md)) and the newton method (see [newton](./newton.md)). The combination of these two methods is effective for solving problems with many roots with adjustments to the interval, and it runs through the bisection 4 times before trying the newton method due to the quadratic convergence of newton's method.

**Input:** There are four inputs, double a, double b, double tol, double maxIters. The value a and b are the interval the method is looking for roots over, the tolerance is tol, and the maximum iterations to run is maxIters.
 

**Output:** This routine returns a single double, c, which is the calculated root within some tolerance. 

**Usage/Example:**

The routine has four arguments required to perform the operations to return the estimate. 

        //Tasksheet 5 # 1 Newton verification
        double h = 0.00001;
        double tol = h;
        double x = 0.1;
        double a = -1.0;
        double b = 1.0;
        int iters = 100;

        double ans =root.hybridN(a, b, tol, iters);
        System.out.println("The hybrid solution using bisection and Newton's method is: " + ans);

Output is:
     
        The hybrid solution using bisection and Newton's method is: 0.0


**Implementation/Code:** 

    public double hybridN(double a, double b, double tol, int maxIters)
    {
        //check if [a,b] is valid
        double tmp;
        if (a>b)
        {
            tmp = b;
            b = a;
            a = tmp;
        }

        //initialize other variables
        int iters = 0;
        double error = 10.0 * tol;
        double fa = f(a);
        double fb = f(b);
        double fc;
        double c = 0.0;
        double xnew = 0.0;

        //check other cases that could happen
        if (fa * fb > 0)
        {
            System.out.println("Error");
            return 0.0;
        }
        if (fa == 0)
        {
            return a;
        }
        if(fb == 0)
        {
            return b;
        }

        //initialize errorb and errorn
        double errorb = error;
        double errorn = error;

        //loop thorugh based on error staying larger than the tolerance. Then return c.
        while(error > tol && iters < maxIters)
        {
            c = 0.5 * (a+b);
            xnew = c - (f(c)/f2(c));

            //first Newton Error
            errorn = Math.abs(xnew - c);

            //check if Newton's method may fail
            if(errorn > Math.abs(b-a))
            {
                //Bisection section
                for (int i = 0; i < 4; i++) {
                    fc = f(c);
                    if (fa * fc == 0) {
                        b = c;
                        fb = fc;
                    } else {
                        a = c;
                        fa = fc;
                    }
                    c = 0.5 * (a + b);
                    errorb = Math.abs(b - a);
                }
            }
            error = errorb;
            iters = iters + 1;
        }
        return c;
    }
    
**Last Modified:** 23/October/2020
