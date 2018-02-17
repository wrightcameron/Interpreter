# i1 Scanner 

* Author: Cameron Wright
* Class: CS354

## Overview

Parser for the interpreter, takes in strings and gives the parse tree.

## Compiling and Using

In directory containing all the files, run the following command.

$ javac Interpreter.java

After code has compiled with no errors run the next command.

$ java Interpreter "program"

example 

$ java Interpreter "x=3"
$ java Interpreter "x=3; myvar=25; abc=555557"
$ java Interpreter "wr (((x+2)+2)+2)"

Results of the program will print on the console.

## Discussion

i3 was more challenging than the previous projects.  I think 
my biggest stuggle was trying to understand how env method in
all the nodes was to be handled.  the functions on the white
board made sense but with multiple or statements and the 
return statement at first I was very confused.

## Testing

Testing was giving the program different strings and seeing if
 grammatically correct strings would pass and those wrong 
 would fail.  Of course, "x=3" and “myvar=25; abc=555557” did 
 pass but I also tried other types of strings.