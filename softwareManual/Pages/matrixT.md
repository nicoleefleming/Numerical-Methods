# Math 4610 Numerical Methods

**Routine Name:**           matrixT

**Author:** Nicole Fleming

**Language:** Java. The code can be compiled using the commandline, I use it with gradle specifically when I do this.

For example,

    commandline: gradle build .
                 gradle run

will produce in running the program in both sources. If one does not have the gradle installed with the project, to run from the commandline

    "FILE-PATH" src/test/*.java -d classes
    "FILE-PATH" -cp classes test.java matrixInitializers.java
    
where the method belonds to the class matrixInitializers. These commands should also work.

**Description/Purpose:** This routine will produce a square matrix of coefficients either representing a system of equations or data points. It will take the matrix that is the input and make the rows the columns, and the columns rows. 

**Input:** There is one input: double[][] A that will specify the square matrix. 

**Output:** This routine returns a single two dimensional array, A that has the values stored in the array. 

**Usage/Example:**

The routine has one argument required to perform the operations to return a matrix with the values specified in matrixT.

    A = mat.matrixT(n);
    
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            System.out.print(A[i][j] + ", ");
        }
        System.out.println();
    }

The output is:

    
    1.0                    -0.0                    -0.0
    0.0                    1.0                     -0.0
    2.220446049250313E-16  -5.551115123125783E-17  0.9999999999999999 
  
  

**Implementation/Code:** 

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

**Last Modified:** 20/November/2020
