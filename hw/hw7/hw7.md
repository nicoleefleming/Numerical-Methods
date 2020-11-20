# Math 4610 Tasksheet 7

## Task 1:
Write a routine to compute the solution of an upper triangular matrix. Test the code on the following matrix equation Ax=b with A=a_(i,j) and 

        
          a_(i,j)=  0, j<i
                    i+j−1, j≥i
        
Finally, set b_i=1. Hint: You should write a routine that will initialize the matrix above in a general way to use over and over in examples.

### Response
For math5620 in Spring 2020 I wrote our methods I used again here. I will reference their software manual pages in the current math4610 repository as I made small changes to two of them to get them functioning properly. The methods I altered are GESolve, and RHSinit. The other two methods are the substitution methods, which I will also add as new pages in this repository but the page will be identical to the one in math5620. 

I wrote the code below to initialize the Upper Triangular matrix system. I also adjusted my GESolve code, so if I decide to in the future, I can create a Gaussian Eilimination code to just get a matrix into upper triangular form. 

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

I also created a method for a system of equations that initializes the system not in an upper triangular form. 

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
                A[i][j] = java.lang.Math.cos(a);
            }
        }
        return A;
    }

### Sources
[GESolve]()

[RHSinit]()

[forward]()

[backward]()

[upperTriangleInit]()

[Ainit]()

[matrixInitializers Source Code]()

[LinearSolvers Source Code]()
## Task 2
Do the same for a lower triangular system of equations. Create an example similar to the example in Task 1. All you need to do is transpose the matrix and leave the right hand side alone. Hint: It would be a really good idea to build code that will return the transpose of a matrix.
### Response
For math5620 in Spring 2020 I wrote our methods I used again here. I will reference their software manual pages in the current math4610 repository as I made small changes to two of them to get them functioning properly. The methods I altered are GESolve, and RHSinit. The other two methods are the substitution methods, which I will also add as new pages in this repository but the page will be identical to the one in math5620. 

I wrote the code below to initialize the Lower Triangular matrix system. I also wrote a method that transposes a matrix, so if it is needed in the future I will be able to just transpose a matrix to get a desured result. 

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

I also created a method for a system of equations that initializes the system not in an lower triangular form. 

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

### Sources
[GESolve]()

[RHSinit]()

[forward]()

[backward]()

[lowerTriangleInit]()

[matrixT]()

[matrixInitializers Source Code]()

[LinearSolvers Source Code]()
## Task 3
Write a routine that will produce a square matrix for testing codes in the following tasks. The input should be an integer and the output a square matrix of size 
n×n. Also, write similar, but separate routines that produce upper or lower triangular matrices as in the square matrix case. Finally, write a routine that will generate a diagonal matrix of a given size. Hint: These should be easy modifications of one another.
### Response

### Sources
[]()

[]()
## Task 4
Do the same for a diagonal systems of equations. That is where
                
                a_(i,j) =    0, j≠i
                           ≠ 0, j=i
                           
As an example, choose random nonzero values for the diagonal entries to test the code. Make sure that the code is as efficient as possible.
### Response

### Sources
[]()

[]()

[matrixInitializers Source Code]()

[LinearSolvers Source Code]()
## Task 5
Write code that will reduce a square matrix to row echelon form. You do not need to test for bad pivots or anything else. Write the code as if we know the pivots will be well behaved. Create a random matrix
### Response
I altered my GESolve code to create a new method, REform. This was the code used:



I used my Ainit to initialize a square matrix to random numbers. Then I ran the code through REform. The results are shown below.




### Sources
[REform]()

[Ainit]()

[matrixInitializers Source Code]()

[LinearSolvers Source Code]()
## Task 6
Search the internet for sites that document the conditions on matrices that ensure we will be able to compute the solution of a linear system of equations. Write a brief paragraph (3 or 4 sentences) that describe your findings. Include links to the sites you cite.
### Response
There is a unique solution to a Matrix of a system of equations if the matrix is full rank. This means that the matrix has a full basis for the system of equations. This also means that the matrix is invertible. This makes the matrix singular. There are more non-singluar matrices than singular in the world of systems of equations or data matrices, but those that have solutions have full rank meaning no variable is made up of a +/- form of another. 

### Sources
[matrix equation with a solution](https://mathoverflow.net/questions/81/when-does-a-matrix-equation-have-a-solution)

[Invertible Matrix Theorem](https://mathworld.wolfram.com/InvertibleMatrixTheorem.html)

[Consistent vs Inconsistent](http://www.maths.nuigalway.ie/~rquinlan/MA203/section1-5.pdf)
