package com.mera.observer;

import java.io.FileWriter;
import java.io.IOException;

public class PositiveObserver implements Observer{

	@Override
	public void notify(int n1, int n2) {
		// TODO Auto-generated method stub
		if (n1 > 0 && n2 > 0) {
			try(FileWriter writer = new FileWriter("D:\\positiveNumbers.txt", false)) {
				try {
					writer.write(Integer.toString(n1) + Integer.toString(n2));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					writer.flush();
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
