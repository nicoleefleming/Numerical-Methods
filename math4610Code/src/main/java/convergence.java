import java.lang.Math;

public class convergence {

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
}