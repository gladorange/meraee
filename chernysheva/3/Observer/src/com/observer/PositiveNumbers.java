package com.observer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PositiveNumbers implements Observer{
	File positiveNumbers;		
	
	public PositiveNumbers() throws IOException{	
		positiveNumbers = new File("PositiveNumbers");
	}

	@Override
	public void update(int n1, int n2) {
        if ((n1 > 0) && (n2 > 0))
        {
        	try {
        	    FileWriter fileWritter = new FileWriter(positiveNumbers.getName(),true);
        	    BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        	    String text = n1 + " " + n2 + " ";
            
			    bufferWritter.write(text);
			    bufferWritter.close();  
			    fileWritter.close();
		    } 
            catch (IOException e) {
			    e.printStackTrace();
		    }
        }
	}
}
