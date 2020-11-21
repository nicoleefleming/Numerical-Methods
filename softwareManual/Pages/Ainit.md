# Math 4610 Numerical Methods

**Routine Name:**           Ainit

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

**Output:** This routine returns a single two dimensional array, A that has the values stored in the array. 

**Usage/Example:**

The routine has one argument required to perform the operations to return a matrix with the values specified in Ainit.

    A = mat.Ainit(n);
    
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
    0.40415871021813876 0.07690061572844964 0.8711123033690839 
    0.5042384711273434 0.07216757575636779 0.14506432125678514 
  
  

**Implementation/Code:** 

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

**Last Modified:** 20/November/2020
