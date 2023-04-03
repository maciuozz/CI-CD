
FILE_NAME := non-existent.txt

all: clean build test exec

clean:
	@sudo mvn clean -q

build:
	@sudo mvn compile -q


test:
	@echo "\n[INFO] Running testEmptyFile..."
	@echo "\n[INFO] Running testNoFileNameProvided..."
	@echo "\n[INFO] Running testInvalidFileName...";
	@echo "\n[INFO] Running testMultipleWordsWithSameFrequency...";
	@echo "\n[INFO] Running testHighestFrequency...";
	@echo "\n[INFO] Running testOneWord...";
	@echo "\n[INFO] Running testAllSameFrequency...";
	@sudo mvn test -q 

exec:
	@sudo mvn exec:java -Dexec.args="$(FILE_NAME)" -q

