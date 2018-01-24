# i1 Scanner 

* Author: Cameron Wright
* Class: CS354

## Overview

Scanner for interpreter, takes in strings and tokenizes the letters, numbers, etc.

##Manifest

|Filename       | Description                                                       |
|---------------|-------------------------------------------------------------------|
|README.md      |File file                                                          |
|Scanner.java   |Scanner for interpreter                                            |
|Token.java     |Class for token object used in scanner                             |
|SyntaxException.java |Exception for syntax errors                                  |

## Compiling and Using

In directory containing all the files, run the following command.

$ javac Scanner.java

After code has compiled with no errors run the next command.

$ java Scanner "x=1; myvar=3"

Results of the program will print on the console.

## Discussion

Hardest part was reading the code and understanding what was going on, 
after that the coding itself wasn’t difficult.  The part that made me 
think the hardest was trying to determine how to handle “=” and “;”, both 
don’t have a set they are a part of like numbers or letters and the write
up did not say where it wanted them.  I did handle them at first by using 
an else if, one for each.  After that I wanted to simplify the code and allow 
expansion so I put both in a set called operators that might change or be 
modified in the future.

## Testing

Testing was done by running the string input "x=1; myvar=3" and matching the given output 
on Trello.
