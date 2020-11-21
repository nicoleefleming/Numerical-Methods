# Math 4610 Numerical Methods

**Routine Name:**           diagInit

**Author:** Nicole Fleming

**Language:** Java. The code can be compiled using the commandline, I use it with gradle specifically when I do this.

For example,

    commandline: gradle build .
                 gradle run

will produce in running the program in both sources. If one does not have the gradle installed with the project, to run from the commandline

    "FILE-PATH" src/test/*.java -d classes
    "FILE-PATH" -cp classes test.java matrixInitializers.java
    
where the method belonds to the class matrixInitializers. These commands should also work.

**Description/Purpose:** This routine will produce a square matrix of coefficients either representing a system of equations or data points.

**Input:** There is one input: int n that will specify the size of the square matrix. 

**Output:** This routine returns a single two dimensional array, A that has the values stored in the array, they will all be values on the diagonal. 

**Usage/Example:**

The routine has one argument required to perform the operations to return a matrix with the values specified in Ainit.

    A = mat.diagInit(n);
    
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            System.out.print(A[i][j] + ", ");
        }
        System.out.println();
    }

The output is:

    
    8.99 0 0
    0 3.1415 0
    0 0 34.897
  
  

**Implementation/Code:** 

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

**Last Modified:** 20/November/2020
