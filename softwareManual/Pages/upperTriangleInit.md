# Math 4610 Numerical Methods

**Routine Name:**           upperTriangleInit

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

**Output:** This routine returns a single two dimensional array, A that has the values stored in the array, they will all be values above the diagonal. 

**Usage/Example:**

The routine has one argument required to perform the operations to return a matrix with the values specified in Ainit.

    A = mat.lowerTriangleInit(n);
    
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            System.out.print(A[i][j] + ", ");
        }
        System.out.println();
    }

The output is:

    0.11229730916035541 0.22247548601692124 0.8529838777920595 
    0.0 0.07690061572844964 0.8711123033690839 
    0.0 0.0 0.14506432125678514 
  
  

**Implementation/Code:** 

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

**Last Modified:** 20/November/2020
