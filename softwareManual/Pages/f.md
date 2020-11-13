# Math 4610 Numerical Methods

**Routine Name:**           f

**Author:** Nicole Fleming

**Language:** Java. The code can be compiled using the commandline, I use it with gradle specifically when I do this.

For example,

    commandline: gradle build .
                 gradle run

will produce in running the program in both sources. If one does not have the gradle installed with the project, to run from the commandline

    "FILE-PATH" src/test/*.java -d classes
    "FILE-PATH" -cp classes test.java rootFinders.java
    
where the method belonds to the class rootFinders. These commands should also work.

**Description/Purpose:** This routine solves the original value of the equation f(x). 

**Input:** There is one input to this function, a double x.
 

**Output:** This routine returns a singe double, which is the calculated value of f(x) at the given x. 

**Usage/Example:**

        double b = f(xold);
        System.out.println(b);

Output is:
     
        0.5

**Implementation/Code:** 

     public double f(double x)
    {
        //function formula here
        double f = Math.exp(-(x*x))*Math.sin(4*(x*x) -1.0) + 0.051; //(x - 3);

        return f;
    }
    
**Last Modified:** 13/November/2020
