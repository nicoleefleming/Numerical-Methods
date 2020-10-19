# Math 4610 Numerical Methods

**Routine Name:**           relErr

**Author:** Nicole Fleming

**Language:** Java. The code can be compiled using the commandline, I use it with gradle specifically when I do this.

For example,

    commandline: gradle build .
                 gradle run

will produce in running the program in both sources. If one does not have the gradle installed with the project, to run from the commandline

    "FILE-PATH" src/test/*.java -d classes
    "FILE-PATH" -cp classes test.java error.java
    
where the method belonds to the class precision. These commands should also work.

**Description/Purpose:** This routine will compute the  absolute error for an input x and y in Java.

**Input:** There are four inputs, double aprime, double ah, double a, and double h. Where aprime is the value of the derivative, ah is the value of the derived expression of (x+h), a is the derived expression, and h is the h in f(x+h).
These are the values of the exact solution and the approximated solution.
 

**Output:** This routine returns a singe double, ret, which is the absolute value of the relative error = (f'(x) - (((f(x+h)-f(x))/h))/f(x). 

**Usage/Example:**

The routine has two arguments required to perform the operations to return the error. 

        //Tasksheet 4 task 1
        double x = 3;
        double h = 0.00001;
        double derived = Math.exp(2*x);
        double correct = Math.pow(2.71828182845904523536028747135266249775724709369995957496696762772407663035354759457138217852516642742746639193200305992181741359662904357290033429526059563073813232862794349076323382988075319525101901157383418793070215408914993488416750924476146066808226480016, 2*x);
        double correctPrime = correct * (2*x);
        double ah = Math.exp(2*x + h);

        double errorRel = Err.relErr(correctPrime, ah, derived,h);

Output is:
     
        The Relative Error of e^(2*x) is: 4.999995000024013



**Implementation/Code:** 

    public double relErr(double aprime, double ah, double a, double h)
    {
        double ret = ((aprime - ((ah - a)/h))/a);
        return Math.abs(ret);
    }
    
**Last Modified:** 19/October/2020
