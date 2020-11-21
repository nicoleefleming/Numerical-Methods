# Math 4610 Numerical Methods

**Routine Name:**           subtractRow

**Author:** Nicole Fleming

**Language:** Java. The code can be compiled using the commandline, I use it with gradle specifically when I do this.

For example,

    commandline: gradle build .
                 gradle run

will produce in running the program in both sources. If one does not have the gradle installed with the project, to run from the commandline

    "FILE-PATH" src/test/*.java -d classes
    "FILE-PATH" -cp classes test.java LinearSolvers.java
    
where the method belonds to the class LinearSolvers. These commands should also work.

**Description/Purpose:** This routine will perform the swapping rows opperation when performing rref on a square matrix.

**Input:** There are four inputs, the current matrix m, double[][] m, a scalar, double scalar, and the current indexes of the two rows to be subtracted, int subtract_scalar_times_this_row and int from_this_row. 

**Output:** This routine doesn't return anything. It merely updates m with the rows subtracted.

**Usage/Example:**

This routine is called from within rref. It can be used outside of this, but its main functionality is in the following method. If you desire to see the documentation for this function, click [rref](https://github.com/nicoleefleming/math4610/blob/master/softwareManual/Pages/rref.md).

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

**Implementation/Code:** 

    static void subtractRows(double [][] m, double scalar, int subtract_scalar_times_this_row, int from_this_row)
    {
        for(int c1 = 0; c1 < m[0].length; c1++)
            m[from_this_row][c1] -= scalar * m[subtract_scalar_times_this_row][c1];
    }

**Last Modified:** 20/November/2020
