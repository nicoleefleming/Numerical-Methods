import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import java.math.Derivative;

import static java.lang.Math.cos;


public class myTest {

    public double[] error = new double[19];
    private double difference;

    public static void main(String args[])
    {
        precision myprec = new precision();
        myTest myTest = new myTest();
        error Err = new error();
        rootFinders root = new rootFinders();

        /*double hold;
        //TASKSHEET 2 Task 1 -- state which language you will be using by printing to the console.
        //System.out.println("Brother Maynard, get me the holy hand grenade!");
        //System.out.println("I will be using Java for the bulk of the coding projects, but for plotting I will use python's graphing capabilities.");


        //TASKSHEET 2 Task 5 -- code to solve the Taylor Series Expansion for an f(x) with a given h
        //Initialize h
        double[] sol = new double[19];

        double[] h = new double[19];
        for (int i = 0; i < 19; i++)
        {
            if(i <= 1)
            {
                if(i == 0)
                {
                    h[i] = (1.0);
                }
                else
                {
                    h[i] = 0.5;
                }
            }
            else
            {
                hold = Math.pow((10),(i-1));
                h[i] = (1/hold);
            }
        }

        sol = myTest.TseriesApprox(h);
        for(int i = 0; i < sol.length; i++)
            System.out.println(sol[i]);

        System.out.println("\n Values of h: \n");
        for(int i = 0; i < h.length; i++)
            System.out.println(h[i]);

        //exact solution
        System.out.println("Exact value: " + myTest.difference);

        //Tasksheet 3 task 3
        double sineps = 0.0;
        sineps = myprec.smaceps();
        System.out.println("The single machine precision: " + sineps + "\n" );

        double doueps = 0.0;
        doueps = myprec.dmaceps();
        System.out.println("The double machine precision: " + doueps + "\n");
        */

        //Tasksheet 4 task 1
        double x = 3;
        double h = 0.00001;
        double derived = Math.exp(2*x);
        double correct = Math.pow(2.71828182845904523536028747135266249775724709369995957496696762772407663035354759457138217852516642742746639193200305992181741359662904357290033429526059563073813232862794349076323382988075319525101901157383418793070215408914993488416750924476146066808226480016, 2*x);
        double correctPrime = correct * (2*x);
        double ah = Math.exp(2*x + h);

        double errorAbs = Err.absErr(correct, derived);
        double errorRel = Err.relErr(correctPrime,ah, derived,h);

        System.out.println("The Absolute Error of e^(2*x) is: " + errorAbs + "\nThe Relative Error of e^(2*x) is: " + errorRel);

        //Tasksheet 4 task 5 Bisection
        double tol = h;
        double a = 0.0;
        double b = 10.0;
        int iters = 100;
        double ans = root.bisection(a,b,tol,iters);
        System.out.println("Bisection finds the root to be: " + ans);
        ans = root.fixedPtIter(.2,h,iters);
        System.out.println("Fixed Point finds the root to be: " + ans);
    }

    //TASKSHEET 2 Task 5 -- code to solve the Taylor Series Expansion for an f(x) with a given h
    //TASKSHEET 3 Task 1 -- code to solve the CDM to the second order. with the specifications.
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

    //TASKSHEET 2 Task 5 -- print results to file: h, approx, error
    public void PrintNumToFile(double[] h, double[] approx)
    {
        //TODO DEBUG this function. I am not sure why it is not working correctly.

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            //BufferedWriter xwriter = new BufferedWriter(new FileWriter("X.txt"));

            double[] solFor = h;
            double[] sol = approx;
            int len = h.length;
            double[] fx = new double[len];

            //Print out the values to a file of U and f(x)
            for (int i = 0; i < len; i++) {
                //write to file all h
                String writeMe = Double.toString(solFor[i]);
                writer.write(writeMe);
                writer.write(", ");

                //write to file all approximations
                String xVal = Double.toString(sol[i]);
                writer.write(xVal);
                writer.write(", ");

                //write to file for all error terms
                String val = Double.toString(error[i]);
                writer.write(val);
                writer.write("\n");
            }

            writer.close();
        }
        catch(IOException io)
        {
            System.out.println("IO EXCEPTION CAUGHT \n");
            io.printStackTrace();
        }

    }
}