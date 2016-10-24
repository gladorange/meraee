package servlet;

public class PositiveNumberObserver extends Observer
{
	@Override
	public void update(Integer number1, Integer number2) {
		if(number1>0 && number2>0) 
		{
			writeToFile("d:\\Java\\MeraCourse_JavaEE\\ObserverPattern\\output\\positiveNumbers.txt", number1, number2);
		}
	}
	

}
