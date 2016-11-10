package com.seprokof.eebasic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public interface Observer {
	void setNumbers(int first, int second);

	Path getFileName();

	default void writeToFile(String stringToWrite) {
		try {
			if (stringToWrite != null && !stringToWrite.isEmpty()) {
				if (!stringToWrite.endsWith("\n")) {
					stringToWrite += '\n';
				}
				Files.write(getFileName(), stringToWrite.getBytes(), StandardOpenOption.APPEND,
						StandardOpenOption.CREATE);
			}
		} catch (IOException e) {
			System.err.println("Unable to write data to file: " + e.getMessage());
		}
	}
}
