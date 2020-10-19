public class rootFinders
{
    public double fixedPtIter(double approx, double tolerance, int maxIters) {
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

     double g(double x){
        return x*Math.exp(Math.pow(3*x,2));
    }

    double f2(double x){
        return Math.exp(3*x*x) + 6*x*x*Math.exp(3*x*x);
    }

    public double f(double x)
    {
        //function formula here
        double f = x*Math.exp(Math.pow(3*x,2));//(x - 3);

        return f;
    }

    public double bisection(double a, double b, double tol, int iters)//interval[a,b], tolerance-close enough
    {
        //c and fc are not initialized, just declared
        double c = 0.0;
        double fc;
        //initialize other variables with the passed in parameters
        double fa = f(a);
        double fb = f(b);
        double err = 10.0 * tol;

        //loop through the interval to find the roots
        for(int i = 0; i < iters; i++)
        {
            //check the tolerance condition
            if(err < tol){
                break;
            }
            else{
                //make c the midpoint of the interval [a,b]
                c = (a+b)/2;
                //assign fc a value with c
                fc = f(c);
                //Check to see which side of the interval the root is on
                if (fa * fc < 0)
                {
                    b = c;
                    fb = fc;
                }
                else{
                    a = c;
                    fa = fc;
                }
                //calculate the error
                err = Math.abs(b-a);
                //return the value of c
                //return c;
            }
            c = c;
        }
        return c;
    }
}
