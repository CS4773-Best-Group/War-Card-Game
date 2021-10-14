MAIN := src/main
GAME := src/game
MODELS := src/models
CP := classes

all: build_jar clean

build_jar: models game main
	jar -cfv hw2.jar $(CP)

models: $(MODELS)
	javac -sourcepath src -d $(CP) $(MODELS)/*.java

game: $(GAME)
	javac -sourcepath src -d $(CP) $(GAME)/*.java

main: $(MAIN)
	javac -sourcepath src -d $(CP) $(MAIN)/*.java

clean:
	rm -r $(CP)/*