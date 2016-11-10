package com.seprokof.eebasic.impl;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.seprokof.eebasic.Observer;

public class PositiveObservable implements Observer {
	private static final Path pathToFile = Paths.get("positiveNumbers.txt").toAbsolutePath();

	@Override
	public void setNumbers(int first, int second) {
		if (first > 0 && second > 0) {
			writeToFile(first + " " + second);
		}
	}

	@Override
	public Path getFileName() {
		System.out.println("PositiveObservable path -> " + pathToFile.toString());
		return pathToFile;
	}

}
