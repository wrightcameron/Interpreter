#Makefile creates bash scripts that are set up to work in Linux, not MacOS.
PROGS=build Interpreter.sh Scanner.sh

all:$(PROGS)

build:
	javac ./src/*.java
	mkdir bin
	mv ./src/*.class ./bin

Interpreter.sh:
	echo '#!/bin/bash\n' > $@
	echo 'cd bin\n' >> $@
	echo 'java Interpreter "$$*"\n' >> $@
	chmod 754 $@

Scanner.sh:
	echo '#!/bin/bash\n' > $@
	echo 'cd bin\n' >> $@
	echo 'java Scanner "$$*"\n' >> $@
	chmod 754 $@



clean:
	rm -rf bin
	rm -f Scanner.sh
	rm -f Interpreter.sh
