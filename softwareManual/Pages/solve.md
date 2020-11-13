# Math 4610 Numerical Methods

**Routine Name:**           solve

**Author:** Nicole Fleming

**Language:** Java. The code can be compiled using the commandline, I use it with gradle specifically when I do this.

For example,

    commandline: gradle build .
                 gradle run

will produce in running the program in both sources. If one does not have the gradle installed with the project, to run from the commandline

    "FILE-PATH" src/test/*.java -d classes
    "FILE-PATH" -cp classes test.java rootFinders.java
    
where the method belonds to the class rootFinders. These commands should also work.

**Description/Purpose:** This routine loops over the interval (a,b) and gets all the values of c from the hybridN or hybridS methods find. It then stores these in an array and returns the array. This array is then used to test for roots of the function. 

**Input:** There are 4 inputs, as these are inputs to the hybrid methods, double a, double b -- the interval -- double iters, and double tol. 
 

**Output:** This routine returns a singe double array, which is the calculated values of c on the interval. 

**Usage/Example:**

        double[] test = new double[10];
        double[] zero = new double[10];
        double[] rt = new double[10];
        test = root.solve(a,b,iters,tol);

        for(int i = 0; i < 10; i++)
        {
            zero[i] = root.f2(test[i]);
            if(zero[i] == 0)
            {
                rt[i] = test[i];
                System.out.println("Roots found are: " + rt[i] );
            }
        }

Output is:
     
        Roots found are: -0.5
        Roots found are: 0.5

**Implementation/Code:** 

     public double[] solve(double a, double b, int maxIters, double tol){
        double[] roots = new double[10];
        double newA = a;
        double newB = a + 1.0;
        int iters = 0;
        rootFinders rt = new rootFinders();

        if(newB > b)
            return roots;

        while(iters < maxIters && newB < b)
        {
            //call the hybrid functions with the newAB interval
            roots[iters] = hybridN(newA, newB, tol, maxIters);
            newA = newB;
            newB = newB + 1.0;
            iters = iters + 1;
        }

        return roots;
    }}
    
**Last Modified:** 13/November/2020
