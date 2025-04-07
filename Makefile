JFLAGS=-g -sourcepath src -cp lib/classes:lib/runtime:src:src/Parse:.
CUPFLAGS=-parser Grm -symbols sym

Full: Parse/Grm.java
	cp src/Parse/*.class .
	javac ${JFLAGS} src/*/*.java
	rm *.class

Parse/Grm.java: src/Parse/Grm.cup
	cd src/Parse && cat Grm.cup | java -cp ../../lib/classes:../../lib/runtime java_cup.Main ${CUPFLAGS}
	mv src/Parse/Grm.java src/Parse/Grm.java.new
	mv src/Parse/Grm.java.new src/Parse/Grm.java
	mv src/Parse/sym.java src/Parse/sym.java.new
	mv src/Parse/sym.java.new src/Parse/sym.java

Parse/*.class: Parse/*.java
	javac ${JFLAGS} src/Parse/*.java

clean:
	cp src/Parse/*.class ./.
	rm -f src/*/*.class src/Parse/Grm.java src/Parse/Grm.err src/Parse/Grm.out src/Parse/sym.java
	mv *.class ./src/Parse/
