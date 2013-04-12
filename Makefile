JFLAGS = 
JC = javac
OBJDIR = bin
.SUFFIXES: .java .class
%.class:
		$(JC) $(JFLAGS) $*.java -sourcepath src/ -d bin/

%mkdir:
		mkdir -p $(OBJDIR)

CLASSES = \
		src/*.java \
		src/**/*.java

default: %mkdir classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) -r bin
