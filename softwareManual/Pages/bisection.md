# Math 4610 Numerical Methods

**Routine Name:**           bisection

**Author:** Nicole Fleming

**Language:** Java. The code can be compiled using the commandline, I use it with gradle specifically when I do this.

For example,

    commandline: gradle build .
                 gradle run

will produce in running the program in both sources. If one does not have the gradle installed with the project, to run from the commandline

    "FILE-PATH" src/test/*.java -d classes
    "FILE-PATH" -cp classes test.java rootFinders.java
    
where the method belonds to the class rootFinders. These commands should also work.

**Description/Purpose:** This routine finds roots in a function by splitting the interval in half, until it finds the root a given function converges to. 

**Input:** There are four inputs, double a, double b, double tol, double iters. The values a and b are the start and stop of the interval, the tolerance is tol, and the maximum iterations to run is iters..
 

**Output:** This routine returns a singe double, c, which is the calculated root within some tolerance. 

**Usage/Example:**

The routine has three arguments required to perform the operations to return the estimate. 

        //Tasksheet 4 task 5 Bisection
        double tol = h;
        double a = 0.0;
        double b = 10.0;
        int iters = 100;
        
        double ans = root.bisection(a,b,tol,iters);
        System.out.println("Bisection finds the root to be: " + ans);

Output is:
     
        Bisection finds the root to be: 9.999990463256836



**Implementation/Code:** 

     public double bisection(double a, double b, double tol, int iters)//interval[a,b], tolerance-close enough
    {
        //c and fc are not initialized, just declared
        double c = 0.0;
        double fc;
        //initialize other variables with the passed in parameters
        double fa = f(a);
        double fb = f(b);
        double err = 10.0 * tol;

        //loop through the interval to find the roots
        for(int i = 0; i < iters; i++)
        {
            //check the tolerance condition
            if(err < tol){
                break;
            }
            else{
                //make c the midpoint of the interval [a,b]
                c = (a+b)/2;
                //assign fc a value with c
                fc = f(c);
                //Check to see which side of the interval the root is on
                if (fa * fc < 0)
                {
                    b = c;
                    fb = fc;
                }
                else{
                    a = c;
                    fa = fc;
                }
                //calculate the error
                err = Math.abs(b-a);
                //return the value of c
                //return c;
            }
            c = c;
        }
        return c;
    }
    
**Last Modified:** 19/October/2020
