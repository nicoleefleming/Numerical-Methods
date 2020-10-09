# Math 4610 Numerical Methods

**Routine Name:**           TseriesApprox

**Author:** Nicole Fleming

**Language:** Java. The code can be compiled using the commandline, I use it with gradle specifically when I do this, but I also compile with IntelliJ in a test file setting.

For example,

    commandline: gradle build .
                 gradle run
    IntelliJ:    Ctrl+F9 (build)
                 Shift+F9 (run)

will produce in running the program in both sources. If one does not have the gradle installed with the project, to run from the commandline

    "FILE-PATH" src/test/*.java -d classes
    "FILE-PATH" -cp classes test.java
    
where the method belonds to the class LinearSolvers. These commands should also work.

**Description/Purpose:** This routine will compute the approximation for the central difference approximation for a second order derivative. It determines the order of accuracy 
for the central difference approximation that is evaluated for f(x) at some given x. The code also calcualtes the error of the Taylor Series Expansion.

**Input:** There is one input: double[] h. This array is the array that will hold all the values for the specified values of h in the equation f(x + h) - f(x)/ h^2.
 

**Output:** This routine returns a single one dimensional array, diff, which is the approximations. It also updates the global variable error. 

**Usage/Example:**

The routine has one argument required to perform the operations to return a vector of the approximations calcualted. The code is written using for loops,
and logical statements. The data type is a double due to needing more precision with the numbers for the answers.

       sol = myTest.TseriesApprox(h);
        for(int i = 0; i < sol.length; i++)
            System.out.println(sol[i]);

Output from the lines above where dimensions are equal to 18, sol is the initialized TseriesApprox. The solution vector is:
     
      0.38260348236197916			
			0.4075490368602161			
			0.41580016309238904			
			0.4161433686711291			
			0.4161468019070469			
			0.41614681700608			
			0.4161471167662966		
			0.41600056732704616		
			0.4385380947269369		
			1.1102230246251563		
			55.51115123125782			
			5551.115123125782			
			555111.5123125783			
			0.0					
			5.551115123125782E9
			-1.6653345369377349E12	
			2.7755575615628912E14		
			0.0					
			0.0



**Implementation/Code:** The following is the code for TseriesApprox

    public double[] TseriesApprox(double[] h)
    {
        double[] diff = new double[19];
        double[] err = new double[19];
        double exactvsact;
        err = error;

        double x = 2.0;
        //Use the Tseries approximation for the difference.
        //technically the second derivative of cos(x) is cos(x). Thus the below arguement is correct in the approximation.
        for(int i = 0; i < 19; i++)
        {
            diff[i] = (cos(x + h[i]) - 2* cos(x) + cos(x-h[i]))/(h[i]*h[i]);
        }


        exactvsact = cos(2.0);
        System.out.println("\n Values of the approximation: \n");
        for(int i = 0; i < diff.length; i++)
            System.out.println(diff[i]);

        //Use the Tseries approximation for the error
        //global variable error to store results.
        //The fourth derivative of cos(x) is also cos(x). the Tseries expansion error is shown below.
        for (int i = 0; i<18; i++)
        {
            err[i] = ((0.0833333333)*(Math.pow(h[i], 2)))*(diff[i]);
        }


        System.out.println("\n Values of the error: \n");
        for(int i = 0; i < err.length; i++)
            System.out.println(err[i]);

        difference = exactvsact;
        error = err;
        //return approximation
        return diff;
    }

**Last Modified:** 23/September/2020
