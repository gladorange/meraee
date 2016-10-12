package com.observer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NegativeNumbers implements Observer{
	File negativeNumbers = new File("NegativeNumbers");	
	
	public NegativeNumbers() throws IOException{
		negativeNumbers = new File("negativeNumbers");
	}

	@Override
	public void update(int n1, int n2) {
        if ((n1 < 0) && (n2 < 0))
        {
        	try {
        	    FileWriter fileWritter = new FileWriter(negativeNumbers.getName(),true);
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
