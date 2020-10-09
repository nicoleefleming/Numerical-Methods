# Math 4610 Numerical Methods

**Routine Name:**           smaceps

**Author:** Nicole Fleming

**Language:** Java. The code can be compiled using the commandline, I use it with gradle specifically when I do this.

For example,

    commandline: gradle build .
                 gradle run

will produce in running the program in both sources. If one does not have the gradle installed with the project, to run from the commandline

    "FILE-PATH" src/test/*.java -d classes
    "FILE-PATH" -cp classes test.java precision.java
    
where the method belonds to the class precision. These commands should also work.

**Description/Purpose:** This routine will compute the  machine roundoff error for the float type in Java. This type is a smaller type than the double in java.

**Input:** There are no inputs. This method is called and will return the epsilon calculated.
 

**Output:** This routine returns a single double, seps, which is the machine roundoff error, or the smallest number that the machine sees before it sees 0. 

**Usage/Example:**

The routine has one argument required to perform the operations to return a vector of the approximations calcualted. The code is written using for loops,
and logical statements. The data type is a double due to needing more precision with the numbers for the answers.

        double sineps = 0.0;
        sineps = myprec.smaceps();
        System.out.println("The single machine precision: " + sineps + "\n" );

Output is:
     
      The single precision iterations: 24
      The single machine precision: 5.9604644775390625E-8



**Implementation/Code:** The following is the code for TseriesApprox

    public float smaceps()
    {
        //initialize and declare variables.
        float approx = 0;
        //initialize x1 to 1, and seps to 1
        float x1 = 1;
        float seps = 1;
        //set approx = x1 + seps
        approx = x1 + seps;
        //declare an iteration variable
        int iters = 0;

        while(approx != 1)
        {
            //update seps, divide it by two each iteration to get closer to seps = 0
            seps = seps/2;
            //update the approximation
            approx = x1 + seps;
            //increment the iteration counter
            iters = iters + 1;
            //when approx is equal to 1, or close enough to 1 that the
            // computer can't track the small number, exit loop
        }

        System.out.println("The single precision iterations: " + iters + "\n");
        return seps;
    }

**Last Modified:** 7/October/2020
