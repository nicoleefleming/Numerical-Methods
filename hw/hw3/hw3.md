# Tasksheet 3

## Task 1
Computationally verify that the central difference approximation for the second derivative approximation defined in Task Sheet 2, Task 5 is actually second order accurate. Using values of h≠0, compute the approximation and the difference between the exact value and the approximation. Print out the data in columns like those presented in the notes for the first order approximation of the the first derivative.
### Response





### Sources or links
 
[]() 



## Task 2
Produce a log-log plot of the error from the data in Task 1. Discuss how the results show that the approximation is second order accurate over a range of value where 
h>0. Also, determine when the approximation begins to fail due to finite precision in the number representation and/or finite precision of arithmetic. You will need to write a code that produces the plot. If needed, you can use the Python code in the notes
### Response


### Sources or links
[]()

## Task 3
Write routines that will produce the machine epsilon as discussed in class. Write two separate routines, one for the single precision setting on your computer and one for double precision. Compile and test each of of these routines separately. This means writing a main() program in separate files.
### Response
The single machine precision code is as follows:

    public float smaceps()
    {
        //initialize and declare variables.
        float approx = 0;
        //initialize x1 to 1, and seps to 1
        float x1 = 1;
        float seps = 1;
        //set approx = x1 + seps
        approx = x1 + seps;
        //declare an iteration variable
        int iters = 0;

        while(approx != 1)
        {
            //update seps, divide it by two each iteration to get closer to seps = 0
            seps = seps/2;
            //update the approximation
            approx = x1 + seps;
            //increment the iteration counter
            iters = iters + 1;
            //when approx is equal to 1, or close enough to 1 that the
            // computer can't track the small number, exit loop
        }

        System.out.println("The single precision iterations: " + iters + "\n");
        return seps;
     }

The double machine precision code is as follows:

    public double dmaceps()
    {
        //initialize and declare variables.
        double approx = 2.0;
        //initialize x1 to 1, and seps to 1
        double x1 = 1.0;
        double deps = 1.0;
        //set approx = x1 + seps
        //approx = x1 + seps;
        //declare an iteration variable
        int iters = 0;

        while(approx != 1)
        {
            //update seps, divide it by two each iteration to get closer to seps = 0
            deps = deps/2.0;
            //update the approximation
            approx = x1 + deps;
            //increment the iteration counter
            iters = iters + 1;
            //when approx is equal to 1, or close enough to 1 that the
            // computer can't track the small number, exit loop
        }

        System.out.println("The single precision iterations: " + iters + "\n");
        return deps;
     }

The results for single machine precision: 
     
     Iterations:  24
     Epsilon:     5.9604644775390625E-8
     
The results for double machine precision:
     
     Iterations:  53
     Epsilon:     1.1102230246251565E-16

Both of these methods are part of the class precision.java. This will be added into the .jar file created in Task 5.

### Sources or links
[Single Machine Precision - smaceps](https://github.com/nicoleefleming/math4610/blob/master/softwareManual/Pages/smaceps.md)

[Double Machine Precision - dmaceps](https://github.com/nicoleefleming/math4610/blob/master/softwareManual/Pages/dmaceps.md)

## Task 4
In this task you will be asked to begin a software manual for the various routines that you will be creating over the semester. The software manual will span the entire semester and should include a lot of your work. The following steps should help organize your work.
Within your terminal, create folders to include the software pages in the math4610 repository. Create a folder using something like

                  koebbe% mkdir software_manual

                
Then create a file that will contain a table of contents for pages that are created for individual routines. Maybe something like

                  koebbe% cd software_manual
                  koebbe% vim software_manual_toc.md

                 
When you edit the file, create a unique link for each new software page added. There is a Markdown template that provides an example of what is expected . You can make a copy of the templacte file in the folder created above. Then edit the file to create a page for your code. For example, create a page for the single precison version of the code from Task 3.

                  koebbe% cp softwareManual/softwareManualTemplate.md smaceps.md

                 
or

                   koebbe% cp softwareManual/softwareManualTemplate.md smaceps.html
                   koebbe% vim smaceps.html

                 
depending on whether or not you want to use MathJax for math notation.
Build the links to the individual pages in the table of contents file by adding an entry to the table for each routine.
Build the link from your README.md repository file at the top level. That is, add a line like

                  [Software Manual Table of Contents:](./software_manual/software_manual_toc.md)

                
There are a lot of ways to do this. The steps above should provide the structure you need. You might consider building a template for the pages from the page you can download and make copies from the template.
### Response
I have created a Software Manual. I have linked the Table of Contents below. There is currently one function that is not a required function to document, but shows the template of the other functions that will be written this semester. 
### Sources or links
[Software Manual](https://github.com/nicoleefleming/math4610/blob/master/softwareManual/TableofContents.md)

## Task 5
This task will walk you through the development of a shared library for your routines from the two routines written and tested in this tasksheet. Suppose that the two routines are named, smaceps() and dmaceps().
Create two files that contain only the code for the routines for the machine epsilon computation. No main() method is needed.
Compile each of the files using an object name. For example

                  koebbe% gcc -o smaceps smaceps.c
                  koebbe% gcc -o dmaceps dmaceps.c

                
or

                  koebbe% gcc -o *.c

                
This will produce two files:

                  koebbe% ls *.o
                  dmaceps.o  smaceps.o
                  koebbe%

                
Created a shared library,

                  koebbe% ar cvf mylib dmaceps.o smaceps.o

                
This is the archive command in Unix and the "cvf" informs the archive command to create, be verbose, and use the file name specified for the library. The output will be a file of the form

                  koebbe% ls mylib.a
                  mylib.a
                
                
Make the library a random access library.

                  koebbe% ranlib mylib.a
                
                
This last step allows a link/load command to access the routines in any order.

### Response
(10/7) I am in the process of creating a .jar file. However, currently in my .gitignore file I have excluded it from being uploaded. I can upload it manually if needed for this task. 

I will upload a version of the .jar file after the next tasksheet to keep a current running version available here. For this tasksheet, I will create it, and I will add the java class ( precision.java with smaceps and dmaceps) to it. 


### Sources or links
[]()

[]()
#### Software Manual Page Links
[]()

## Task 6
Search the internet for discussions of shared libraries. Write a brief summary of what you find including the pros and cons of shared libraries. Your write up should be a brief paragraph (3 or 4 sentences) that describe your findings. Include links to the sites you cite.

### Response
This is a way of being able to use multiple a.out files without the need to hard code them into teh file one is working on. This provides a library, similar to those one may import, or include from the database for the IDE one may use. It is beneficial since it allows the machine to save on disk sotrage space, memory, and makes executable files in the library easier to maintain. They also provide a way to update  libraries and still support programs that want to use older, non-backward-compatible versions of those libraries.


### Sources or links
[What is a shared library?](http://osr507doc.sco.com/en/tools/ShLib_WhatIs.html#:~:text=A%20shared%20library%20is%20a,Instead%2C%20a%20special%20section%20called%20.)   

[Shared Libraries](https://tldp.org/HOWTO/Program-Library-HOWTO/shared-libraries.html)   

[Difference between Static and Shared Libraries](https://www.geeksforgeeks.org/difference-between-static-and-shared-libraries/)   
