# Tasksheet 2

## Task 1
After deciding which programming language you will use,
write a program that provides a response like that in the "Hello World!"
output. Provide details of the compilation and execution of the code
you write. Use a suitable response for the Python line "...it's only a
bunny..."
### Response

I wrote the following code to inform of the language I will be using for this course. I will use Java with use of gradle to run from the command line. 



If needed I will plot in python, and if there is any parallel programming needed at a faster/lower level, I will use c++
    
    public class main {
        public static void main(String args[])
        {
            //TASKSHEET 2 Task 1 -- state which language you will be using by printing to the console.
            System.out.println("Brother Maynard, get me the holy hand grenade!");
            System.out.println("I will be using Java for the bulk of the coding projects, but for plotting I will use python's graphing capabilities.");


        }

    }

I did not create a Software Manual Page for this code, since I was just printing to the console. If there needs to be a manual page, I will wait to be informed before adding it in. However, the link to the actual code is included below.

### Sources or links
The link will be made active when the code for Task 5 is completed. 
[Source Code]() 

is marked by comments for Task 1 and Task 5.

## Task 2
Edit the main README.md file in your Math 4610 repository
    on Github using your favorite browser. This means logging on to your
    Github account, navigating to the README.md file in the math4610
    repository, and editing the file on Github. In the README.md file,
    create an introduction that describes what the repository is being
    created for and put in a link to the table of contents for the homework
    problems and a link to the software manual you will create. Do this in
    Markdown - not html.
### Response
I have edited and added the link to both of the Table of Contents. On this Table of Contents there is a link to the Software Manual Table of Contents that can be used, and vise versa.

### Sources or links
[README.md Main](https://github.com/nicoleefleming/math4610/blob/master/README.md)

## Task 3
Create the table of contents in a file with a name like

        toc/task_toc.md

     or something like this. After completing the tasks to this point, clone
     the repository to a local directory on a local computer using git. If you
     have already cloned the repository, use a

        koebbe% git pull

     command to pull the changes to your local copy of the repository..
### Response
I already have two Table of Contents files in my math4610 repository. One is in the homework folder, and has quick links to each tasksheet .md file. It also contains a link 
to the Software Manual table of contents. Both files are named TableofContents.md.

I have also pulled a clone of my repository.

### Sources or links
[Tasksheet Table of Contents](https://github.com/nicoleefleming/math4610/blob/master/TableofContents.md)

[Software Manual Table of Contents](https://github.com/nicoleefleming/math4610/blob/master/softwareManual/TableofContents.md)

## Task 4
Now for something completely different - write out the
    analysis for the centered difference approximation in a Taylor series
    expansions. Show that the approximation is second order.
### Response
I have a link to the pdf in case the embedded file does not display that I included below. 

The HTML markdown is not working in Chrome, or Safari. I have not tested in Firefox or IE, but the link works.


<object data="https://github.com/nicoleefleming/math4610/blob/master/hw/hw2/Untitled-Artwork.pdf" type="application/pdf" width="700px" height="700px"> 
    <p>This browser does not support PDFs. Please download the PDF to view it: <a href="https://github.com/nicoleefleming/math4610/blob/master/hw/hw2/Untitled-Artwork.pdf">Download PDF</a>.
        </p>
</object>
    
        


### Sources or links
[HandWork pdf](https://github.com/nicoleefleming/math4610/blob/master/hw/hw2/Untitled-Artwork.pdf)

## Task 5
Determine the order of accuracy of the central difference
    approximation of the second derivative. That is, analyze the approximation
    
         f''(x) ~= (f(x+h) - 2 f(x) + f(x-h))/(h^2)
    
    via Taylor series expansions. Write a code that approximates the second
    derivative of the function
   
         f(x) = cos(x)
    
    at the point, x=2.0. Use, h=1.0,0.5,0.1,0.01,0.001,. . . .,10^{-16}\).
    Create a table of difference values between the "exact" value of the second derivative.
### Response



### Sources or links
[]()

## Task 6
Search the internet for information regarding finite
    difference approximations of derivatives of different orders. Give
    examples of these types of approximations. You should be able to find
    many such examples. Write a brief paragraph (3 or 4 sentences) that
    describe your findings. Include links to the sites you cite.

### Response
I found papers written about the Elliptic ODE aprroximation. I was more fascinated with the applications of this and the applications of the non-constant difference approximations. I found that you can model plasma waves with the Elliptic. I found that the non-constant form of this difference approximation models flux. Some others that I found were: with focus in math, theres the forward difference, central difference and backwards difference approximations. The biggest application that comes to my mind is in machine learning, with the search engines. 


### Sources or links
[Mathematics of Machine Learning (Chapter 5)](https://mml-book.github.io/book/mml-book.pdf)   

[Plasma Wave Modeling-Japanese](https://www.jstage.jst.go.jp/article/jpsj/74/5/74_5_1431/_article/-char/ja/)   

[Math Stack Exchange Discussion](https://math.stackexchange.com/questions/1509291/numerical-solution-of-non-constant-coefficient-diffusion-equation-via-finite-dif)   

For a more information on flux I googled flux and read the definition that resulted.
