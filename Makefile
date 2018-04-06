#Makefile creates bash scripts that are set up to work in Linux, not MacOS.
PROGS=build Interpreter.sh Scanner.sh

all:$(PROGS)

build:
	javac ./src/*.java
	mkdir bin
	mv ./src/*.class ./bin

Interpreter.sh:
	echo -ne '#!/bin/bash\n' > $@
	echo -ne 'cd bin\n' >> $@
	echo -ne 'java Interpreter "$$*"\n' >> $@
	chmod 754 $@

Scanner.sh:
	echo -ne '#!/bin/bash\n' > $@
	echo -ne 'cd bin\n' >> $@
	echo -ne 'java Scanner "$$*"\n' >> $@
	chmod 754 $@



clean:
	rm -rf bin
	rm -f Scanner.sh
	rm -f Interpreter.sh
