
FILE_NAME := non-existent.txt

all: clean build test exec

clean:
	@mvn clean -q

build:
	@mvn compile -q


test:
	@echo "\n[INFO] Running testEmptyFile..."
	@echo "\n[INFO] Running testNoFileNameProvided..."
	@echo "\n[INFO] Running testInvalidFileName...";
	@echo "\n[INFO] Running testMultipleWordsWithSameFrequency...";
	@echo "\n[INFO] Running testHighestFrequency...";
	@echo "\n[INFO] Running testOneWord...";
	@echo "\n[INFO] Running testAllSameFrequency...";
	@mvn test -q 

exec:
	@mvn exec:java -Dexec.args="$(FILE_NAME)" -q

