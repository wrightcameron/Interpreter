# i5 Functions

* Author: Cameron Wright
* Class: CS354

## Overview

Parser for the interpreter, takes in strings and gives the parse tree.

## Compiling and Using

The Interpreter is now built using a Makefile. In the
root project directory run the following command.

$ make

This will also create two bash scripts Interpreter.sh and Scanner.sh,
these will launch the two java driver classes without having to
cd through the dir.

To run the Interpreter

$ ./Interpreter.sh "program"

example 

$  ./Interpreter.sh "x=3"
$ ./Interpreter.sh "x=3; myvar=25; abc=555557"
$  ./Interpreter.sh "wr (((x+2)+2)+2)"

To run the Scanner follow the same steps,

$ ./Scanner.sh "program"

Results of the program for both will print on the console.

## Discussion

i5 took alot more thought that I thought it was going to take.
Adding the new function classes and handling the functions in the
parser was easy and followed the same steps that the previous
project did.  The difficulty started when I found out that I did
not know how I was going to add the arguments to the function 
when I could call it.  Took some more thinking and making new
classes and afterwards I was able to get this code to work.

## Testing

Testing was done using the code examples provided on 
the Trello card.  All examples used the wide range of 
features and nodes added, so all of them have been 
tested and have passed.