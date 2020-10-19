# Math 4610 Numerical Methods

**Routine Name:**           absErr

**Author:** Nicole Fleming

**Language:** Java. The code can be compiled using the commandline, I use it with gradle specifically when I do this.

For example,

    commandline: gradle build .
                 gradle run

will produce in running the program in both sources. If one does not have the gradle installed with the project, to run from the commandline

    "FILE-PATH" src/test/*.java -d classes
    "FILE-PATH" -cp classes test.java error.java
    
where the method belonds to the class error. These commands should also work.

**Description/Purpose:** This routine will compute the  absolute error for an input x and y in Java.

**Input:** There are two inputs, double x and double y. These are the values of the exact solution and the approximated solution.
 

**Output:** This routine returns a singe double, ret, which is the absolute value of the difference between the two inputs x and y. 

**Usage/Example:**

The routine has two arguments required to perform the operations to return the error. 

        //Tasksheet 4 task 1
        double x = 3;
        double h = 0.00001;
        double derived = Math.exp(2*x);
        double correct = Math.pow(2.71828182845904523536028747135266249775724709369995957496696762772407663035354759457138217852516642742746639193200305992181741359662904357290033429526059563073813232862794349076323382988075319525101901157383418793070215408914993488416750924476146066808226480016, 2*x);
        
        double errorAbs = Err.absErr(correct, derived);

Output is:
     
        The Absolute Error of e^(2*x) is: 2.818014964607709E-16



**Implementation/Code:** The following is the code for TseriesApprox

    public double absErr(double x, double y)
    {
        double ret = (x-y)/x;
        return Math.abs(ret);
    }
    
**Last Modified:** 19/October/2020
