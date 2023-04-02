
FILE_NAME := texto.txt
#Look for FILE_NAME in the entire file system starting from the root directory and set the FILE_PATH variable to its full path. If there is
#more than 1 file with the same name, select the most recent one.
FILE_PATH := $(shell sudo find / -name "$(FILE_NAME)" -type f -printf '%T@ %p\n' 2>/dev/null | sort -rn | head -1 | cut -d' ' -f2-)

all: clean build test check_files exec

clean:
	@mvn clean -q

check_files:
        #If there is more than 1 file with the same name, it prints a warning message to the console. It then prints a list of all the file paths 
	#found. Finally, it prints a message indicating which file will be used (the most recent one based on the file's modification time).
	@file_paths=$$(sudo find / -name "$(FILE_NAME)" -type f); \
	count=$$(echo "$$file_paths" | wc -l); \
	if [ $$count -gt 1 ]; then \
		echo "\n\033[1;33m[WARNING]\033[0m Found $$count files with the same name:"; \
		echo "$$file_paths" | sed 's/^/- /'; \
		echo "\nUsing the most recent file: $(FILE_PATH)"; \
	fi

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
	@sudo mvn exec:java -Dexec.args="$(FILE_PATH)" -q

