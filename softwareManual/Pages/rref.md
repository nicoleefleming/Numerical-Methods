# Math 4610 Numerical Methods

**Routine Name:**           rref

**Author:** Nicole Fleming

**Language:** Java. The code can be compiled using the commandline, I use it with gradle specifically when I do this.

For example,

    commandline: gradle build .
                 gradle run

will produce in running the program in both sources. If one does not have the gradle installed with the project, to run from the commandline

    "FILE-PATH" src/test/*.java -d classes
    "FILE-PATH" -cp classes test.java LinearSolvers.java
    
where the method belonds to the class LinearSolvers. These commands should also work.

**Description/Purpose:** This routine will reduce a square matrix to RREF (reduced-row echelon form).

**Input:** There is one input: double[][] m, double[] b. The first array is the array that will hold all the values for the square matrix. 

**Output:** This routine returns a single two dimensional array, m, that is altered when going through the solving process and returns the values for 
the RREF form of the given matrix. 

**Usage/Example:**

The routine has one argument required to perform the operations to return a matrix with the values after reducing the matrix to reduced row echelon form. 
The code is written using for loops, and logical statements.

 A = mat.Ainit(n);
    A = lin.rref(A);

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            System.out.print(A[i][j] + ", ");
        }
        System.out.println();
    }

The output is:

    1.0, 0.0, 2.220446049250313E-16, 
    -0.0, 1.0, -5.551115123125783E-17,
    -0.0, -0.0, 0.9999999999999999, 
  
  

**Implementation/Code:** 

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

**Last Modified:** 14/February/2020
