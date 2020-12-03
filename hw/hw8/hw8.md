# Math 4610 Numerical Methods

## Task 1
Write code that will implement Gaussian elimination and backsubstitution for square linear systems of equations. Test your code on a random matrix that is diagonally dominant. Document the code and the example in your software manual.
### Response

### Sources

## Task 2
Create a code from the code in Task 1 of this tasksheet to implement LU-factorization for solving a square linear system. If you have not implemented a forward substituion code, do so. Document all codes created in the task with entries in your software manual.
### Response

### Sources

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
