package es.molabs.kata.stringcalculator;

public class Calculator 
{	
	private CalculatorInputParser inputParser;
	
	public Calculator(String delimiter)
	{
		inputParser = new CalculatorInputParser(delimiter);
	}
	
	public int add(String numbers)
	{
		return
			inputParser.parse(numbers)
				.getParameterList()
				.stream()
				.reduce(0, (accumulated, value) -> accumulated + value);
	}
}
