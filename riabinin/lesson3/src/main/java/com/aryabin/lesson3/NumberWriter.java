package com.aryabin.lesson3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NumberWriter {
	
	private String fileName;
	private File file;

	public NumberWriter(String fileName) {
		this.fileName = fileName;
		
		file = new File(fileName + ".txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("Create file " + file.getAbsolutePath());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else {
			System.out.println("File " + file.getAbsolutePath() + " already exist");
		}
	}
	
	public void Write(String string) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(getFileName(), true);
			fileWriter.write(string);
			fileWriter.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public String getFileName() {
		return fileName + ".txt";
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
