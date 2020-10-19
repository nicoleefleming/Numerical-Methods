import java.lang.Math;

public class error {

    public double absErr(double x, double y)
    {
        double ret = (x-y)/x;
        return Math.abs(ret);
    }

    public double relErr(double aprime, double ah, double a, double h)
    {
        double ret = ((aprime - ((ah - a)/h))/a);
        return Math.abs(ret);
    }
}
