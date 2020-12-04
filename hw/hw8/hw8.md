# Math 4610 Numerical Methods

## Task 1
Write code that will implement Gaussian elimination and backsubstitution for square linear systems of equations. Test your code on a random matrix that is diagonally dominant. Document the code and the example in your software manual.
### Response
I wrote the following codes to do Gaussian-elimination and backsubstitution for solving the square linear systems of equations.
GESolve performs Gaussian elimination
    
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

The backward substitution method

    public static double[] backward(double[][] Umat,double b[]) {

        int n = Umat.length;
        int m = b.length;

        if(n != m)
        {
            System.out.println("Invalid length.");
            return b;
        }

        double x = b[n-1]/Umat[n-1][n-1];
        double[] xi = new double[n];

        for (int i = n-1; i >= 0; i--)
        {
            xi[i] = b[i];
            for (int j = i-1; j > n; j--)
            {
                xi[i] = xi[i] - (Umat[i][j] * x);
            }
            xi[i] = xi[i]/Umat[i][i];
        }

        return xi;
    }


I tested the code with the following:

    //initialize RHS to all 1's
        int n = 3;
        double[] b = lin.RHSinit(n);

        //initialize Upper Triangle Matrix
        double[][] A = mat.upperTriangleInit(n);

        //code to verify the matrix initialized correctly
        /*for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }*/

        //solve the system of equations
        double[] x = lin.GEsolve(A, b);

        //print out the solution
        for (int i = 0; i < n; i++)
            System.out.println(x[i] + ",");
            
Which returned the following values where b is a vector of 1.0. 

    A:=
    0.11513223866461264, 0.0,                0.0, 
    0.0,                 0.4983105566559789, 0.0, 
    0.0,                 0.0,                0.9711626946440088, 
    
    x = 1.0,
        1.0,
        1.0

I also tested the functions with b being 10sin(2n pi) where n is the index of the row. The answer is:

    A:= 
    0.8735259454814749, 0.0,                0.0; 
    0.0,                0.4899745753242153, 0.0; 
    0.0,                0.0,                0.37074046528784066; 
    
    x = 0.0,
        7.232820413397107E-5,
        1.4465640826415838E-4,
    
