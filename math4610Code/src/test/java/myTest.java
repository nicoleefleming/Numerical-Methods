import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import java.math.Derivative;

import static java.lang.Math.cos;


public class myTest {

    public double[] erro = new double[19];

    public double[] getErrorLogLog (double[] error)
    {
        for (int i = 0; i < error.length; i++)
        {
            if(error[i] == 0.0)
            {
                error[i] = 0.0;
            }
            else {
                error[i] = Math.log(error[i]);
            }
        }
        return error;
    }
    private double difference;

    public static void main(String args[])
    {
        precision myprec = new precision();
        test myTest = new test();
        error Err = new error();
        rootFinders root = new rootFinders();
        convergence conv = new convergence();
        LinearSolvers lin = new LinearSolvers();
        matrixInitializers mat = new matrixInitializers();

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
                double hold = Math.pow((10), (i - 1));
                h[i] = (1/hold);
            }
        }

        //sol = myTest.TseriesApprox(h);
        //for(int i = 0; i < sol.length; i++)
        //    System.out.println(sol[i]);

        //System.out.println("\n Values of log(h): \n");
        //for(int i = 0; i < h.length; i++)
        //   System.out.println(h[i]);


        //exact solution
        //System.out.println("Exact value: " + myTest.difference);

        //Tasksheet 3 task 3
        //double sineps = 0.0;
        //sineps = myprec.smaceps();
        //System.out.println("The single machine precision: " + sineps + "\n" );

        //double doueps = 0.0;
        //doueps = myprec.dmaceps();
        //System.out.println("The double machine precision: " + doueps + "\n");
        */

        /*//Tasksheet 4 task 1
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
        //Tasksheet 4 task 3,4
        ans = root.fixedPtIter(.2,h,iters);
        System.out.println("Fixed Point finds the root to be: " + ans);
        */

        /*        //Tasksheet 5 # 1 Newton verification
        double h = 0.00001;
        double tol = h;
        double x = 0.1;
        double a = -1.0;
        double b = 1.0;
        int iters = 100;
        double[] c = new double[2];

        double ans;
*/

        /*//= root.newton(x, tol, iters);
        //System.out.println("Newton roots found: " + ans);

        //myTest.erro = root.err;
        //for (int i = 0; i<100; i++)
          //  System.out.println(myTest.erro[i]);
        //myTest.erro = myTest.getErrorLogLog(myTest.erro);
        //for (int j = 0; j<100; j++)
            //System.out.println(myTest.erro[j]);

        //c = conv.linreg(myTest.erro, myTest.erro);
        //System.out.println("\nThe linear regression on the newton error is: " + c[0] + ", " + c[1]);


        //Tasksheet 5 # 2 Secant verification
        //ans = root.secant(-1.0, -0.5, tol, iters);
        //System.out.println("Seccant roots found: " + ans);

        //myTest.erro = root.err;
        //for (int i = 0; i<100; i++)
          //  System.out.println(myTest.erro[i]);
        //myTest.erro = myTest.getErrorLogLog(myTest.erro);
        //for (int j = 0; j<100; j++)
        //System.out.println(myTest.erro[j]);

        //c = conv.linreg(myTest.erro, myTest.erro);
        //System.out.println("\nThe linear regression on the secant error is: " + c[0] + ", " + c[1]);

        //Tasksheet 5 # 5 Hybrid - Newton/Bisection method verification
        //ans =root.hybridN(a, b, tol, iters);
        //System.out.println("The hybrid solution using bisection and Newton's method is: " + ans);

        //myTest.erro = root.err;
        //for (int i = 0; i<100; i++)
          //  System.out.println(myTest.erro[i]);
        //myTest.erro = myTest.getErrorLogLog(myTest.erro);
        //for (int j = 0; j<100; j++)
        //System.out.println(myTest.erro[j]);

        //c = conv.linreg(myTest.erro, myTest.erro);
        //System.out.println("\nThe linear regression on the newton-bisection error is: " + c[0] + ", " + c[1]);


        //Tasksheet 6 # 1
        //1 - bisection
        a = -0.4;
        b = 0.6;
        ans = root.bisection(a, b, tol, iters);
        //print out the root
        System.out.println(ans);

        //1 - secant
        ans = root.bisection(a, b, tol, iters);
        //print out the root
        System.out.println(ans);

        //1 - newton
        ans = root.newton(6,tol,3);
        //print out the root
        System.out.println(ans);

        //1 - hybridN
        ans = root.hybridN(a,0.5,tol,iters);
        //print out the root
        System.out.println(ans);

        //3 - hybrid alter to find the one root prior found
        a = -5.0;
        b =  6.0;
        ans = root.hybridN(a,b,tol, iters);
        System.out.println(ans);

        ans = root.hybridS(a,b,tol, iters);
        System.out.println(ans);

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
*/

    //TASKSHEET 7 Task 1

        //initialize RHS to all 1's
        int n = 3;
        double[] b = lin.RHSinit(n);

        //initialize Upper Triangle Matrix
        double[][] A = mat.upperTriangleInit(n);

        //code to verify the matrix initialized correctly
        /*for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }*/

        //solve the system of equations
        double[] x = lin.GEsolve(A, b);

        //print out the solution
        for (int i = 0; i < n; i++)
            System.out.println(x[i] + ",");

    //TASKSHEET 7 Task 2
        //initialize RHS to all 1's
        b = lin.RHSinit(n);

        //initialize Lower Triangle Matrix
        //this returns 1's if lower, and if transposed of upper.
        A = mat.lowerTriangleInit(n);
        //A = mat.matrixT(A);

        //code to verify the matrix initialized correctly
        /*for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }*/

        //solve the system of equations
        x = lin.GEsolve(A, b);

        //print out the solution
        for (int i = 0; i < n; i++)
            System.out.println(x[i] + ",");


        //TASKSHEET 7 Task 3


        //TASKSHEET 7 Task 4
        A = mat.diagInit(n);

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(A[i][j] + ", ");
            }
            System.out.println();
        }


        //TASKSHEET 7 Task 5
        A = mat.Ainit(n);
        A = lin.rref(A);

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(A[i][j] + " ");
            }
            System.out.print(", " + x[i]);
            System.out.println();
        }

        
    }

    //TASKSHEET 2 Task 5 -- code to solve the Taylor Series Expansion for an f(x) with a given h
    //TASKSHEET 3 Task 1 -- code to solve the CDM to the second order. with the specifications.
    public double[] TseriesApprox(double[] h)
    {
        double[] diff = new double[19];
        double[] err = new double[19];
        double exactvsact;
        err = erro;

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
        erro = err;
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
                String val = Double.toString(erro[i]);
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
