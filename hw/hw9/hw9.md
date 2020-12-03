# Math 4610 Numerical Methods

## Task 1
Write routines that will compute the following linear algebra operations on vectors.
  -vector addition
  -vector subtraction
  -scalar multiplication for vectors
  -dot product for two vectors of the same length
  -outer product for two vectors of the same length
This should create 5 new routines to be included in your library or repository in the case where you are programming in Python. Include entries for each in your software manual.
### Response

### Sources

## Task 2
Write routines that will compute the following linear algebra operations on vectors.
  -the magnitude of a vector - l1 norm version.
  -the magnitude of a vector - l2 norm version.
  -the magnitude of a vector - l∞ norm version.
  -the error between vectors - l1 norm version.
  -the error between vectors - l2 norm version.
  -the error between vectors - l∞ norm version.
This should create 6 new routines to be included in your library or repository in the case where you are programming in Python. Include entries for each in your software manual.
### Response

### Sources

## Task 3
Write routines that will compute the following linear algebra operations on matrices.
  -matrix addition
  -matrix subtraction
  -scalar multiplication for a matrix
  -the transpose of a matrix
  -the product of a rectangular matrix and vector
  -the product of two rectangular matrices
This should create 6 new routines to be included in your library or repository in the case where you are programming in Python. Include entries for each in your software manual.
### Response

### Sources

## Task 4
Write code to implement Jacobi Iteration for solving linear systems of equations as discussed in class. Use the routines that you have created in the previous 3 tasks to perform the operations. Use the residual update form for the iteration. That is,
  r_k = b−Ax_kx_(k+1)=x_k+D−1 
r_k should be used to perform the necessary operations.
### Response

### Sources

## Task 5
Compare the results for the Gaussian elimination with backsubstitution to the results from Jacobi iteration. To set things up do the following.
  -Generate a 100 by 100 symmetric, diagonally-dominant matrix for the linear system.
  -Generate the right-hand side of the system by multiplying the matrix you have into a vector of ones.
  -Solve the system of equations (with both methods) and compare the solution to the input vector of ones. Use the l2-norm routine to do this comparison.
### Response

### Sources

## Task 6
 Search the internet for sites that document the use of Jacobi iteration and Gauss-Seidel iteration which is a slight modification of Jacobi iteration. Write a brief paragraph (3 or 4 sentences) that describe your findings. Include links to the sites you cite.
### Response
The difference between the Gauss–Seidel and Jacobi methods is that the Jacobi method uses the values obtained from the previous step while the Gauss–Seidel method always applies the latest updated values during the iterative procedures. The Gauss-Seidel method updates on every step, where the Jacobi updates each iteration. This makes the convergence rate better in Gauss-Seidel better than Jacobi.
### Sources
[Gauss-Seidel Method](https://www.sciencedirect.com/topics/engineering/gauss-seidel-method#:~:text=The%20difference%20between%20the%20Gauss,as%20demonstrated%20in%20Table%207.2.)
[Jacobi Iteration Method](https://www.sciencedirect.com/topics/engineering/jacobi-method)
[]()