### Sources
[GESolve](https://github.com/nicoleefleming/math5620/blob/master/SoftwareManual/GEsolve.md)
[backward](https://github.com/nicoleefleming/math5620/blob/master/SoftwareManual/backward.md)
[LinearSolvers Source Code](https://github.com/nicoleefleming/math4610/blob/master/math4610Code/src/main/java/LinearSolvers.java)
[Substitution Source Code](https://github.com/nicoleefleming/math4610/blob/master/math4610Code/src/main/java/substitution.java)
## Task 2
Create a code from the code in Task 1 of this tasksheet to implement LU-factorization for solving a square linear system. If you have not implemented a forward substituion code, do so. Document all codes created in the task with entries in your software manual.
### Response
I have written these programs, LUfac is shown below:

    private double[][] LUfac(double[][] array)
    {
      int n = array.length;
   
      double[][] A;  //the matrix that is being acted on.
      A = array;                //assign the matrix to that which was passed in to make a copy
      double factor;                 //the factor that the GE calculates


      //LU Factorization
      for (int k = 0; k < n-1; k++)
      {
          for (int i = k + 1; i < n; i++)
          {
              factor = A[i][k]/A[k][k];
              for (int j = k + 1; j < n; j++)
              {
                  A[i][j] = A[i][j] - (factor * A[k][j]);
              }
              A[k][i]= factor; //b[i] = b[i] - (factor * b[k]);
          }
      }

      return A;
    }

LUfac is a little buggy. I am working on fixing some of the bugs, but this is the code I have for now.

I have written forward the substitution method, shown below:

    public static double[] forward(double[][] mat, double b[]) {

      int nrow = mat.length;
      //double sol[] =new double[nrow];

      for (int r=0;r<nrow; r++)
      {
          double val =0;
          for (int c=0;c<r; c++) {
            val =val +  b[c] *mat[r][c];
          }
          val = b[r] - val;
          b[r] = val/mat[r][r];
      }
    
    //   for(int i = 0; i < mat.length; i ++)
    //   {
    //       System.out.println(b[i] + ",");
    //   }
    
      return b;
    }

The use of the code is shown below:

    //LU factorization
    ts3A = triOps.LUfac(ts3A, b);

    for (int i = 0; i < ts3A.length; i++)
    {
        for (int j = 0; j < ts3A.length; j++)
        {
            System.out.println(ts3A[i][j] + " ");
        }
        System.out.println("\n");
    }
    
Which returns the matrix 

    A:=
      128.0,  0.5,   0.0 
      64.0,   96.0,  0.6666666666666666
      0.0,    64.0,  -42.666666666666664
      
Using this in the system of equations with b = 1.0, returns x = 1.0, 1.0, 1.0. However, the bug occurs when using b != 1.0. I input the code into a solution solver, triDiagSolve, but with the LU code in place of the GE parts to solve the program. 

    public double[] triDiagSolve(double[][] toSolve, double[] b)
    {
        int r = toSolve.length;
        int m = b.length;

        if(r != m)
        {
            System.out.println("The rows of the matrix A do not match the rows in the known solution vector.");
            return b;
        }

        double[][] A;                            //the matrix that is being acted on.
        A = toSolve;                             //assign the matrix to that which was passed in to make a copy
        double factor;                           //the factor that the GE calculates


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
        double x = b[r-1]/A[r-1][r-1];
        double[] xi = new double[r];

        for (int i = r-1; i >= 0; i--)
        {
            xi[i] = b[i];
            for (int j = i-1; j > n; j--)
            {
                xi[i] = xi[i] - (A[i][j] * x);
            }
            xi[i] = xi[i]/A[i][i];              
        }

        return b;
    }
    
This method was written specifically for triangle diagonalized methods, but it is buggy, and I believe the way I was implementing the logic for LU is not accurate. I have not updated the code with the broken/buggy code, but this is the semi-working code I have. 

### Sources
[LUFac](https://github.com/nicoleefleming/math5620/blob/master/SoftwareManual/LUfac.md)
[forward](https://github.com/nicoleefleming/math5620/blob/master/SoftwareManual/forward.md)
[triDiagSolve](https://github.com/nicoleefleming/math5620/blob/master/SoftwareManual/triDiagSolve.md)
[LinearSolvers Source Code](https://github.com/nicoleefleming/math4610/blob/master/math4610Code/src/main/java/LinearSolvers.java)
[Substitution Source Code](https://github.com/nicoleefleming/math4610/blob/master/math4610Code/src/main/java/substitution.java)
## Task 3
Use your LU-factorization on Hilbert matrices of size 
n=4,5…,10. Document your results using the the method where you choose a right hand side based on linear systems you know. That is, (1) multiply the matrix into a vector of ones, (2) solve the system of equations that results, and compare your solution to the original vector of ones.
### Response

### Sources

## Task 4
Implement scaled partial pivoting for the Gaussian elimination method for solving linear systems of equations. You will need to create new versions of the old code. Also, create software manual entries for the new codes.
### Response

### Sources

## Task 5
Try scaled partial pivoting against the Hilbert matrix to see if the results are any better. You can do this by trying to increase the size of the matrix for the system of equations.
### Response

### Sources

## Task 6
Search the internet for sites that document the Hilbert metrix of various sizes. Write a brief paragraph (3 or 4 sentences) that describe your findings. Include links to the sites you cite.
### Response
The Hilbert Matrix is important in deriving least squares approxiations. They are notoriously difficult to use in numerical computation. They are Symmetric matrices, and Positive and the determinant is positive. I was looking into the Singular-values, as the SVD is a heavily used application in some machine learing applications. More information of the singular values were found in the textbook, Mathematics for Machine Learning (Hilbert spaces are talked about in chapter 3 on page 80). 
### Sources
[Hilbert Matrix Wikipedia](https://en.wikipedia.org/wiki/Hilbert_matrix)
[Geek for Geeks: Hilbert Matrix](https://www.geeksforgeeks.org/hilbert-matrix/)
[Mathematics for Machine Learning](https://mml-book.github.io/book/mml-book.pdf)
[singular values of hilbert matrices](https://mathoverflow.net/questions/137059/the-singular-values-of-the-hilbert-matrix)
