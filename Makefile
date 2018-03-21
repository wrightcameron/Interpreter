#Makefile creates bash scripts that are set up to work in Linux, not MacOS.
PROGS=build Interpreter.sh Scanner.sh

all:$(PROGS)

build:
	mvn compile

Interpreter.sh:
	echo -ne '#!/bin/bash\n' > $@
	echo -ne 'cd target/classes\n' >> $@
	echo -ne 'java interpreter/Interpreter "$$*"\n' >> $@
	chmod 754 $@

Scanner.sh:
	echo -ne '#!/bin/bash\n' > $@
	echo -ne 'cd target/classes\n' >> $@
	echo -ne 'java interpreter/Scanner "$$*"\n' >> $@
	chmod 754 $@



clean:
	mvn clean
	rm -f Scanner.sh
	rm -f Interpreter.sh
