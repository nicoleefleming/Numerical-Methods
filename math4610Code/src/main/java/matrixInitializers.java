import java.util.Random;
public class matrixInitializers {

    //initialize an upper triangular matrix
    public double[][] upperTriangleInit(int n) {
        //FOR SQUARE MATRICES!!!
        double[][] upper = new double[n][n];

        //columns
        for(int i = 0; i < n; i++)
        {
            //rows
            for(int j = 0; j < n; j++)
            {
                if(i > j)
                {
                    upper[i][j] = 0.0;
                }
                else if (i < j)
                {
                    upper[i][j] = i + j - 1.0;
                }
                else
                {
                    upper[i][j] = i + j - 1.0;
                }
            }
        }
        return upper;
    }

    //initialize a lower triangular matrix
    public double[][] lowerTriangleInit(int n) {
        //FOR SQUARE MATRICES!!!
        double[][] lower = new double[n][n];

        //columns
        for(int i = 0; i < n; i++)
        {
            //rows
            for(int j = 0; j < n; j++)
            {
                if(i < j)
                {
                    lower[i][j] = 0.0;
                }
                else if (i > j)
                {
                    lower[i][j] = i + j - 1.0;
                }
                else
                {
                    lower[i][j] = i + j - 1.0;
                }
            }
        }
        return lower;
    }

    //initialize a non-triangular matrix
    public double[][] Ainit(int n)
    {
        //matrix from system of equations
        double[][] A = new double[n][n];
        Random rand = new Random();

        //put all the specified coefficients into matrix.
        for (int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                double a = rand.nextDouble();
                A[i][j] = a;
            }
        }
        return A;
    }

    //transpose a matrix
    public double[][] matrixT(double[][] A)
    {
        double[][] transpose = new double[A.length][A.length];
        //temp value
        double temp = 0;

        //compute the transpose.
        for (int i = 0; i < A.length; i++)
        {
            for(int j = 0; j < A.length; j++)
            {
                if(i != j)
                {
                    //switch the indices to flip across the axis
                    temp = A[j][i];
                    //make the columns the rows
                    transpose[j][i] = A[i][j];
                    //make the rows the columns
                    transpose[i][j] = temp;
                }
                else {
                    transpose[i][j] = A[i][j];
                }
            }
        }
        //return the transposed matrix
        return transpose;
    }

    public double[][] diagInit(int n)
    {
        double[][] diag = new double[n][n];
        Random rand = new Random();

        for (int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i != j)
                    diag[i][j] = 0.0;
                else
                    diag[i][j] = rand.nextDouble();
            }
        }


        return diag;
    }

}
