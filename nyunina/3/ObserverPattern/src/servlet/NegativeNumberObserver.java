package servlet;

public class NegativeNumberObserver extends Observer
{

	public void update(Integer number1, Integer number2) {
		if(number1<0 && number2<0) 
		{
			this.writeToFile("d:\\Java\\MeraCourse_JavaEE\\ObserverPattern\\output\\negativeNumbers.txt", number1, number2);
		}
	}
		
	
}
