# Math 4610 Numerical Methods

**Routine Name:**           newton

**Author:** Nicole Fleming

**Language:** Java. The code can be compiled using the commandline, I use it with gradle specifically when I do this.

For example,

    commandline: gradle build .
                 gradle run

will produce in running the program in both sources. If one does not have the gradle installed with the project, to run from the commandline

    "FILE-PATH" src/test/*.java -d classes
    "FILE-PATH" -cp classes test.java convergence.java
    
where the method belonds to the class convergence. These commands should also work.

**Description/Purpose:** This routine finds the value of a computational convergnece based on a linear regression analysis. This funciton takes in two vectors of the same length and performs the analysis where one vector is the error starting at 0 to n-1 and the other at 1 to n. This provides an analysis based on the error of the convergence rate. (from my understanding) 

**Input:** There are two inputs, double[] x, double[] y. The x array is the error of 0 to k, and y is the error of 1 to k+1. 
 

**Output:** This routine returns a singe double, c, which is the calculated value of the linear regression for the computational convergence.  

**Usage/Example:**

The routine has three arguments required to perform the operations to return the estimate. 

        myTest.erro = root.err; 

        c = conv.linreg(myTest.erro, myTest.erro);
        System.out.println("\nThe linear regression on the secant error is: " + c[0] + ", " + c[1]);

Output is:
     
        The linear regression on the secant error is: 0.0, 1.8367099231598242E-38


**Implementation/Code:** 

    public double[] linreg(double[] x, double[] y)
    {
        int m = x.length;
        double a11 = m;
        double a12 = 0.0;
        double a22 = 0.0;
        double b1 = 0.0;
        double b2 = 0.0;
        double[] c = new double[2];

        //start the regression analyais
        for (int i = 0; i < m; i++)
        {
            a12 = a12 + x[i];
            a22 = a22 + x[i]*x[i];
            b1 = b1 + y[i];
            b2 = b2 + y[i]*x[i];
        }

        //determine the new values of c that are the answers to linear regression
        double det = 1/(a22*a11 -a12*a12);
        c[0] = (a22*b1 - a12*b2)/det;
        c[1] =(a11*b2 - a12*b1)/det;

        return c;
    }
    
**Last Modified:** 31/October/2020
