FILE_NAME := texto.txt
FILE_PATH := $(shell sudo find / -name "$(FILE_NAME)" -type f -printf '%T@ %p\n' 2>/dev/null | sort -rn | head -1 | cut -d' ' -f2-)

all: clean check_files build exec

clean:
	@mvn clean -q

check_files:
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
	@mvn test -q

exec:
	@mvn exec:java -Dexec.args="$(FILE_PATH)" -q
