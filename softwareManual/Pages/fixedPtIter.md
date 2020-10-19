# Math 4610 Numerical Methods

**Routine Name:**           fixedPtIter

**Author:** Nicole Fleming

**Language:** Java. The code can be compiled using the commandline, I use it with gradle specifically when I do this.

For example,

    commandline: gradle build .
                 gradle run

will produce in running the program in both sources. If one does not have the gradle installed with the project, to run from the commandline

    "FILE-PATH" src/test/*.java -d classes
    "FILE-PATH" -cp classes test.java rootFinders.java
    
where the method belonds to the class rootFinders. These commands should also work.

**Description/Purpose:** This routine should perform the Fixed Point iteration over the function in Java. If the function converges, it should find the roots. 
Currently this method fails at finding the roots, and it does check for convergence vs divergence, but the routine in the while loop is inaccurate. This will be 
worked on as it should work, but there is no clear way to fix it currently so it will be reasearched and returned to.

**Input:** There are three inputs, double approx, double tolerance, double iters. These are the values of the intial guess, x0, the exact solution and the approximated solution.
 

**Output:** This routine returns a singe double, val, which should be the calculated value the funciton converges to. 

**Usage/Example:**

The routine has three arguments required to perform the operations to return the estimate. 

        double tol = h;
        double a = 0.0;
        double b = 10.0;
        int iters = 100;
        
        //Tasksheet 4 task 3,4
        ans = root.fixedPtIter(.2,h,iters);
        System.out.println("Fixed Point finds the root to be: " + ans);

Output is:
     
        Iteration 1: Current value 0.109417
        Iteration 2: Current value 0.121866
        Iteration 3: Current value 0.139293
        Iteration 4: Current value 0.165870
        Iteration 5: Current value 0.212474
        Iteration 6: Current value 0.318980
        Iteration 7: Current value 0.797004
        Iteration 8: Current value 242.266565
        Fixed Point finds the root to be: 242.2665654803746



**Implementation/Code:** The following is the code for TseriesApprox

     public double fixedPtIter(double approx, double tolerance, int maxIters) 
     {
        double p, p0, tol;
        int no;
        double val = 0.0;
        int i = 1;
        double eps = 10.0 * tolerance;
        double epslion = 0.5;
        //double error = Math.abs(f2());
        double maxLimit = maxIters;
        //Approximate p
        p0 = approx*epslion;

        //Desired Tolerance
        tol = tolerance;

        //Maximum Iterations
        no = maxIters;

        while(i <= no) {
            //find the starting value of the function
            p = g(p0);
            double error = Math.abs(f2(p0));

            if(p0 < 1) {
                if (Math.abs(p - p0) < tol)
                    break;

                //Assign the current value of p to val, the returning value.
                val = p;

                //Print out the current iteration, and the current value of p to console
                System.out.printf("Iteration %d: Current value %f\n", i, p);

                //reset p0
                p0 = p;
                //increment i
                i = i + 1;

                //check the error vs the tolerance
                eps = Math.abs(f2(p0)) * eps;
                if (eps > g(p0)) {
                    break;
                }

                //If this is not here, it will iterate all 100 times. I haven't stepped through enough to
                //completely debug this case. But for the specific example f(x) = xe^3x^2, this gets the last guess before Infinity.
                if (val >= 1) {
                    break;
                }
            }
            else if(error > 1){
                System.out.println("This diverges");
                break;
            }
            else{
                System.out.println("This wanders");
                break;
            }
        }
        //return last value
        return val;
    }
    
**Last Modified:** 19/October/2020
