public class rootFinders
{
    double[] err = new double[100];

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
        return Math.exp(3*x*x) + 6*x*x*Math.exp(3*x*x); //1.0;
    }

    public double f(double x)
    {
        //function formula here
        double f = x*Math.exp(Math.pow(3*x,2)); //(x - 3);

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

    public double newton(double x0, double tol, int maxIters)
    {
        //Initialize variables
        double xnew = 0.0;
        double xold = x0;
        //ensures one trip through the loop
        double error = 10.0 *tol;
        int iters = 0;

        //while error is larger than tolerance
        while(error > tol && iters < maxIters)
        {
            //increment the iteration
            iters = iters+1;
            //calculate the new value for x
            xnew = xold - (f(xold)/f2(xold));
            //update the error
            error = Math.abs(xnew - xold);
            err[iters] = error;
            //update the value of x
            xold = xnew;
        }
        //return the found value of the root/convergent value for the function
        return xnew;
    }

    public double secant(double x0, double x1, double tol, int maxIters)
    {
        //initialize variables
        double error = 10.0 * tol;
        int iters = 0;
        //f(x) is just a function call to evaluate a given formula for a given x
        double fk = f(x0);
        double fkp1 = f(x1);
        double xk = x0;
        double xkp1 = x1;
        double xkp2 = 0.0;

        //iterate through the while loop while the error is greater than the tolerance given
        while(error > tol && iters < maxIters)
        {
            //calculate the next value of x
            xkp2 = xkp1 - ((fkp1*(xkp1-xk))/(fkp1-fk));
            //update the error
            error = Math.abs(xkp1 - xk);
            err[iters] = error;
            //reset the values of x to get the next value
            xk = xkp1;
            xkp1 = xkp2;
            //calculate the new function values.
            fk = fkp1;
            fkp1 = f(xkp1);
            //increment iters
            iters = iters + 1;
        }
        //return the root found/convergence value
        return xkp2;
    }

    public double hybridN(double a, double b, double tol, int maxIters)
    {
        //check if [a,b] is valid
        double tmp;
        if (a>b)
        {
            tmp = b;
            b = a;
            a = tmp;
        }

        //initialize other variables
        int iters = 0;
        double error = 10.0 * tol;
        double fa = f(a);
        double fb = f(b);
        double fc;
        double c = 0.0;
        double xnew = 0.0;

        //check other cases that could happen
        if (fa * fb > 0)
        {
            System.out.println("Error");
            return 0.0;
        }
        if (fa == 0)
        {
            return a;
        }
        if(fb == 0)
        {
            return b;
        }

        //initialize errorb and errorn
        double errorb = error;
        double errorn = error;

        //loop thorugh based on error staying larger than the tolerance. Then return c.
        while(error > tol && iters < maxIters)
        {
            c = 0.5 * (a+b);
            xnew = c - (f(c)/f2(c));

            //first Newton Error
            errorn = Math.abs(xnew - c);

            //check if Newton's method may fail
            if(errorn > Math.abs(b-a))
            {
                //Bisection section
                for (int i = 0; i < 4; i++) {
                    fc = f(c);
                    if (fa * fc == 0) {
                        b = c;
                        fb = fc;
                    } else {
                        a = c;
                        fa = fc;
                    }
                    c = 0.5 * (a + b);
                    errorb = Math.abs(b - a);
                }
            }
            error = errorb;
            err[iters] = error;
            iters = iters + 1;
        }
        return c;
    }

    /*
    public double hybridN(double a, double b, double tol, int maxIters)
    {
        //check if [a,b] is valid
        double tmp;
        double holder;
        if (a>b)
        {
            tmp = b;
            b = a;
            a = tmp;
        }

        //initialize other variables
        int iters = 0;
        double error = 10.0 * tol;
        double fa = f(a);
        double fb = f(b);
        double fc;
        double c = 0.0;
        double xnew = 0.0;

        //check other cases that could happen
//        if (fa * fb > 0)
//        {
//            System.out.println("Error");
//            return 0.0;
//        }
        if (fa == 0)
        {
            return a;
        }
        if(fb == 0)
        {
            return b;
        }

        //initialize errorb and errorn
        double errorb = error;
        double errorn = error;

        //loop thorugh based on error staying larger than the tolerance. Then return c.
        while(error > tol && iters < maxIters)
        {
            c = 0.5 * (a+b);
            xnew = c - (f(c)/f2(c));
            holder = c;
            //first Newton Error
            errorn = Math.abs(xnew - c);

            //check if Newton's method may fail
            if(errorn > Math.abs(b-a))
            {
                //Bisection section
                for (int i = 0; i < 4; i++) {
                    fc = f(c);
                    if (holder - c <= 0.000000001) { //I know this isn't exactly correct, but I will revisit this problem later.
                        return c;
                    }

                    if (fa * fc == 0) {
                        b = c;
                        fb = fc;
                    } else {
                        a = c;
                        fa = fc;
                    }
                    c = 0.5 * (a + b);
                    errorb = Math.abs(b - a);
                }
            }
            error = errorb;
            err[iters] = error;
            iters = iters + 1;

        }
        return c;
    }*/

    public double hybridS(double a, double b, double tol, int maxIters)
    {
        //check if [a,b] is valid
        double tmp;
        if (a>b)
        {
            tmp = b;
            b = a;
            a = tmp;
        }

        //initialize other variables
        int iters = 0;
        double error = 10.0 * tol;
        double fa = f(a);
        double fb = f(b);
        double fc;
        double c = 0.0;
        double xnew = 0.0;

        //check other cases that could happen
        if (fa * fb > 0)
        {
            System.out.println("Error");
            return 0.0;
        }
        if (fa == 0)
        {
            return a;
        }
        if(fb == 0)
        {
            return b;
        }

        //initialize errorb and errorn
        double errorb = error;
        double errorn = error;

        //loop thorugh based on error staying larger than the tolerance. Then return c.
        while(error > tol && iters < maxIters)
        {
            c = 0.5 * (a+b);
            xnew = c - (f(c) * ((b-a)/fb-fa));

            //first Newton Error
            errorn = Math.abs(xnew - c);

            //check if Newton's method may fail
            if(errorn > error)
            {
                //Bisection section
                for (int i = 0; i < 4; i++) {
                    fc = f(c);
                    if (fa * fc == 0) {
                        b = c;
                        fb = fc;
                    } else {
                        a = c;
                        fa = fc;
                    }
                    c = 0.5 * (a + b);
                    errorb = Math.abs(b - a);
                }
            }
            error = errorb;
            err[iters] = error;
            iters = iters + 1;
        }
        return c;
    }
    
}

