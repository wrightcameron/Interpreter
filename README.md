# i1 Scanner 

* Author: Cameron Wright
* Class: CS354

## Overview

Parser for the interpreter, takes in strings and gives the parse tree.

##Manifest

|Filename       | Description                                                       |
|---------------|-------------------------------------------------------------------|
|README.md      |File file                                                          |
|Scanner.java   |Scanner for interpreter                                            |
|Token.java     |Class for token object used in scanner                             |
|SyntaxException.java |Exception for syntax errors                                  |
|Interpreter.java| driver class 													|
|NodeAssn.java| Node assign															|
|NodeBlock.java| Node block Class 													|
|Node.java| Node Super class  														|
|NodeStmt.java| Node statement Class 												|
|Parser.java| Parser class that takes tokens and creates a parse tree 				|

## Compiling and Using

In directory containing all the files, run the following command.

$ javac Interpreter.java

After code has compiled with no errors run the next command.

$ java Interpreter "program"

example 

$ java Interpreter "x=3"
$ java Interpreter "x=3; myvar=25; abc=555557"

Results of the program will print on the console.

## Discussion

Adding the parser and the node blocks was not terribly difficult.  
Once I understood what the node class was and how I was going to 
make a bunch of sub node blocks it was easy to follow along.  
The next project i3 will be harder I can tell as it involves 
adding the rest of the grammar to this program.

## Testing

Testing was giving the program different strings and seeing if
 grammatically correct strings would pass and those wrong 
 would fail.  Of course, "x=3" and “myvar=25; abc=555557” did 
 pass but I also tried other types of strings.  In the future 
 though and with i3 it would be good idea to automate the 
 testing, and a testing framework with i3 will be given for 
 integration testing.
