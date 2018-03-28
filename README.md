# i4 Scanner

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

i4 was not terrible.  i3 and the code provided for this
project helped set up how the code and formatting would
look.  This project was all about building upon the last
project and using the old project as a template it was
easy to build up the context free grammar.  The eval
function in this assignment did get more complex and
having to insert an if statement or a while loop required
a little more thinking and logic, but nothing to hard.

## Testing

Testing was done using the code examples provided on
the Trello card.  All examples used the wide range of
features and nodes added, so all of them have been
tested and have passed.
