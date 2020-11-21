import static java.lang.Math.cos;
import static java.lang.Math.sqrt;
import static java.lang.Math.sin;
import java.io.File;
import java.io.IOException;
import java.io.*;

public class LinearSolvers extends substitution
{
    double pi = 3.14159627;


    public double[] GEsolve(double[][] toSolve, double[] b)//, int m)
    {
        int n = toSolve.length;
        int m = b.length;

        if(n != m)
        {
            System.out.println("The rows of the matrix A do not match the rows in the known solution vector.");
            return b;
        }

        double[][] A;  //the matrix that is being acted on.
        A = toSolve;                //assign the matrix to that which was passed in to make a copy
        double factor;                 //the factor that the GE calculates


        //Gaussian Elimination
        for (int k = 0; k < n-1; k++)
        {
            for (int i = k + 1; i < n; i++)
            {
                factor = A[i][k]/A[k][k];
                for (int j = k + 1; j < n; j++)
                {
                    A[i][j] = A[i][j] - (factor * A[k][j]);
                }
                b[i] = b[i] - (factor * b[k]);
            }
        }

        //Back Substitution
        backward(A, b);

        return b;
    }

    public double[] RHSinit(int length)
    {
        //init array to what the formula is
        //this initializes b
        int n = length;
        double[] rhs = new double[n];

        for (int i = 0; i < n; i++)
        {
            rhs[i] = 1.0;
            //rhs[i] = cos(i*(pi));
            //rhs[i] = 10*sin(2*pi*i);
            //rhs[i] = sin(pi*i);
            //rhs[i] = i - Math.pow(i, 2);
        }
        return rhs;
    }

    public double[][] rref(double[][] m)
    {
        int lead = 0;
        int rowCount = m.length;
        int colCount = m[0].length;
        int i;
        boolean quit = false;

        for(int row = 0; row < rowCount && !quit; row++)
        {
            //System.out.print(m);
            //System.out.println();

            if(colCount <= lead)
            {
                quit = true;
                break;
            }

            i=row;

            while(!quit && m[i][lead] == 0)
            {
                i++;
                if(rowCount == i)
                {
                    i=row;
                    lead++;

                    if(colCount == lead)
                    {
                        quit = true;
                        break;
                    }
                }
            }

            if(!quit)
            {
                swapRows(m, i, row);

                if(m[row][lead] != 0)
                    multiplyRow(m, row, 1.0f / m[row][lead]);

                for(i = 0; i < rowCount; i++)
                {
                    if(i != row)
                        subtractRows(m, m[i][lead], row, i);
                }
            }
        }
        return m;
    }

    // swaps two rows
    static void swapRows(double [][] m, int row1, int row2)
    {
        double [] swap = new double[m[0].length];

        for(int c1 = 0; c1 < m[0].length; c1++)
            swap[c1] = m[row1][c1];

        for(int c1 = 0; c1 < m[0].length; c1++)
        {
            m[row1][c1] = m[row2][c1];
            m[row2][c1] = swap[c1];
        }
    }

    static void multiplyRow(double [][] m, int row, double scalar)
    {
        for(int c1 = 0; c1 < m[0].length; c1++)
            m[row][c1] *= scalar;
    }

    static void subtractRows(double [][] m, double scalar, int subtract_scalar_times_this_row, int from_this_row)
    {
        for(int c1 = 0; c1 < m[0].length; c1++)
            m[from_this_row][c1] -= scalar * m[subtract_scalar_times_this_row][c1];
    }

}
